package io.desentupidora.targetfinder.model.service;

import io.desentupidora.targetfinder.api.model.TargetModel;
import io.desentupidora.targetfinder.model.repository.TargetRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SponsoredTargetFinderService {
    private static final String AGENTS = "Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148";
    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";
    private static final List<String> SEARCH_TERMS = List.of("desentupidora", "dedetização");
    private static final String DIV = "div[class^='uEierd']";
    private static final Integer THREAD_POOL_SIZE = 5;
    private final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    private final ConcurrentSkipListSet<TargetModel> targets = new
            ConcurrentSkipListSet<>(Comparator.comparing(TargetModel::getTitle));
    @Autowired
    private TargetRepository targetRepository;

    public SponsoredTargetFinderService() {
        start();
    }

    public void start() {

        scheduledExecutor.scheduleAtFixedRate(() -> {
            this.targets.clear();
            SEARCH_TERMS.forEach(term -> {
                try {

                    Connection connection = Jsoup.newSession().url(GOOGLE_SEARCH_URL + term).userAgent(AGENTS);
                    Document html = connection.get();
                    Elements elements = html.select(DIV);
                    elements.forEach(element -> {
                        String elementLink = element.select("a").attr("href");
                        this.targets.add(assembleTarget(elementLink));
                    });

                    this.targets.stream()
                            .filter(targetModel -> targetRepository.findByTitle(targetModel.getTitle()).isEmpty())
                            .forEach(unregisteredTarget -> {
                                System.out.println(">>>> Pending register!" +
                                        "\n>>>> Title: " + unregisteredTarget.getTitle()
                                        + "\n>>>> " + unregisteredTarget.getUrl() + "\n");
                            });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }, 0, 3, TimeUnit.MINUTES);
    }

    public Optional<List<TargetModel>> getValidTargets() {

        LinkedList<TargetModel> targetModels = new LinkedList<>();
        targets.forEach(targetModel -> targetRepository.findByTitle(targetModel.getTitle())
                .ifPresent(target -> targetModels.add(new TargetModel(target))));
        return Optional.of(targetModels);
    }

    private TargetModel assembleTarget(String elementLink) {
        try {
            Connection connection = Jsoup.newSession().url(elementLink).userAgent(AGENTS);
            String baseUri = connection.request().url().toString();
            String title = connection.get().title();
            return TargetModel.builder().url(baseUri).title(title).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

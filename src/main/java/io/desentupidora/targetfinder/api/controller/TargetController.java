package io.desentupidora.targetfinder.api.controller;

import io.desentupidora.targetfinder.api.model.TargetModel;
import io.desentupidora.targetfinder.api.model.inputModel.TargetInput;
import io.desentupidora.targetfinder.model.domain.Target;
import io.desentupidora.targetfinder.model.repository.TargetRepository;
import io.desentupidora.targetfinder.model.service.SponsoredTargetFinderService;
import jakarta.validation.Valid;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/targets")
public class TargetController {

    private static final String AGENTS = "Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148";
    @Autowired
    private SponsoredTargetFinderService service;
    @Autowired
    private TargetRepository targetRepository;

    @GetMapping
    public ResponseEntity<List<TargetModel>> getTargets() {
        return service.getValidTargets().map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TargetModel> addTarget(@Valid @RequestBody TargetInput targetInput) throws IOException {

        try {
            String title = Jsoup.connect(targetInput.getUrl()).userAgent(AGENTS).get().title();
            Optional<Target> existingTarget = targetRepository.findByTitle(title);
            if (existingTarget.isPresent()) {
                return ResponseEntity.ok(new TargetModel(existingTarget.get()));
            } else {
                Target newTarget = targetRepository.save(new Target(title, targetInput));
                return ResponseEntity.ok(new TargetModel(newTarget));
            }
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

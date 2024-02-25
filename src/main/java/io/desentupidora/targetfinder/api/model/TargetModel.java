package io.desentupidora.targetfinder.api.model;

import io.desentupidora.targetfinder.model.domain.Target;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
public class TargetModel {

    private UUID uuid;
    private String title;
    private String url;
    private String whatsappNumber;

    @Builder
    public TargetModel(UUID uuid, String title, String url, String whatsappNumber) {
        this.uuid = uuid;
        this.title = title;
        this.url = url;
        this.whatsappNumber = whatsappNumber;
    }

    public TargetModel(Target target) {
        this.uuid = target.getUuid();
        this.title = target.getTitle();
        this.url = target.getUrl();
        this.whatsappNumber = target.getWhatsappNumber();
    }
}

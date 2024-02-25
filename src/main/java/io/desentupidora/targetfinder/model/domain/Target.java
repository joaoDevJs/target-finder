package io.desentupidora.targetfinder.model.domain;

import io.desentupidora.targetfinder.api.model.inputModel.TargetInput;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String title;
    private String url;
    @Column(name = "whatsapp_number")
    private String whatsappNumber;

    public Target() {
    }

    public Target(String title, String url, String whatsappNumber) {
        this.title = title;
        this.url = url;
        this.whatsappNumber = whatsappNumber;
    }

    public Target(String title, TargetInput targetInput) {
        this.title = title;
        this.url = targetInput.getUrl();
        this.whatsappNumber = targetInput.getWhatsappNumber();
    }
}

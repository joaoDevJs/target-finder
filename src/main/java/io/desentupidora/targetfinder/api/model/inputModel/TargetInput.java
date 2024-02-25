package io.desentupidora.targetfinder.api.model.inputModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class TargetInput {

    @URL
    private String url;
    @NotBlank
    @Pattern(regexp = "^\\+?55(?:[1-9]{2})?9?\\d{8}$")
    private String whatsappNumber;
}

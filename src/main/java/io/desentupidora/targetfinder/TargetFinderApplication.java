package io.desentupidora.targetfinder;

import io.desentupidora.targetfinder.model.service.SponsoredTargetFinderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextServices;

@SpringBootApplication
public class TargetFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TargetFinderApplication.class, args);

    }

}

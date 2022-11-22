package com.barrosoc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class FruitEventConsumer {

    @Inject
    JuiceMakerService juiceMakerService;

    @Incoming("fruit")
    public void consume(String fruit) {
        juiceMakerService.makeJuice(fruit);
    }
}

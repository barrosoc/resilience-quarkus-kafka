package com.barrosoc;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class FruitEventConsumer {

    @Incoming("greetings")
    public void consume(String message) {

    }
}

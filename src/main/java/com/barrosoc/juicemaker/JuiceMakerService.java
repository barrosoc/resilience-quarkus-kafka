package com.barrosoc.juicemaker;

import static org.apache.commons.lang3.StringUtils.capitalize;

import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class JuiceMakerService {

    public void makeJuice(String fruit) {
        log.info("Making %s juice...".formatted(fruit));
        log.info("%s juice done :)".formatted(capitalize(fruit)));
    }
}

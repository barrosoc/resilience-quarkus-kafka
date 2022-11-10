package org.example;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

public class InfrastructureTestResource implements QuarkusTestResourceLifecycleManager {

    private static final DockerImageName KAFKA_TEST_IMAGE =
        DockerImageName.parse("confluentinc/cp-kafka:6.1.8");

    static KafkaContainer kafka = new KafkaContainer(KAFKA_TEST_IMAGE);

    @Override
    public Map<String, String> start() {
        kafka.start();

        return configurationParameters();
    }

    private Map<String, String> configurationParameters() {
        return Map.of("%integration-test.kafka.bootstrap.servers", kafka.getBootstrapServers());
    }

    @Override
    public void stop() {
        if (kafka != null) {
            kafka.stop();
        }
    }
}

package com.barrosoc;

import static org.mockito.Mockito.verify;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

import com.google.common.collect.ImmutableMap;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.mockito.InjectSpy;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestProfile(IntegrationTestProfile.class)
public class FruitEventConsumerIT {

    @InjectSpy
    private FruitEventConsumer fruitEventConsumer;

    private KafkaProducer<String, String> producer;

    @BeforeEach
    void setUp() {
        producer =
            new KafkaProducer<>(
                ImmutableMap.of(
                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    InfrastructureTestResource.kafka.getBootstrapServers(),
                    ProducerConfig.CLIENT_ID_CONFIG,
                    UUID.randomUUID().toString()),
                new StringSerializer(),
                new StringSerializer());
    }

    @Test
    void shouldConsumeIncomingMessage() throws ExecutionException, InterruptedException {
        final var message = "Hello";

        producer
            .send(
                new ProducerRecord<>(
                    "greetings",
                    "greeting-key",
                    message))
            .get();

        await().untilAsserted(() -> verify(fruitEventConsumer).consume(message));
    }

    @Test
    void shouldCallConsumeIncomingMessage() throws ExecutionException, InterruptedException {
        final var message = "Hello";

        producer
            .send(
                new ProducerRecord<>(
                    "greetings",
                    "greeting-key",
                    message))
            .get();

        await().untilAsserted(() -> verify(fruitEventConsumer).consume(message));
    }
}
package org.example;

import io.quarkus.test.junit.QuarkusTestProfile;
import java.util.Collections;
import java.util.List;

public class IntegrationTestProfile implements QuarkusTestProfile {

    public static final String INTEGRATION_TEST_PROFILE_NAME = "integration-test";

    @Override
    public String getConfigProfile() {
        return INTEGRATION_TEST_PROFILE_NAME;
    }

    @Override
    public List<TestResourceEntry> testResources() {
        return Collections.singletonList(new TestResourceEntry(InfrastructureTestResource.class));
    }
}

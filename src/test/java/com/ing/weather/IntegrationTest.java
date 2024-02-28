package com.ing.weather;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface IntegrationTest {
}

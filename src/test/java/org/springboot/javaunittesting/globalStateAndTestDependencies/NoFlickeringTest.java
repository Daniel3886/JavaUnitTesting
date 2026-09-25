package org.springboot.javaunittesting.globalStateAndTestDependencies;

import org.apache.logging.log4j.LoggingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class NoFlickeringTest {

    @Mock
    LoggingPropertyConfigurator configurator;

    @InjectMocks
    BaseServletContextListener listener;

    // clean logConfig, before shouldLoadDefaultProperties() method is executed
    @BeforeEach
    void cleanSystemProperty() {
        System.setProperty("logConfig", null);
    }

    // never expect order execution, tests should test individual behavior of components
    @Test
    void shouldLoadDefaultProperties() {
        listener.contextInitialized(null);
        verify(configurator).configure(any(Properties.class));
    }

    @Test
    void shouldThrowLoggingException() {
        System.setProperty("logConfig", "nonExistetingFile");

        assertThrows(LoggingException.class, () -> listener.contextInitialized(null));
    }

}
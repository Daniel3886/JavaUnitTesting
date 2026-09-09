package org.springboot.javaunittesting.smartvalues;

import org.junit.jupiter.api.Test;
import org.springboot.javaunittesting.smartValues.PriceCalculator;
import org.springboot.javaunittesting.smartValues.PriceCalculatorFactory;
import org.springboot.javaunittesting.smartValues.SettingsService;

import java.lang.management.MonitorInfo;
import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PriceCalculatorFactoryTest {

    // use contents to avoid magic numbers
    private static final BigDecimal MIN_MARGIN = new BigDecimal(20);
    private static final BigDecimal MAX_MARGIN = new BigDecimal(30);
    private static final BigDecimal PREMIUM_SHARE = new BigDecimal(10);

    // settings is a collaborator and as such should be stubbed in test.
    SettingsService settings = mock(SettingsService.class);

    @Test
    void shouldCreatePriceCalculator() {
        // given
        given(settings.getMinMargin()).willReturn(MIN_MARGIN);
        given(settings.getMaxMargin()).willReturn(MAX_MARGIN);
        given(settings.getPremiumShare()).willReturn(PREMIUM_SHARE);

        // when
        PriceCalculator calculator =
                new PriceCalculatorFactory(settings).create();

        // then
        assertThat(calculator)
                .isEqualTo(new PriceCalculator(MIN_MARGIN, MAX_MARGIN, PREMIUM_SHARE));

    }
}

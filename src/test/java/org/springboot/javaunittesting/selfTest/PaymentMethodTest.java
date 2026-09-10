package org.springboot.javaunittesting.selfTest;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentMethodTest {

    @Test
    void shouldGetMethodsForPoland() {
        // given
        List<PaymentMethod> all = Lists.newArrayList(PaymentMethod.values());
        List<PaymentMethod> methodsAvailableInPoland = Lists.newArrayList(
                // the list of expected values is independently known and not coupled
                        PaymentMethod.BANK_TRANSFER,
                        PaymentMethod.MASTERCARD,
                        PaymentMethod.VISA
        );

        // with this approach, however, the test does not independently verify the business requirement.
        //  It verifies that the filtering operation (isEligibleForCountry) and the expected-value calculation agree.
        // also if isEligibleForCountry is bugged, both GIVEN and WHEN will be wrong
//        for(PaymentMethod method: all){
//            if(method.isEligibleForCountry("PL")){
//                methodsAvailableInPoland.add(method);
//            }
//        }

        // when
        List<PaymentMethod> methodsForCountry = PaymentMethod
                .getMethodsForCountry("PL", all);

        // then
        assertThat(methodsForCountry).isEqualTo(methodsAvailableInPoland);
    }
}

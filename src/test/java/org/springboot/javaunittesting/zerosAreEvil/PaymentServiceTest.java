package org.springboot.javaunittesting.zerosAreEvil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PaymentServiceTest {

    PaymentAdapter paymentAdapter = mock(PaymentAdapter.class);
    PaymentService paymentService = new PaymentService(paymentAdapter);

    @Test
    void shouldReturnRevenueForClient() {
        // given
        Client client = new Client();
        given(paymentAdapter
                .getRevenue(client, PaymentService.REPORT_COUNT)).willReturn(1.23); // using a zero here doesnt make sense because there's nothing wrong with 0

        // when
        double actual = paymentService.getRevenue(client);

        // then
        assertThat(actual).isEqualTo(1.23); // here as well, but adding another value other than 0 allows us to really see if the program works
     }
}

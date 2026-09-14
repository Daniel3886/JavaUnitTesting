package org.springboot.javaunittesting.changeTestAfterCodeIsChanged;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// when you change the code, the test should reflect that change as well,
// otherwise the tests will be invalid for the new implementation and therefore
// will be useless and won't catch any bugs in the new implementation
class TransactionTest {

    @Test
    void shouldRecognizeTransactionsWithZeroValueAsInvalid() {
        // given
        Transaction transaction = new Transaction(BigDecimal.ZERO, new InternalUser());

        // when
        boolean actualUser = transaction.validate();

        // then
        assertThat(actualUser).isFalse();
    }


    @Test
    void shouldRecognizeTransactionWithNegativeValueAsInvalid() {
        // given
        Transaction transaction = new Transaction(BigDecimal.valueOf(-1), new InternalUser());

        // when
        boolean actualUser = transaction.validate();

        // then
        assertThat(actualUser).isFalse();

    }

}
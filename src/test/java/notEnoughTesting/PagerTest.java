package notEnoughTesting;

import org.junit.jupiter.api.Test;
import org.springboot.javaunittesting.notEnoughTesting.Pager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PagerTest {

    private static final int PER_PAGE = 10;


    // Leaving only this test case (shouldGiveZeroWhenOnZeroPage) and not making other tests will cause
    // the Pager class to be not enough tested. The other test cases are needed to cover all the scenarios
    // and edge cases of the Pager class.

    // This covers the scenario of being on the first page and checking the offset.
    @Test
    public void shouldGiveZeroWhenOnZeroPage() {
        Pager pager = new Pager(PER_PAGE);

        assertThat(pager.getOffset()).isEqualTo(0);
    }

    // This test case covers the scenario of being on the first page
    // and checking the offset after going to the next page.
    @Test
    public void shouldIncreaseOffsetWhenOnNextPage() {
        // given
        Pager pager = new Pager(PER_PAGE);

        // when
        pager.goToNextPage();

        // then
        assertThat(pager.getOffset()).isEqualTo(PER_PAGE);
    }

    // This test case covers the scenario of being on the second page
    // and checking the offset after going to the next page twice.
    @Test
    public void shouldIncreaseOffsetWhenOnNextPageTwice() {
        // given
        Pager pager = new Pager(PER_PAGE);

        // when
        pager.goToNextPage();
        pager.goToNextPage();

        // then
        assertThat(pager.getOffset()).isEqualTo(PER_PAGE * 2);
    }

}
package expectingExceptionsEverywhere;



import org.junit.jupiter.api.Test;
import org.springboot.javaunittesting.expectingExceptionsEverywhere.MaliciousMyList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


// Bad test
public class MaliciousMyListTest {


    // The test will fail because the MaliciousMyList constructor throws an IndexOutOfBoundsException,
    // which is not caught by the test. The test should be modified to catch the exception and assert that it is thrown.
    @Test
    public void testMyList() {
        MaliciousMyList<Integer> list = new MaliciousMyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertThat(4 == list.get(4));
        assertThat(2 == list.get(1));
        assertThat(3 == list.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
    }


    // this test also suffers from the same problem
    @Test
    public void testNegative() {
        MaliciousMyList<Integer> list = new MaliciousMyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
}


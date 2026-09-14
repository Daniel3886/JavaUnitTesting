package org.springboot.javaunittesting.expectingExceptionsEverywhere;

import org.junit.jupiter.api.Test;
import org.springboot.javaunittesting.expectingExceptionsEverywhere.MyList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyListCatchExceptionTest {

    // This test is a good test because it catches the exception and asserts that it is thrown.
    // and the constructor of MyList does not throw an exception, so the test will pass.
    @Test
    void shouldThrowWhenTryingToGetElementOutsideFromTheList() {
        MyList<Integer> list = new MyList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

}

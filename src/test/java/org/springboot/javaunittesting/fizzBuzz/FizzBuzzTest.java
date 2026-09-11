package org.springboot.javaunittesting.fizzBuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    // Instead of making multiple test methods for each unique value,
    // we can parameterize the test method to run multiple times with different values.
    @ParameterizedTest // run the same test with different values: testMultipleOfThreeAndFivePrintsFizzBuzz(15)...
    @ValueSource(ints = {15, 30, 75}) // Actual values JUnit shold pass to the test method
    public void testMultipleOfThreeAndFivePrintsFizzBuzz(
            int multipleOfThreeAndFive) {

        assertEquals("FizzBuzz", FizzBuzz.getResult(multipleOfThreeAndFive));
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 36, 81})
    public void testMultipleOfThreePrintsFizz(
            int multipleOfThree) {
        assertEquals("Fizz", FizzBuzz.getResult(multipleOfThree));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 55, 100})
    public void testMultipleOfFivePrintsFizz(
            int multipleOfFive) {
        assertEquals("Buzz", FizzBuzz.getResult(multipleOfFive));
    }
}

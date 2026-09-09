package org.springboot.javaunittesting.noassertiontest;


import org.junit.jupiter.api.Test;
import org.springboot.javaunittesting.noasssertion.Format;
import org.springboot.javaunittesting.noasssertion.IResult;

import java.util.Iterator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class noAssertionTest {

    private Format format;

    @Test
    public void badTest() {
        IResult result = format.execute();
        // no assertion, meaning we also have to
        // manually check the output to see if the test passed or failed
        System.out.println(result.size());

        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            IResult r = (IResult) iter.next();

            // no assertion as well
            System.out.println(r.getMessage());
        }
    }

    @Test
    public void betterVersion() {
        IResult result = format.execute();

        // the testing framework will automatically check the assertion
        // and report a failure if it does not pass
        assertThat(result.size()).isEqualTo(3);

        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            IResult r = (IResult) iter.next();

            // asserting error if the message contains the word "error"
            assertThat(r.getMessage()).contains("error");
        }
    }
}

package org.springboot.javaunittesting.isMockitoWorkingFine;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FormTest {

    // this test doesn't check the Form class but instead the Mockito Framework
    // So even if the Form class in empty, the test will pass because we are mocking the Form class
    // and not using the real implementation
    @Test
    void testFormUpdate() {
        // given
        Form f = Mockito.mock(Form.class);
        Mockito.when(f.isUpdateAllowed()).thenReturn(true);

        // when
        boolean result = f.isUpdateAllowed();

        // then
        assertTrue(result);
    }

    // this, however, does check the Form class and will fail
    // if the implementation sucks
    @Test
    void testFormUpdateWithoutMocks() {
        // given
        Form f = new Form();
        f.setUpdateAllowed(true);

        // when - then
        assertTrue(f.isUpdateAllowed());
    }
    // NOTE: if the logic is much more complex then we should use mockito to test the logic in isolation
    // and not the implementation of the class itself, but we would still mock the external dependencies of the class
    // and not the tested class itself!

}
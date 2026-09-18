package org.springboot.javaunittesting.mockingContainer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockingContainerTest {

    @Mock
    private Context context;

    // bad test, because we want to verify if the outcome itself, not how it was achieved
    // in the context of the test, we are verifying the interaction with the mock, which is not what we want to test
    @Test
    public void shouldAddTimeZoneToModelAndView() {
        // given
        ModelAndView modelAndView = mock(ModelAndView.class);
        given(context.getTimezone()).willReturn("timezone X");

        // when
        new UserDataInterceptor(context)
                .postHandle(null, null, null, modelAndView);

        // then
        // how the outcome was achieved, (in what order the construction added the elements) ❌
        verify(modelAndView).addObject("timezone", "timezone X");

    }

    // good test, because we are verifying the outcome itself, not how it was achieved
    @Test
    void shouldAddTimeZoneToModelAndView_Improved() {
        // given
        ModelAndView modelAndView = new ModelAndView();
        given(context.getTimezone()).willReturn("timezone X");

        // when
        new UserDataInterceptor(context)
                .postHandle(null, null, null, modelAndView);

        // then
        // verifying the outcome itself (the model contains the expected entry), not how it was achieved
        assertThat(modelAndView.getModel()).containsEntry("timezone", "timezone X");
    }
}

package org.springboot.javaunittesting.mockingContainer;

import org.springframework.web.servlet.ModelAndView;

public class UserDataInterceptor {
    private final Context context;

    public UserDataInterceptor(Context context) {
        this.context = context;
    }

    public void postHandle(Object o, Object o1, Object o2, ModelAndView modelAndView) {
        modelAndView.addObject("timezone", context.getTimezone());
    }
}



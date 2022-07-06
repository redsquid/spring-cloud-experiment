package ru.redsquid.examples.ms.order.filters;

import org.springframework.util.Assert;

public class UserContextHolder {

    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static UserContext getUserContext() {
        UserContext context = userContext.get();
        if(context == null) {
            context = new UserContext();
            userContext.set(context);
        }
        return context;
    }

    public static void setContext(UserContext context) {
        Assert.notNull(context, "Only non-null UserContext instances are permitted");
        userContext.set(context);
    }
}

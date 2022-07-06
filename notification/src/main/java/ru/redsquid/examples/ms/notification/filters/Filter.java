package ru.redsquid.examples.ms.notification.filters;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class Filter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        System.out.println("@@@ (CORRELATED-ID) NOTIFICATION: doFilter: tmx-correlation-id = " + request.getHeader("tmx-correlation-id"));
        filterChain.doFilter(request, servletResponse);
    }
}

package com.luis.springcloud.app.gateway.filters;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class SampleGlobalFilter implements Filter, Ordered{

    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(request, response);
    }

}
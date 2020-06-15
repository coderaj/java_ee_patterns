package com.readlearncode;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;


@WebFilter(filterName = "log",
            urlPatterns = "/admins/*",
            servletNames = "AdminRequestHandler")
public class LogFilter implements Filter {
    @Inject
    private Logger logger;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info(servletRequest.getContentType());
        filterChain.doFilter(servletRequest, servletResponse);

        logger.info(servletResponse.getContentType());
    }
}

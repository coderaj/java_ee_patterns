package com.readlearncode;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "authentication",
            urlPatterns = "/admins/*",
            servletNames = "AdminRequestHandler")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if(httpServletRequest.getSession().getAttribute("userType").equals("ADMIN")){
            filterChain.doFilter(httpServletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("/admin-login.html");
        }
    }
}

package com.chori.springbootfilter.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/user")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) servletRequest).getRequestURL().toString();
            String queryString = ((HttpServletRequest) servletRequest).getQueryString();
            System.out.println("url: " + url);
            System.out.println("queryString: " + queryString);
        }

        System.out.println("Do Filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}

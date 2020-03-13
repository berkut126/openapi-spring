/*package com.boots;

import javax.servlet.Filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;



@WebFilter("/filter-response-header/** ")
public class myfilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader(
          "Baeldung-Example-Filter-Header", "Value-Filter");
        chain.doFilter(request, response);
    }
}*/
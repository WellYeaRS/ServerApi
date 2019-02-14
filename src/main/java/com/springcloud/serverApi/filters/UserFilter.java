package com.springcloud.serverApi.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/",filterName = "userFilter")
public class UserFilter implements Filter{
    private static ThreadLocal<Long> users;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        users = new ThreadLocal<>();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        Object user = httpRequest.getSession().getAttribute("user");
        if(user != null){
            users.set((Long)user);
        }
        chain.doFilter(httpRequest,response);
    }

    @Override
    public void destroy() {

    }
    public static Long getUserId(){
        return users.get();
    }
}

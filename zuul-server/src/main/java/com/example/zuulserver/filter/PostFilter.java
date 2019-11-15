package com.example.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("Post Filter");
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().setCharacterEncoding("UTF-8");    //處理返回中文亂碼
        String responseBody = ctx.getResponseBody();
        if(null == responseBody){
            ctx.setResponseStatusCode(500); //返回狀態碼
            ctx.setResponseBody(responseBody);  //替換響應報文
        }
        return null;
    }
}

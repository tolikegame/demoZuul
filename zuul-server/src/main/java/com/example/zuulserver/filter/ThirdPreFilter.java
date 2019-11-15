package com.example.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class ThirdPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("logic-is-success");   //從context拿到logic-is-success值,判斷Filter是否執行
    }

    @Override
    public Object run() {
        System.out.println("第三次Zuul Filter");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String b = request.getParameter("b");
        if(null == b){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("{\"status\":500,\"messages\":\"b參數為空\"}");
            ctx.set("logic-is-success",false);
            return null;
        }
        return null;
    }
}

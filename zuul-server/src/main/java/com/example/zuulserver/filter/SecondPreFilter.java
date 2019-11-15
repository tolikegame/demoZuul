package com.example.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class SecondPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("第二次Zull Filter");
        RequestContext ctx = RequestContext.getCurrentContext();    //取得context
        HttpServletRequest request = ctx.getRequest();  //取得 HttpServletRequest
        String a = request.getParameter("a");   //取得 a 參數值

        if(null == a){
            ctx.setSendZuulResponse(false); //禁止路由,禁止訪問下游服務
            ctx.setResponseBody("{\"status\":500,\"messages\":\"a參數為空\"}"); //設定responseBody供PostFilter使用
            ctx.set("logic-is-success",false);  //保存context,同類型下游Filter執行開關
            return null;
        }
        ctx.set("logic-is-success",true);   //設置避免報空
        return null;
    }
}

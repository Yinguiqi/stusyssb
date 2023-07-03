package com.mht.stueaxm.lnterceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kirtico
 * @date 2023/7/2&10:10
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 加入一些共用请求头部信息
        request.setAttribute("common-msg", "好耶");

        // 过滤掉一些请求
        String ua = request.getHeader("User-Agent");
        String referer = request.getHeader("Referer");

        if(ua!=null && referer!=null) return true;                             // 返回 TRUE 进入业务层执行方法后返回
        else {
            // 返回参数加入返回体
            response.sendRedirect("/");
            return false;                                                      // 返回 FALSE 不执行业务直接携带返回体返回
        }
   }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    /**
     * 将返回对象序列化后加入返回体
     * @param response
     * @param res
     * @throws IOException
     */

}

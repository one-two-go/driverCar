package com.sunhao.web;

import com.sunhao.entity.Driver;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：driverCar
 * 类 名 称：UserInterceptor
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:49 下午
 * 创 建 人：sunhao
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
//        Driver loginDriver = (Driver)request.getSession().getAttribute("user");
//        if(loginDriver==null) {
//            request.getRequestDispatcher("/login").forward(request, response);
//            return false;
//        }
        return true;
    }
}

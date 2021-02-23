//package com.briup.cms.web.Interceptor;
//
//import com.briup.cms.util.JwtUtil;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class JwtInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
//    	// 如果不是映射到方法直接通过
//    	if(!(object instanceof HandlerMethod)){
//    		return true;
//    	}
//
//        // 从 http 请求头中取出 token
//        String token = httpServletRequest.getHeader("token");
//
//        if (token == null) {
//            throw new RuntimeException("无token，请先登录获取token");
//        }
//
//        // 验证 token
//        JwtUtil.checkSign(token);
//
//        /*
//        String userId = JwtUtil.getUserId(token);
//        System.out.println("id:" + userId);
//
//        Map<String, Object> info = JwtUtil.getInfo(token);
//        info.forEach((k,v)->System.out.println(k+":"+v));
//		*/
//
//        return true;
//    }
//
//}
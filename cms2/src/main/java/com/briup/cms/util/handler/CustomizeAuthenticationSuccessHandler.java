//package com.briup.cms.util.handler;
///*
// * 方法描述
// *
// * $ 参数描述
// * @author create by 作者 on $ $
// * @return $
// */
//
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//    private static final Logger logger = LoggerFactory.getLogger(CustomizeAuthenticationSuccessHandler.class);
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        logger.info("AT onAuthenticationSuccess(...) function!");
//        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        logger.info("login--IP:"+details.getRemoteAddress());
//
//
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication1 = context.getAuthentication();
//        Object principal = authentication1.getPrincipal();
//        Object principal1 = authentication.getPrincipal();
//
//        String name = authentication.getName();
//        logger.info("login--name:"+name+" principal:"+principal+" principal1:"+principal1);
//
//        PrintWriter out = null;
//        try {
//
//            out = response.getWriter();
//
////            out.append(JSONObject.toJSONString(ResponseData.ok().putDataValue("user",principal)
////                    .putDataValue("name",name)));
//        } catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if (out != null) {
//                out.close();
//            }
//        }
//    }
//}

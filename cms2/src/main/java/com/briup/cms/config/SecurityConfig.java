//package com.briup.cms.config;
///*
// * 方法描述
// *  登录权限控制
// * $ 参数描述
// * @author create by 作者 on $ $
// * @return $
// */
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsUtils;
//
////@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return  new BCryptPasswordEncoder();
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.formLogin()//自定义自己编写的登录页面
//////                .loginPage("/http://localhost:8081/#/login")
//////                //和表单提交的接口一样,回去执行自定义登录逻辑
////                .loginProcessingUrl("/user/login")
//////                //登陆成功跳转页面
//////                .defaultSuccessUrl("/test/hello")
////                .and().authorizeRequests()
//////                //对于不登录就可以访问页面进行设置。
////                    .antMatchers( "/user/login","/","/userlogin.html","/user/findByUsername").permitAll()
////////                    .antMatchers("/test/hello").hasRole("sale")
////                .anyRequest().authenticated()
////                .and().cors().and()
////                .csrf().disable()
////                ;
//        //放行option请求
////        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
//    http
//            .csrf().disable()//csrf:跨站请求伪造
//            .anonymous().disable()
//            .cors().and().httpBasic()
//            .and()
//            .formLogin()
//            //指定url，可由相应的controller处理跳转到登录页如login_page.html
//            .loginPage("/user/login")//自定义登录url
//            //指定自定义form表单请求的路径
//            .loginProcessingUrl("/user/login").usernameParameter("userName").passwordParameter("passWord")
//            //.defaultSuccessUrl("/success")
//            .failureUrl("/fail");//设置了登入登出的Handler,优先响应Handler
//
//
//        UserDetails userDetails  = (UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal();
//    }
//}

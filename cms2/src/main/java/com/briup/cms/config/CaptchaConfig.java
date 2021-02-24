//package com.briup.cms.config;
///*
// * 方法描述
// *
// * $ 参数描述
// * @author create by 作者 on $ $
// * @return 验证码配置类$
// */
//
//import com.google.code.kaptcha.impl.DefaultKaptcha;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
////@Configuration
//public class CaptchaConfig {
//    @Bean
//    public DefaultKaptcha defaultKaptcha(){
//        //验证码生成器
//        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
//        //配置
//        Properties properties = new Properties();
//        //是否有边框
//        properties.setProperty("kaptcha.border","yes");
//        //设置边框颜色
//        properties.setProperty("kaptcha.border.color","105.179.90");
//        //边框粗细度，默认为1
//        properties.setProperty("kaptcha.border.thickness","1");
//        //验证码
//        properties.setProperty("kaptcha.border.key","code");
//
//    }
//
//
//}

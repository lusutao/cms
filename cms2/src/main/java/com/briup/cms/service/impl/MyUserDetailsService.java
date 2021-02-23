//package com.briup.cms.service.impl;
///*
// * 方法描述
// *
// * $ 参数描述
// * @author create by 作者 on $ $
// * @return $
// */
//
//import com.briup.cms.dao.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.AuthorityUtils;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("userDetailsService")
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //调用 userDao中查询数据库，根据用户名查询数据库
//        com.briup.cms.bean.User byUsername = userDao.findByUsername(username);
//        if (byUsername==null){
//            //数据库没有该用户，认证失败
//            throw new UsernameNotFoundException("用户不存在");
//        }
//
//        //用户权限集合
//        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
//        //从查询数据库返回bean中的user对象，通过其账号密码进行校验
//        User user = new User(byUsername.getUsername(), new BCryptPasswordEncoder().encode(byUsername.getPassword()), authorities);
//        return user;
//    }
//}
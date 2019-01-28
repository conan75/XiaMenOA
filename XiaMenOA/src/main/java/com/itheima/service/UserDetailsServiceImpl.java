package com.itheima.service;

import com.itheima.domain.TbUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class UserDetailsServiceImpl implements UserDetailsService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了UserDetailsServiceImpl");
        //构建角色列表
        List<GrantedAuthority> grantAuths = new ArrayList();

        //得到商家对象
        TbUser user = userService.findOne(username);
        if (user != null) {
            if (user.getUsableFlag()==0) {
                if ("zhangsan".equals(user.getUserName())){
                    grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }else{
                    grantAuths.add(new SimpleGrantedAuthority("ROLE_ASSISTANT"));
                }
                System.out.println(user.getUserName());
                return new User(username, user.getUserPassword(), grantAuths);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}

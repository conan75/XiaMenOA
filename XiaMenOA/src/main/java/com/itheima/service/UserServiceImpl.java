package com.itheima.service;

import com.itheima.domain.TbUser;
import com.itheima.domain.TbUserExample;
import com.itheima.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser checkLogin(String username, String password) {
        TbUserExample userExample=new TbUserExample();
        userExample.createCriteria().andUserNameEqualTo(username).andUserPasswordEqualTo(password);
        List<TbUser> users = tbUserMapper.selectByExample(userExample);
        if (!StringUtils.isEmpty(users)&&users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public TbUser findOne(String username) {
        TbUserExample example = new TbUserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if (!StringUtils.isEmpty(tbUsers)&&tbUsers.size()>0){
            return tbUsers.get(0);
        }
        return null;
    }
}

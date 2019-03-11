package com.haichao.service.impl;

import com.haichao.dao.UsersMapper;
import com.haichao.model.Users;
import com.haichao.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @Desc </p>
 * @Author yusj
 * @Date 2019/3/11
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public boolean login(String username, String passwd) {
        Users users = usersMapper.findByUsernameAndPasswd(username, passwd);
        return users != null;
    }

    @Override
    public boolean register(String username, String passwd) {
        Users users = new Users();
        users.setUser(username);
        users.setPassword(passwd);
        int cnt = usersMapper.insertSelective(users);
        return cnt > 0;
    }

    /**
     * 演示事务配置》  加@Transactional  即可。
     * @param username
     * @param passwd
     */
    @Override
    @Transactional
    public void batchAdd(String username, String passwd) {
        Users users = new Users();
        users.setUser(username);
        users.setPassword(passwd);
        usersMapper.insertSelective(users);
        int i = 10 /0;
        users = new Users();
        users.setUser(username+"2");
        users.setPassword(passwd);
        usersMapper.insertSelective(users);
    }
}

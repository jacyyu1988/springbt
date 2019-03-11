package com.haichao.user;

import com.haichao.App;
import com.haichao.dao.UsersMapper;
import com.haichao.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 * @Author yusj
 * @Date 2019/3/11
 * @Version 1.0
 */
@SpringBootTest(classes= App.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Resource
    private UsersMapper usersMapper;

    @Test
    public void testAdd() {
        Users user = new Users() ;
        user.setUser("yusj");
        user.setPassword("********");
        usersMapper.insertSelective(user);
    }

    @Test
    public void testFindUser() {
        Users enjoy = usersMapper.findByUsernameAndPasswd("yusj", "********");
        System.out.println(enjoy);
    }
}

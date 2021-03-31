package com.yykj.mybatis;

import com.yykj.mybatis.dao.IUserDao;
import com.yykj.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusInsert {

    @Autowired
    private IUserDao userDao;

    /**
     * insert
     */
    @Test
    public void mybatisPlusInsert(){
        User user = new User();
        user.setId(10L);
        user.setName("tony");
        user.setAge(30);
        user.setEmail("dasf@qq.com");
        userDao.insert(user);
    }

    /**
     * 自动生成主键信息
     */
    @Test
    public void mybatisPlusInsertAutoID(){
        // TODO: 自动生成ID
        User user = new User();
        user.setName("sum");
        user.setAge(20);
        user.setEmail("3324@qq.com");
        userDao.insert(user);
    }
}

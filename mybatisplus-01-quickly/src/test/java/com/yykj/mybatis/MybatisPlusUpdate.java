package com.yykj.mybatis;

import com.yykj.mybatis.dao.IUserDao;
import com.yykj.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusUpdate {

    @Autowired
    private IUserDao userDao;

    /**
     * 自动填充字段信息
     */
    @Test
    public void mybatisPlusUpdate(){
        User user = new User();
        user.setId(0L);
        user.setName("HAHAHAHAHAHHA");
        userDao.updateById(user);
    }

    /**
     * 乐观锁 成功
     */
    @Test
    public void mybatisPlusOptimisticLocker(){
        //1、查询用户信息
        User user = userDao.selectById(0L);
        //2、修改用户信息
        user.setName("ChanV");
        user.setEmail("1277077741@qq.com");
        //3、执行更新操作
        userDao.updateById(user);
    }

    /**
     * 乐观锁 失败
     */
    @Test
    public void mybatisPlusOptimisticLocker02(){
        User user = userDao.selectById(0L);
        user.setName("111");

        User user2 = userDao.selectById(0L);
        user2.setName("222");

        userDao.updateById(user2);
        userDao.updateById(user);
    }
}

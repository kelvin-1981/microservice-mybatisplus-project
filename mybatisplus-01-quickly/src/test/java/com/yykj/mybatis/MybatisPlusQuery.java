package com.yykj.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yykj.mybatis.dao.IUserDao;
import com.yykj.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MybatisPlusQuery {

    @Autowired
    private IUserDao userDao;

    /**
     * select
     */
    @Test
    public void mybaitsPlusQuery(){
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void mybaitsPlusSelectById(){
        User user = userDao.selectById(0);
        System.out.println(user);
    }

    @Test
    public void mybaitsPlusSelectBatchId(){
        List<User> users = userDao.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void mybaitsPlusSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义要查询
        map.put("name", "222");
        map.put("age", 20);
        List<User> users = userDao.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void mybaitsPlusPageQuery(){
        //参数一：当前页
        //参数二：页面大小
        //使用了分页插件之后，所有的分页操作也变得简单了！
        Page<User> page = new Page<>(1, 3);
        userDao.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    /**
     * 条件构造器
     * ge: >=20
     */
    @Test
    public void mybaitsPlusQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 20);
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 条件构造器
     * eq: ==
     */
    @Test
    public void mybaitsPlusQueryWrapper02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Jone");
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 条件构造器
     * between
     */
    @Test
    public void mybaitsPlusQueryWrapper03(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 50);
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 条件构造器
     * notLike: 不含
     * likeRight: t%
     */
    @Test
    public void mybaitsPlusQueryWrapper04(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "b").likeRight("email", "t");
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 条件构造器
     * notLike: 不含
     * likeRight: t%
     */
    void mybaitsPlusQueryWrapper05(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id < 3");
        List<Object> objects = userDao.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    /**
     * 条件构造器
     */
    @Test
    void mybaitsPlusQueryWrapper06(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> users = userDao.selectList(wrapper);
        users.forEach(System.out::println);
    }

}

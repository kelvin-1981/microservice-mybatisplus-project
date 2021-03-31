package com.yykj.mybatis;

import com.yykj.mybatis.dao.IUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
public class MybatisPlusDelete {

    @Autowired
    private IUserDao userDao;

    //测试删除
    @Test
    public void mybatisPlusDeleteById(){
        userDao.deleteById(0L);
    }

    @Test
    public void mybatisPlusDeleteBatchId(){
        userDao.deleteBatchIds(Arrays.asList(3, 4));
    }

    @Test
    public void mybatisPlusDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "陈伟");
        userDao.deleteByMap(map);
    }


}

package com.yykj.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yykj.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * mapper接口类
 */
@Repository
public interface IUserDao extends BaseMapper<User> {

}

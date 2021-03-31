package com.yykj.mybatis.service.impl;

import com.yykj.mybatis.pojo.User;
import com.yykj.mybatis.dao.UserMapper;
import com.yykj.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kelvin
 * @since 2021-03-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

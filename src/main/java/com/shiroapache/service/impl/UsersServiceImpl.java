package com.shiroapache.service.impl;

import com.shiroapache.mapper.UsersMapper;
import com.shiroapache.pojo.Users;
import com.shiroapache.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    /**
     * 根据用户名查询用户对象是否存在。
     * @param username
     * @return Users
     */
    @Override
    public Users selectByUsername(String username) {
        return usersMapper.selectByUsername(username);
    }

    /**
     * 根据用户名查询所有的角色信息
     *
     * @param username
     * @return
     */
    @Override
    public Set<String> selectRnamesByUserName(String username) {
        return usersMapper.selectRnamesByUserName(username);
    }

    /**
     * 查询所有角色的方法
     */
    @Override
    public Set<String> selectRolesAllRnames() {
        return usersMapper.selectRolesAllRnames();
    }
}

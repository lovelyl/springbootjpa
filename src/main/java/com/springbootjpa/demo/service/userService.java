package com.springbootjpa.demo.service;

import com.springbootjpa.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by liyuanlin on 2016/8/13.
 */
public interface userService {

    /**
     * 新增user
     * @param user
     * @return
     */
    public User addUser(User user);

    /**
     * 删除user
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 更新user
     * @param user
     * @return
     */
    public User updateUser(User user);

    /**
     * 查询单个user
     * @param id
     * @return
     */
    public User getOne(Integer id);

    /**
     * 查询所有user
     * @return
     */
    public List<User> getAll();

    /**
     * 查询所有user分页
     * @param pageable
     * @return
     */
    public Page<User> getAll(Pageable pageable);
}

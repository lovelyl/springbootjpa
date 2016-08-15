package com.springbootjpa.demo.service.Impl;

import com.springbootjpa.demo.domain.User;
import com.springbootjpa.demo.repository.userRepository;
import com.springbootjpa.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liyuanlin on 2016/8/13.
 */
@Service("userService")
@Repository
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {

        userRepository.delete(id);
    }

    @Override
    public User updateUser(User user) {
        User userupdate=userRepository.findOne(user.getId());
        if (userupdate.getName()!=null)
            userupdate.setName(user.getName());
        if (userupdate.getId()!=null)
            userupdate.setId(user.getId());
        if (userupdate.getEmail()!=null)
            userupdate.setEmail(user.getEmail());
        if (userupdate.getTelphoneNum()!=null)
            userupdate.setTelphoneNum(user.getTelphoneNum());
        userRepository.save(userupdate);
        return userupdate;
    }

    @Override
    public User getOne(Integer id) {

        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }
}

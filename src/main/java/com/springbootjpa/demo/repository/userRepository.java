package com.springbootjpa.demo.repository;

import com.springbootjpa.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liyuanlin on 2016/8/13.
 */
public interface userRepository extends JpaRepository<User,Integer> {
}

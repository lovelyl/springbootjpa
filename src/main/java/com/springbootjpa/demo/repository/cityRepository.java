package com.springbootjpa.demo.repository;

import com.springbootjpa.demo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liyuanlin on 2016/8/13.
 */
public interface cityRepository extends JpaRepository<City,Integer> {
}

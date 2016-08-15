package com.springbootjpa.demo.service;

import com.springbootjpa.demo.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by liyuanlin on 2016/8/13.
 */

public interface cityService {

    /**
     * 新增city
     * @param city
     * @return
     */
    public City addCity(City city);

    /**
     * 删除city
     * @param id
     */
    public void deleteCity(Integer id);

    /**
     * 修改city
     * @param city
     * @return
     */
    public City updateCity(City city);

    /**
     * 查询city
     * @param id
     * @return
     */
    public City getOne(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<City> getAll();

    /**
     * 查询所有分页
     * @param pageable
     * @return
     */
    public Page<City> getAll(Pageable pageable);

}

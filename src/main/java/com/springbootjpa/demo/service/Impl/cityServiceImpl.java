package com.springbootjpa.demo.service.Impl;

import com.springbootjpa.demo.domain.City;
import com.springbootjpa.demo.repository.cityRepository;
import com.springbootjpa.demo.service.cityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liyuanlin on 2016/8/13.
 */
@Service("cityService")
@Repository
public class cityServiceImpl implements cityService {

    @Autowired
    private cityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.delete(id);
    }

    @Override
    public City updateCity(City city) {
        City cityupdate=cityRepository.findOne(city.getId());
        if (cityupdate.getId()!=null)
            cityupdate.setId(city.getId());
        if (cityupdate.getName()!=null)
            cityupdate.setName(city.getName());
        if (cityupdate.getAreaNum()!=null)
            cityupdate.setAreaNum(city.getAreaNum());
        if (cityupdate.getArea()!=null)
            cityupdate.setArea(city.getArea());
        if (cityupdate.getCountry()!=null)
            cityupdate.setCountry(city.getCountry());
        cityRepository.save(cityupdate);
        return cityupdate;
    }

    @Override
    public City getOne(Integer id) {

        return cityRepository.findOne(id);
    }

    @Override
    public List<City> getAll() {

        return cityRepository.findAll();
    }

    @Override
    public Page<City> getAll(Pageable pageable) {

        return cityRepository.findAll(pageable);
    }
}

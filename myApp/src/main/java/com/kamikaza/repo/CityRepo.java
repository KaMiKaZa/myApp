package com.kamikaza.repo;

import com.kamikaza.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepo extends CrudRepository<City, Long>
{
    List<City> findByName(String name);
    List<City> findByPopulation(int population);
}

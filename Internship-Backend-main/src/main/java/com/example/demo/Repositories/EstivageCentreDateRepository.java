package com.example.demo.Repositories;


import com.example.demo.Entity.EstivageCentreDates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstivageCentreDateRepository extends CrudRepository<EstivageCentreDates,Integer> {

}

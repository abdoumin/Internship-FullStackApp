package com.example.demo.Repositories;

import com.example.demo.Entity.EstivageCentre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstivageCentreRepository extends CrudRepository<EstivageCentre, Integer> {

}

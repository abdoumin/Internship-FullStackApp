package com.example.demo.Repositories;


import com.example.demo.Entity.EstivageProduit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstivageProduitRepository extends CrudRepository<EstivageProduit,Integer> {

}

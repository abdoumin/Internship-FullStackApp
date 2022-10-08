package com.example.demo.Repositories;


import com.example.demo.Entity.EstivageCentrePhotos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstivageCentrePhotosRepository extends CrudRepository<EstivageCentrePhotos,Integer> {

}
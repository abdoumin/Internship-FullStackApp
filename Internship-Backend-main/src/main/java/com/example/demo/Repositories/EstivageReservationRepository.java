package com.example.demo.Repositories;

import com.example.demo.Entity.EstivageReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstivageReservationRepository extends CrudRepository<EstivageReservation,Integer> {

}

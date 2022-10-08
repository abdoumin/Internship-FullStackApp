package com.example.demo.dao;


import com.example.demo.Entity.*;
import com.example.demo.security.model.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Estivagedao {

    EstivageCentre createEstivageCentre(EstivageCentre estivageCentre);

//    EstivageCentre updateEstivageCentre(Integer id);

    void deleteEstivageCentre(Integer id);

    EstivageCentre getEstivageCentreById(Integer id);

    List<EstivageCentre> getAllEstivageCentres();

    List<EstivageProduit> getAllEstivageProduits(Integer id);

    EstivageProduit createEstivageProduit(EstivageProduit estivageProduit,EstivageCentre estivageCentre);

    void deleteEstivageProduit(Integer id);

    EstivageProduit getEstivageProduitById(Integer id);

//    EstivageReservation updateEstivageReservation(Integer id,EstivageReservation estivageReservation);

    EstivageReservation createEstivageReservation(Integer id, EstivageReservation estivageReservation);

    EstivageCentreDates createEstivageCentreDate(EstivageCentre estivageCentre, EstivageCentreDates estivageCentreDates);

    List<EstivageCentreDates> getEstivageCentreDates(Integer id);

    EstivageCentreDates getEstivageCentreDateById(Integer id);

    EstivageReservation addDateDeReservation(EstivageProduit estivageProduit, EstivageCentreDates estivageCentreDates,
                                         UserDao userDao);

    UserDao findByUsername(String username);

    EstivageCentre addPhoto(EstivageCentre estivageCentre, EstivageCentrePhotos estivageCentrePhotos);

    EstivageCentre addPhotos(EstivageCentre estivageCentre, List<EstivageCentrePhotos> estivageCentrePhotos);

    List<EstivageReservation> getEstivageReservationByUsername(UserDao userDao);









}

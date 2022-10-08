package com.example.demo.dao;

import com.example.demo.Entity.*;
import com.example.demo.Repositories.*;
import com.example.demo.security.model.UserDao;
import com.example.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstivageImpl implements Estivagedao{

    @Autowired
    EstivageCentreRepository estivageCentreRepository;

    @Autowired
    EstivageProduitRepository estivageProduitRepository;

    @Autowired
    EstivageReservationRepository estivageReservationRepository;

    @Autowired
    EstivageCentreDateRepository estivageCentreDateRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EstivageCentrePhotosRepository estivageCentrePhotosRepository;



    // CRUD OPERATIONS of Estivage Centre
    @Override
    public EstivageCentre createEstivageCentre(EstivageCentre estivageCentre) {
        return estivageCentreRepository.save(estivageCentre);
    }

    /*@Override
    public EstivageCentre updateEstivageCentre(Integer id,EstivageCentre UestivageCentre) {
        Optional<EstivageCentre> OestivageCentre = estivageCentreRepository.findById(id);
        EstivageCentre estivageCentre = OestivageCentre.get();
        UestivageCentre.setId(estivageCentre.getId());
        return estivageCentreRepository.save(UestivageCentre);

    }*/

    @Override
    public void deleteEstivageCentre(Integer id) {
        Optional<EstivageCentre> estivageCentre = estivageCentreRepository.findById(id);
        estivageCentreRepository.delete(estivageCentre.get());

    }

    @Override
    public EstivageCentre getEstivageCentreById(Integer id) {
        return estivageCentreRepository.findById(id).get();
    }

    @Override
    public List<EstivageCentre> getAllEstivageCentres() {
        return (List<EstivageCentre>) estivageCentreRepository.findAll();
    }

    @Override
    public List<EstivageProduit> getAllEstivageProduits(Integer id) {
        EstivageCentre estivageCentre = estivageCentreRepository.findById(id).get();
        return estivageCentre.getEstivageProduits();
    }

    //CRUD operations of Estivage Produit

    @Override
    public EstivageProduit createEstivageProduit(EstivageProduit estivageProduit,EstivageCentre estivageCentre) {
        if(!estivageCentre.getEstivageProduits().contains(estivageProduit))
        {
            estivageCentre.getEstivageProduits().add(estivageProduit);
        }
        estivageProduit.setEstivageCentre(estivageCentre);
        return estivageProduitRepository.save(estivageProduit);
    }



    @Override
    public void deleteEstivageProduit(Integer id) {
        Optional<EstivageProduit> estivageProduit = estivageProduitRepository.findById(id);
        estivageProduitRepository.delete(estivageProduit.get());

    }

    @Override
    public EstivageProduit getEstivageProduitById(Integer id) {
        if(estivageProduitRepository.findById(id).isPresent())
        {
            return estivageProduitRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

//    @Override
//    public EstivageReservation updateEstivageReservation(Integer id,EstivageReservation estivageReservation)
//    {
//        EstivageProduit estivageProduit = estivageProduitRepository.findById(id).get();
//        if(estivageProduit.getEstivageReservations()!=null)
//        {
//            EstivageReservation estivageReservation1 = estivageProduit.getEstivageReservations();
//            estivageReservation1.setDateDeDebut(estivageReservation.getDateDeDebut());
//            estivageReservation1.setDateDeFin(estivageReservation.getDateDeFin());
//            estivageReservationRepository.save(estivageReservation1);
//            return estivageReservation1;
//        }
//        else
//        {
//            return createEstivageReservation(id,estivageReservation);
//
//        }
//
//    }

    @Override
    public EstivageReservation createEstivageReservation(Integer id, EstivageReservation estivageReservation) {
        EstivageProduit estivageProduit = estivageProduitRepository.findById(id).get();
        estivageProduit.getEstivageReservations().add(estivageReservation);
        estivageReservation.setEstivageProduit(estivageProduit);
        return estivageReservationRepository.save(estivageReservation);
    }

    @Override
    public EstivageCentreDates createEstivageCentreDate(EstivageCentre estivageCentre, EstivageCentreDates estivageCentreDates) {
        estivageCentre.getEstivageCentreDates().add(estivageCentreDates);
        estivageCentreDates.setEstivageCentre(estivageCentre);
        return estivageCentreDateRepository.save(estivageCentreDates);
    }

    @Override
    public List<EstivageCentreDates> getEstivageCentreDates(Integer id) {
        EstivageCentre estivageCentre = estivageCentreRepository.findById(id).get();
        return estivageCentre.getEstivageCentreDates();

    }

    @Override
    public EstivageCentreDates getEstivageCentreDateById(Integer id) {
        return estivageCentreDateRepository.findById(id).get();
    }



    @Override
    public EstivageReservation addDateDeReservation(EstivageProduit estivageProduit, EstivageCentreDates estivageCentreDates,
                                                 UserDao userDao) {
        EstivageReservation estivageReservation = new EstivageReservation();
        estivageReservation.setDateDeDebut(estivageCentreDates.getStartDate());
        estivageReservation.setDateDeFin(estivageCentreDates.getEndDate());
        estivageReservation.setUserDao(userDao);
        estivageReservation.setEstivageProduit(estivageProduit);
        estivageProduit.getEstivageReservations().add(estivageReservation);
        return estivageReservationRepository.save(estivageReservation);
    }

    @Override
    public UserDao findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public EstivageCentre addPhoto(EstivageCentre estivageCentre, EstivageCentrePhotos estivageCentrePhotos) {
        estivageCentre.getEstivageCentrePhotos().add(estivageCentrePhotos);
        return estivageCentreRepository.save(estivageCentre);

    }

    @Override
    public EstivageCentre addPhotos(EstivageCentre estivageCentre, List<EstivageCentrePhotos> estivageCentrePhotos) {
        for(EstivageCentrePhotos estivageCentrePhotos1 : estivageCentrePhotos)
        {
            estivageCentrePhotos1.setEstivageCentre(estivageCentre);
            estivageCentre.getEstivageCentrePhotos().add(estivageCentrePhotos1);
            estivageCentreRepository.save(estivageCentre);
        }
        return estivageCentre;

    }

    @Override
    public List<EstivageReservation> getEstivageReservationByUsername(UserDao userDao) {
        return userDao.getEstivageReservations();
    }
}

package com.example.demo.controllers;


import com.example.demo.Entity.*;
import com.example.demo.dao.Estivagedao;
import com.example.demo.security.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000","http://localhost:3001","http://baridestivage.xyz/",
        "http://165.22.67.244:6868"})
public class Controller {

    @Autowired
    private Estivagedao estivagedao;

    //CREATE ESTIVAGE CENTRE
    @PostMapping("api/estivagecentre/create/")
    public EstivageCentre createEstivageCentre(@RequestBody EstivageCentre estivageCentre)
    {
        return estivagedao.createEstivageCentre(estivageCentre);
    }

    @RequestMapping("api/estivage/classe/{username}")
    public UserDao getUser(@PathVariable (name = "username") String username)
    {
        return estivagedao.findByUsername(username);
    }

    // GET ESTIVAGE CENTRE BY ID

    @RequestMapping("api/estivageCentre/{id}")
    public EstivageCentre getEstivageCentreById(@PathVariable(name = "id") Integer id)
    {
        return estivagedao.getEstivageCentreById(id);
    }

    // CREATE ESTIVAGE PRODUIT

    @PostMapping("api/estivageProduit/create/{hotelid}")
    public EstivageProduit createEstivageProduit(@PathVariable(name = "hotelid") Integer id,@RequestBody EstivageProduit estivageproduit)
    {
        EstivageCentre estivageCentre = estivagedao.getEstivageCentreById(id);
        EstivageProduit estivageProduit = estivagedao.createEstivageProduit(estivageproduit,estivageCentre);
        return estivageProduit;

    }

    //Get all Estivage Produits
    @RequestMapping("api/estivageproduit/all/{hotelid}")
    public List<EstivageProduit> getAllEstivageProduit(@PathVariable(name = "hotelid") Integer hotelid)
    {
        List<EstivageProduit> list = estivagedao.getAllEstivageProduits(hotelid);
        return list;
    }

    //Get All Estivage Centre
    @GetMapping("/api/estivagecentre/all")
    public List<EstivageCentre> getAllEstivageCentre()
    {
        return estivagedao.getAllEstivageCentres();
    }

    //UPDATE Estivage Centre
    @PutMapping("api/estivagecentre/update/{hotelId}")
    public EstivageCentre updateEstivageCentre(@PathVariable(name = "hotelId") Integer id,@RequestBody EstivageCentre newEstivage)
    {
        EstivageCentre estivageCentre = estivagedao.getEstivageCentreById(id);
        estivageCentre.setAdress(newEstivage.getAdress());
        estivageCentre.setCity(newEstivage.getCity());
        estivageCentre.setDes(newEstivage.getDes());
        estivageCentre.setName(newEstivage.getName());
        estivageCentre.setPhotos(newEstivage.getPhotos());
        estivageCentre.setRating(newEstivage.getRating());
        estivageCentre.setTitle(newEstivage.getTitle());
        estivageCentre.setType(newEstivage.getType());
        return estivagedao.createEstivageCentre(estivageCentre);
    }

    //DELETE Estivage Centre
    @DeleteMapping("api/estivagecentre/delete/{hotelId}")
    public void deleteEstivageCentre(@PathVariable(name = "hotelId") Integer id)
    {
        estivagedao.deleteEstivageCentre(id);
    }

    //CREATE ESTIVAGE RESERVATION

    @PostMapping("api/estivagereservation/create/{produitId}")
    public EstivageReservation createEstivageReservation(@PathVariable(name = "produitId") Integer id,@RequestBody EstivageReservation estivageReservation)
    {
        return estivagedao.createEstivageReservation(id,estivageReservation);
    }

//    UPDATE Estivage Produit Availaibility

//    @PutMapping("api/estivageProduit/update/{ProduitId}")
//    public EstivageProduit updateEstivageProduitAvailability(@PathVariable(name = "ProduitId") Integer id, @RequestBody EstivageReservation estivageReservation)
//    {
//        estivagedao.updateEstivageReservation(id,estivageReservation);
//        return estivagedao.getEstivageProduitById(id);
//    }

    //CREATE Estivage Centre Date
    @PostMapping("api/estivageCentreDate/{produitId}")
    public EstivageCentreDates createEstivageProduitDate(@PathVariable(name = "produitId") Integer id, @RequestBody EstivageCentreDates estivageCentreDates)
    {
        EstivageCentre estivageCentre = estivagedao.getEstivageCentreById(id);
        return estivagedao.createEstivageCentreDate(estivageCentre,estivageCentreDates);
    }

    @RequestMapping("api/estivageCentreDates/all/{produitId}")
    public List<EstivageCentreDates> getEstivageCentreDates(@PathVariable(name = "produitId") Integer id)
    {
        EstivageCentre estivageCentre = estivagedao.getEstivageCentreById(id);
        return estivagedao.getEstivageCentreDates(id);
    }

    // ADD Date de reservation
    @PostMapping("api/estivageProduit/{estivageId}/add/{estivageDateId}/{username}")
    public EstivageReservation addEstivageReservationDate(@PathVariable(name = "estivageId") Integer id,
                                                  @PathVariable(name = "estivageDateId") Integer dateid,
                                                  @PathVariable(name = "username") String username
                                                    )
    {
        EstivageProduit estivageProduit = estivagedao.getEstivageProduitById(id);
        EstivageCentreDates estivageCentreDates = estivagedao.getEstivageCentreDateById(dateid);
        UserDao userDao = estivagedao.findByUsername(username);
        return estivagedao.addDateDeReservation(estivageProduit,estivageCentreDates,userDao);

    }

    // GET Reservation dates by estivage produit
    @RequestMapping("api/estivageProduit/{estivageproduitId}/get/reservations")
    public List<EstivageReservation> getEtivageReservations(@PathVariable(name="estivageproduitId") Integer id)
    {
        EstivageProduit estivageProduit = estivagedao.getEstivageProduitById(id);
        return estivageProduit.getEstivageReservations();
    }

    //ADD ESTIVAGE PHOTOS
    @PostMapping("api/estivageCentre/{id}/add/estivagePhotos")
    public EstivageCentre addEstivagePhotos(@PathVariable(name = "id") Integer id,
                                            @RequestBody List<EstivageCentrePhotos> estivageCentrePhotos)
    {
        EstivageCentre estivageCentre = estivagedao.getEstivageCentreById(id);
        return estivagedao.addPhotos(estivageCentre,estivageCentrePhotos);

    }

    @RequestMapping("api/estivageReservations/user/{username}")
    public List<EstivageReservation> getEstivageReservationByUsername(@PathVariable(name = "username")String username)
    {
        UserDao userDao = estivagedao.findByUsername(username);
        return estivagedao.getEstivageReservationByUsername(userDao);
    }


}

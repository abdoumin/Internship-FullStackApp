package com.example.demo.Entity;

import com.example.demo.security.model.UserDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="estivage_reservation")
public class EstivageReservation {
    @Id
    @GeneratedValue
    private Integer id;

//    @JsonFormat(pattern="dd-MM-yyyy", timezone = "GMT+01:00")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateDeDebut;

    @Column(columnDefinition = "TIMESTAMP")
//    @JsonFormat(pattern="dd-MM-yyyy", timezone = "GMT+01:00")
    private LocalDateTime dateDeFin;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="estivage_produit_id")
//    @JsonIgnore
    EstivageProduit estivageProduit;
    
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "estivage_reservation_user")
    UserDao userDao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(LocalDateTime dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public LocalDateTime getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(LocalDateTime dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public EstivageProduit getEstivageProduit() {
        return estivageProduit;
    }

    public void setEstivageProduit(EstivageProduit estivageProduit) {
        this.estivageProduit = estivageProduit;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

package com.example.demo.security.model;
import com.example.demo.Entity.EstivageReservation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    private String classe;

    @OneToMany(mappedBy = "userDao")
    List<EstivageReservation> estivageReservations = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "userDao")
    @JsonIgnore
    public List<EstivageReservation> getEstivageReservations() {
        return estivageReservations;
    }

    public void setEstivageReservations(List<EstivageReservation> estivageReservations) {
        this.estivageReservations = estivageReservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}


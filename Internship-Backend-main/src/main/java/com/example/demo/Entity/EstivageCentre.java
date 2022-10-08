package com.example.demo.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="estivage_centre")
public class EstivageCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rating;

    private String name,type,city,adress,photos,title,des,tel,responsable;

    @OneToMany(mappedBy = "estivageCentre" , cascade = CascadeType.ALL)
    private List<EstivageCentrePhotos> estivageCentrePhotos = new ArrayList<>();


    @OneToMany(mappedBy = "estivageCentre", cascade = CascadeType.ALL)
    private List<EstivageProduit> estivageProduits = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "estivageCentre", cascade = CascadeType.ALL)
    private List<EstivageCentreDates> estivageCentreDates = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<EstivageProduit> getEstivageProduits() {
        return estivageProduits;
    }

    public void setEstivageProduits(List<EstivageProduit> estivageProduits) {
        this.estivageProduits = estivageProduits;
    }

    public List<EstivageCentreDates> getEstivageCentreDates() {
        return estivageCentreDates;
    }

    public void setEstivageCentreDates(List<EstivageCentreDates> estivageCentreDates) {
        this.estivageCentreDates = estivageCentreDates;
    }

    public EstivageCentre() {
    }

    public EstivageCentre(Integer rating, String name, String type, String city, String adress, String photos, String title, String des) {
        this.rating = rating;
        this.name = name;
        this.type = type;
        this.city = city;
        this.adress = adress;
        this.photos = photos;
        this.title = title;
        this.des = des;
    }

    public List<EstivageCentrePhotos> getEstivageCentrePhotos() {
        return estivageCentrePhotos;
    }

    public void setEstivageCentrePhotos(List<EstivageCentrePhotos> estivageCentrePhotos) {
        this.estivageCentrePhotos = estivageCentrePhotos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}

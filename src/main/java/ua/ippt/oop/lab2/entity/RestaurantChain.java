package ua.ippt.oop.lab2.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant_chain")
public class RestaurantChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_chain_id")
    private Integer id;

    @Column(name = "restaurant_chain_name")
    private String name;

    @Column(name = "restaurant_chain_founded")
    private LocalDate founded;

    @OneToMany(mappedBy = "restaurantChain", fetch = FetchType.LAZY)
    private List<Country> countries;

    @OneToMany(mappedBy = "restaurantChain", fetch = FetchType.LAZY)
    private List<Restaurant> restaurantList;

    public RestaurantChain() {
    }

    public RestaurantChain(String name, LocalDate founded) {
        this.name = name;
        this.founded = founded;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}

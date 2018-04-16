package ua.ippt.oop.lab2.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "country_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_chain_id")
    private RestaurantChain restaurantChain;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<City> cities;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
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

    public RestaurantChain getRestaurantChain() {
        return restaurantChain;
    }

    public void setRestaurantChain(RestaurantChain restaurantChain) {
        this.restaurantChain = restaurantChain;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}

package ua.ippt.oop.lab2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String type;

    @Column(name = "general_amount")
    private Integer generalAmount;

    @ManyToMany
    @Column(name = "restaurant_list")
    private List<Restaurant> restaurantList;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getGeneralAmount() {
        return generalAmount;
    }

    public void setGeneralAmount(Integer generalAmount) {
        this.generalAmount = generalAmount;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}

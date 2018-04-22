package ua.ippt.oop.lab2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne
    private City city;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private RestaurantChain restaurantChain;

    @OneToMany(mappedBy = "restaurant")
    @Column(name = "staff_list")
    private List<Staff> staffList;

    @ManyToMany(mappedBy = "restaurantList")
    @Column(name = "equipment_list")
    private List<Equipment> equipmentList;

    @ManyToMany(mappedBy = "restaurantList")
    @Column(name = "product_list")
    private List<Product> productList;
}

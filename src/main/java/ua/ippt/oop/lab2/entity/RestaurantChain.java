package ua.ippt.oop.lab2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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
}

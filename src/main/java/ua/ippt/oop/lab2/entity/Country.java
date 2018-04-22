package ua.ippt.oop.lab2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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
}

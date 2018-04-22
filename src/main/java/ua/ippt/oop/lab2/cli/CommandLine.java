package ua.ippt.oop.lab2.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ippt.oop.lab2.entity.*;
import ua.ippt.oop.lab2.repository.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLine {
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantChainRepository restaurantChainRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StaffRepository staffRepository;

    public void runMenu() {
        boolean isRun = true;
        while (isRun) {
            System.out.println("1. Add restaurant chain: \n"
                               + "2. Remove restaurant chain: \n"
                               + "3. Change restaurant chain \n"
                               + "4 Find restaurant chain by name: \n"
                               + "5. Add restaurant: \n"
                               + "6. Remove restaurant \n"
                               + "7. Add country \n"
                               + "8. Remove country\n"
                               + "9. Add city \n"
                               + "10. Remove city \n"
                               + "11. Add equipment \n"
                               + "12. Delete equipment \n"
                               + "13. Add product \n"
                               + "14. Delete product \n"
                               + "15. Add staff \n"
                               + "16. Delete staff \n"
                               + "17. Quit");
            switch (scanner.next()) {
            case "1":addRestaurantChain();break;
            case "2":removeRestaurantChain();break;
            case "3":changeRestaurantChain();break;
            case "4":findRestaurantChainByName();break;
            case "5":addRestaurant();break;
            case  "6":removeRestaurant();break;
            case "7": addCountry();break;
            case "8":removeCountry();break;
            case "9":addCity();break;
            case "10":removeCity();break;
            case "11":addEquipment();break;
            case "12":removeEquipment();break;
            case "13":addProduct();break;
            case "14":removeProduct();break;
            case "15":addStaff();break;
            case "16":removeStaff();break;
            case "":isRun = false;break;
            default:
                System.out.println("You've entered non-existing option.");
            }
        }
    }

    @Transactional
    public void addRestaurantChain() {
        System.out.println("enter name:");
        String name = scanner.next();
        RestaurantChain restaurantChain = new RestaurantChain();
        restaurantChain.setName(name);
        restaurantChainRepository.save(restaurantChain);
    }

    @Transactional
    public void removeRestaurantChain() {
        System.out.println("enter restaurant chain index:");
        int id = scanner.nextInt();
        restaurantChainRepository.delete(restaurantChainRepository.getOne(id));
    }

    @Transactional
    public void changeRestaurantChain() {
        System.out.println("enter restaurant chain index:");
        int id = scanner.nextInt();
        System.out.println("enter restaurant chain name:");
        String name = scanner.next();
        RestaurantChain rc = restaurantChainRepository.getOne(id);
        rc.setName(name);
        restaurantChainRepository.save(rc);
    }

    public void findRestaurantChainByName() {
        System.out.println("enter name:");
        String name = scanner.next();
        List<RestaurantChain> rcs = restaurantChainRepository.findByName(name);
        for (RestaurantChain rc : rcs)
            System.out.println(rc.getName());
        if (rcs.size() == 0)
            System.out.println("no restaurant chains by this name: " + name);
    }

    @Transactional
    public void addRestaurant() {
        System.out.println("enter restaurant name:");
        String name = scanner.next();
        System.out.println("enter restaurant chain index:");
        int rcIndex = scanner.nextInt();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setRestaurantChain(restaurantChainRepository.getOne(rcIndex));
        restaurantRepository.save(restaurant);
    }

    @Transactional
    public void removeRestaurant() {
        System.out.println("enter restaurant index:");
        int index = scanner.nextInt();
        restaurantRepository.delete(restaurantRepository.getOne(index));
    }

    @Transactional
    public void addCountry() {
        System.out.println("enter country name:");
        String name = scanner.next();
        System.out.println("enter restaurant chain index:");
        int rcIndex = scanner.nextInt();
        Country country = new Country();
        country.setName(name);
        country.setRestaurantChain(restaurantChainRepository.getOne(rcIndex));
        countryRepository.save(country);
    }

    @Transactional
    public void removeCountry() {
        System.out.println("enter country index:");
        int index = scanner.nextInt();
        countryRepository.delete(countryRepository.getOne(index));
    }

    @Transactional
    public void addCity() {
        System.out.println("enter city name:");
        String name = scanner.next();
        System.out.println("enter country index:");
        int countryIndex = scanner.nextInt();
        City country = new City();
        country.setName(name);
        country.setCountry(countryRepository.getOne(countryIndex));
        cityRepository.save(country);
    }

    @Transactional
    public void removeCity() {
        System.out.println("enter city index:");
        int index = scanner.nextInt();
        cityRepository.delete(cityRepository.getOne(index));
    }

    @Transactional
    public void addEquipment() {
        System.out.println("enter equipment name:");
        String name = scanner.next();
        System.out.println("enter restaurant index:");
        int rIndex = scanner.nextInt();
        Restaurant restaurant = restaurantRepository.getOne(rIndex);
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setRestaurantList(Collections.singletonList(restaurant));
        equipmentRepository.save(equipment);
    }

    @Transactional
    public void removeEquipment() {
        System.out.println("enter equip index:");
        int index = scanner.nextInt();
        equipmentRepository.delete(equipmentRepository.getOne(index));
    }

    @Transactional
    public void addProduct() {
        System.out.println("enter product name:");
        String name = scanner.next();
        System.out.println("enter restaurant index:");
        int rIndex = scanner.nextInt();
        Restaurant restaurant = restaurantRepository.getOne(rIndex);
        Product product = new Product();
        product.setName(name);
        product.setRestaurantList(Collections.singletonList(restaurant));
        productRepository.save(product);
    }

    @Transactional
    public void removeProduct() {
        System.out.println("enter product index:");
        int index = scanner.nextInt();
        productRepository.delete(productRepository.getOne(index));
    }

    @Transactional
    public void addStaff() {
        System.out.println("enter staff name:");
        String name = scanner.next();
        System.out.println("enter restaurant index:");
        int rIndex = scanner.nextInt();
        Staff staff = new Staff();
        staff.setFullName(name);
        Restaurant restaurant = restaurantRepository.getOne(rIndex);
        staff.setRestaurant(restaurant);
        staffRepository.save(staff);
    }

    @Transactional
    public void removeStaff() {
        System.out.println("enter staff index:");
        int index = scanner.nextInt();
        staffRepository.delete(staffRepository.getOne(index));
    }
}

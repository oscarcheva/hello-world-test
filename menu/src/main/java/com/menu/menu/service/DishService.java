package com.menu.menu.service;

import com.menu.menu.entities.Dish;
import com.menu.menu.entities.Menu;
import com.menu.menu.persistence.DishRepo;
import com.menu.menu.persistence.MenuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepo dishRepo;

    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    public Dish findDishById(Integer id) {
        return dishRepo.findById(id).orElse(null);
    }

    public Dish createDish(Dish dish){
        return dishRepo.save(dish);
    }

    public void deleteDish(Integer id){
        dishRepo.deleteById(id);
    }

    public Dish updateDish(Dish dish){

        Dish oldDish = findDishById(dish.getId());
        oldDish.setCost(dish.getCost());
        oldDish.setDescription(dish.getDescription());
        return dishRepo.save(oldDish);
    }

}

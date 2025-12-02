package com.oscar.secondapp.service;

import com.oscar.secondapp.entities.Dish;
import com.oscar.secondapp.entities.Menu;
import com.oscar.secondapp.persistence.DishRepo;
import com.oscar.secondapp.persistence.MenuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

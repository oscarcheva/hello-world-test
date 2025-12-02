package com.oscar.secondapp.service;

import com.oscar.secondapp.entities.Dish;
import com.oscar.secondapp.entities.Menu;
import com.oscar.secondapp.entities.Test;
import com.oscar.secondapp.persistence.DishRepo;
import com.oscar.secondapp.persistence.MenuRepo;
import com.oscar.secondapp.persistence.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepo menuRepo;
    private final TestRepo testRepo;

   public Menu getMenuByDay(String day){
        return menuRepo.findByDayOfWeek(day);
    }

    public List<Menu> getAllMenus(){
        return menuRepo.findAll();
    }

    public List<Test> getAllTests(){
       return testRepo.findAll();
    }
}

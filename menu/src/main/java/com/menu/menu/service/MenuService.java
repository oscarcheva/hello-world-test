package com.menu.menu.service;

import com.menu.menu.entities.Menu;
import com.menu.menu.entities.Test;
import com.menu.menu.persistence.MenuRepo;
import com.menu.menu.persistence.TestRepo;
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

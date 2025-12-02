package com.oscar.secondapp.persistence;

import com.oscar.secondapp.entities.Dish;
import com.oscar.secondapp.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepo  extends JpaRepository<Menu,Integer> {

    Menu findByDayOfWeek(String day);
}

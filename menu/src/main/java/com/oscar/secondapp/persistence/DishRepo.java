package com.oscar.secondapp.persistence;

import com.oscar.secondapp.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepo  extends JpaRepository<Dish,Integer> {


}

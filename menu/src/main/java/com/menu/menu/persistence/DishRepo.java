package com.menu.menu.persistence;

import com.menu.menu.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DishRepo  extends JpaRepository<Dish,Integer> {


}

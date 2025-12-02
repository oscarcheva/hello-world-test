package com.oscar.secondapp.persistence;

import com.oscar.secondapp.entities.Dish;
import com.oscar.secondapp.entities.Menu;
import com.oscar.secondapp.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo  extends JpaRepository<Test,Integer> {

}

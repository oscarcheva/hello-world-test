package com.menu.menu.persistence;

import com.menu.menu.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo  extends JpaRepository<Menu,Integer> {

    Menu findByDayOfWeek(String day);
}

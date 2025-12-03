package com.menu.menu.persistence;

import com.menu.menu.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo  extends JpaRepository<Test,Integer> {

}

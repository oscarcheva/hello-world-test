package com.menu.menu.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DISH")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "COST", nullable = false)
    private float cost;

    @ManyToMany(mappedBy = "dishes")
    @JsonBackReference
    private List<Menu> menus;
}

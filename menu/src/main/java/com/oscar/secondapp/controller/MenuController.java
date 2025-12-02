package com.oscar.secondapp.controller;

import com.oscar.secondapp.DTO.MenuRequestDTO;
import com.oscar.secondapp.entities.Menu;
import com.oscar.secondapp.entities.Test;
import com.oscar.secondapp.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public Menu getMenuDay(@RequestBody MenuRequestDTO menuRequest) {
        return menuService.getMenuByDay(menuRequest.getDayName());
    }

    @GetMapping("/all")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/test")
    public List<Test> getAllTests() {
        return menuService.getAllTests();
    }
}

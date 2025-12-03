package com.menu.menu.controller;

import com.menu.menu.DTO.MenuRequestDTO;
import com.menu.menu.entities.Menu;
import com.menu.menu.entities.Test;
import com.menu.menu.service.MenuService;
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

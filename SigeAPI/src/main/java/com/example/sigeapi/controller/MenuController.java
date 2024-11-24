package com.example.sigeapi.controller;

import com.example.sigeapi.model.Menu;
import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.service.MenuService;
import com.example.sigeapi.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    private VagasService vagasService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Vagas> finalizarVaga(@PathVariable Integer id) {
        Vagas vagaAtualizada = vagasService.finalizarVaga(id);
        return ResponseEntity.ok(vagaAtualizada);
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Integer id) {
        Menu menu = menuService.getMenuById(id);
        if (menu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menu);
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Integer id, @RequestBody Menu menuDetails) {
        Menu updatedMenu = menuService.updateMenu(id, menuDetails);
        if (updatedMenu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}

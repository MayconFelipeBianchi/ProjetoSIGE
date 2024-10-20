package com.example.sigeapi.service;

import com.example.sigeapi.model.Menu;
import com.example.sigeapi.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Integer id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Integer id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id).orElse(null);
        if (menu != null) {
            menu.setStatus(menuDetails.getStatus());
            return menuRepository.save(menu);
        }
        return null;
    }

    public void deleteMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}

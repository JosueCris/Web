package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.ICategoryService;
import com.example.Northwind.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @GetMapping
    @RequestMapping(value = "category/get/{idCat}", method = RequestMethod.GET)
    public ResponseEntity<?> categorySearch(@PathVariable int idCat) {
        Category aux = this.service.buscar(idCat);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "category/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> categoryShowAll() {
        List<Category> categories = this.service.consultar();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    @RequestMapping(value = "category/save", method = RequestMethod.POST)
    public void categorySave(@RequestBody Category cat) {
        this.service.agregar(cat);
    }

    @PutMapping
    @RequestMapping(value = "category/update/{idCat}", method = RequestMethod.PUT)
    public ResponseEntity<?> categoryUpdate(@RequestBody Category cat, @PathVariable int idCat) {
        Category aux = this.service.actualizar(cat, idCat);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "category/delete/{idCat}", method = RequestMethod.DELETE)
    public ResponseEntity<?> categoryDelete(@PathVariable int idCat) {
        Category aux = this.service.buscar(idCat);
        if (aux != null) {
            this.service.eliminar(idCat);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
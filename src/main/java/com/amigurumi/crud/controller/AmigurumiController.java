package com.amigurumi.crud.controller;

import com.amigurumi.crud.entity.Amigurumi;
import com.amigurumi.crud.repository.CategoriaRepository;
import com.amigurumi.crud.service.AmigurumiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amigurumis")
public class AmigurumiController {

    private final AmigurumiService service;
    private final CategoriaRepository categoriaRepo;

    public AmigurumiController(AmigurumiService service, CategoriaRepository categoriaRepo) {
        this.service = service;
        this.categoriaRepo = categoriaRepo;
    }

    @GetMapping
    public List<Amigurumi> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Amigurumi> crear(@RequestBody Amigurumi a) {
        // Validaciones simples: categoria debe existir si viene id
        if (a.getCategoria() != null && a.getCategoria().getId() != null) {
            categoriaRepo.findById(a.getCategoria().getId()).ifPresent(a::setCategoria);
        }
        Amigurumi creado = service.crear(a);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amigurumi> obtener(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amigurumi> actualizar(@PathVariable Long id, @RequestBody Amigurumi a) {
        Amigurumi actualizado = service.actualizar(id, a);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


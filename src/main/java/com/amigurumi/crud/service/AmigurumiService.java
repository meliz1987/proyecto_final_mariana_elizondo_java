package com.amigurumi.crud.service;


import com.amigurumi.crud.entity.Amigurumi;
import com.amigurumi.crud.repository.AmigurumiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmigurumiService {

    private final AmigurumiRepository repo;

    public AmigurumiService(AmigurumiRepository repo) {
        this.repo = repo;
    }

    public Amigurumi crear(Amigurumi a) { return repo.save(a); }
    public List<Amigurumi> listar() { return repo.findAll(); }
    public Optional<Amigurumi> buscarPorId(Long id) { return repo.findById(id); }
    public Amigurumi actualizar(Long id, Amigurumi nuevo) {
        return repo.findById(id).map(ex -> {
            ex.setDescripcion(nuevo.getDescripcion());
            ex.setPrecio(nuevo.getPrecio());
            ex.setCategoria(nuevo.getCategoria());
            return repo.save(ex);
        }).orElse(null);
    }
    public void eliminar(Long id) { repo.deleteById(id); }
}


package com.amigurumi.crud.repository;

import com.amigurumi.crud.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
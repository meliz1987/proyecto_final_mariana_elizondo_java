package com.amigurumi.crud.repository;

import com.amigurumi.crud.entity.Amigurumi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmigurumiRepository extends JpaRepository<Amigurumi, Long> {}
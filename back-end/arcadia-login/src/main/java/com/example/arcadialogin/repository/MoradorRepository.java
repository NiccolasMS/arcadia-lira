package com.example.arcadialogin.repository;

import com.example.arcadialogin.domain.Condominio;
import com.example.arcadialogin.domain.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
    Morador findByCondominio(Condominio condominio);
}


package com.example.arcadialogin.repository;

import com.example.arcadialogin.domain.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    Condominio findByNome(String nome);;

}


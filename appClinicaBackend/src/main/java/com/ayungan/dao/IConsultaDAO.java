package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Consulta;


@Repository
public interface IConsultaDAO extends JpaRepository<Consulta, Integer>{

}

package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.DetalleConsulta;


@Repository
public interface IDetalleConsultaDAO extends JpaRepository<DetalleConsulta, Integer>{

}

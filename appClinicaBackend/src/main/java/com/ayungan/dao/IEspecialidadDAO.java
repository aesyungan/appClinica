package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Especialidad;

@Repository
public interface IEspecialidadDAO extends JpaRepository<Especialidad, Integer>{

}

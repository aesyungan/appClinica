package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Paciente;
@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Integer>{

}

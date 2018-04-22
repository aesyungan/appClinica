package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Medico;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Integer>{

}

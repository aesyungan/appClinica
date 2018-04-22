package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Consulta;
import com.ayungan.model.ConsultaExamen;

@Repository
public interface IConsultaExamenDAO extends JpaRepository<ConsultaExamen, Integer> {
	//@Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
	@Query(value = "insert into consulta_examen(id_consulta,id_examen) values(:idConsulta, :idExamen) RETURNING 1", nativeQuery = true)
	int registrar(@Param("idConsulta")int idConsulta, @Param("idExamen")int idExamen);
}

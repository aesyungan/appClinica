package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.ResetToken;

@Repository
public interface IResetTokenDAO extends JpaRepository<ResetToken, Long>{

	ResetToken findByToken(String token);

}

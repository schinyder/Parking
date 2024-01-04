package com.techchallenge.parquimetro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.parquimetro.entities.Veiculo;
	//Incluir  a anotação @	Repository
	@Repository
	//JpaRepository sempre é generic aguarda quais tipos foi passado Cliente e Long Referencia entidade e primarkey da entidade
	public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
		
	}
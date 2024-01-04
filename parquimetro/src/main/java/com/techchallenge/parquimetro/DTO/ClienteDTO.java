package com.techchallenge.parquimetro.DTO;

import java.time.Instant;
import java.time.LocalDate;

import com.techchallenge.parquimetro.entities.Cliente;

public class ClienteDTO {
	
	private Long id_cliente;
	private String nome;
	private Instant dtcriacao;
	private LocalDate nascimento;
	private String sexo;
	private String email;
	
	
	public ClienteDTO(Cliente cliente) {
	}

	public ClienteDTO(Long id_cliente, String nome, Instant dtcriacao, LocalDate nascimento,String sexo, String email) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.dtcriacao = dtcriacao;
		this.email = email;
	}


	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_Cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}
	public Instant getDtcriacao() {
		return dtcriacao;
	}

	public void setDtcriacao(Instant dtcriacao) {
		this.dtcriacao = dtcriacao;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	public ClienteDTO(Cliente cliente) {
		this.id_cliente = cliente.getId_cliente();
		this.nome = cliente.getNome();
		this.dtcriacao = cliente.getDtcriacao();
	}
	*/
	
   public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

public static Cliente toEntity(ClienteDTO dto) {
	   return new Cliente(dto);
   }
   
   public LocalDate getNascimento() {
	return nascimento;
}

public void setNascimento(LocalDate nascimento) {
	this.nascimento = nascimento;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

//Inverso do toEntity
   public static ClienteDTO fromEntity(Cliente cliente) {
	   return new ClienteDTO(cliente.getId_cliente(),cliente.getNome(),cliente.getDtcriacao(), cliente.getNascimento(), cliente.getSexo(), cliente.getEmail());		   
   }
   
   public static Cliente mapperDtoToEntity(ClienteDTO dto, Cliente entity) {
	   entity.setNome(dto.getNome());
	   entity.setNascimento(dto.getNascimento());
	   entity.setSexo(dto.getSexo());
	   entity.setEmail(dto.getEmail());
	   return entity;
   }
   
}
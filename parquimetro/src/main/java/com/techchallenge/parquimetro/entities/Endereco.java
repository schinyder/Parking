package com.techchallenge.parquimetro.entities;

import java.util.Objects;

import com.techchallenge.parquimetro.DTO.EnderecoClienteDTO;
import com.techchallenge.parquimetro.DTO.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_endereco")
@Entity
public class Endereco {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	private String endereco; 
	private int numero;
	private String bairro; 
	private String cidade;
	private String estado;
	private String cep;
	
    //Muitos Clientes podem estar no mesmo endereçõ Exemplo eu e minha  esposa
    //Relacionamento Unidirecional somente na entidade Endereco
	//Montando relacionamento de Um Cliente para Muitos Endereços
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	public Endereco() {
	}


	public Endereco(Long id_endereco, String endereco, int numero, String bairro, String cidade, String estado,
			String cep) {
		this.id_endereco = id_endereco;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}


	public Endereco(EnderecoDTO dto) {
		this.id_endereco = dto.getId_endereco();
		this.endereco = dto.getEndereco();
		this.numero = dto.getNumero();
		this.bairro = dto.getBairro();
		this.cep = dto.getCep();
		this.cidade = dto.getCidade();
		this.estado = dto.getEstado();
		
	  
	}

	//Construto da Classe EnderecoDto mapeamento de endereco para cliente 
	public Endereco(EnderecoClienteDTO dto, Cliente cliente) {
		this.id_endereco = dto.getId_endereco();
		this.endereco = dto.getEndereco();
		this.numero = dto.getNumero();
		this.bairro = dto.getBairro();
		this.cep = dto.getCep();
		this.cidade = dto.getCidade();
		this.estado = dto.getEstado();
		this.cliente = cliente;
	}

	public Long getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Long id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", endereco=" + endereco + ", numero=" + numero + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id_endereco, other.id_endereco);
	}

}

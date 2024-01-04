package com.techchallenge.parquimetro.entities;

import java.util.Objects;

import com.techchallenge.parquimetro.DTO.VeiculoClienteDTO;
import com.techchallenge.parquimetro.DTO.VeiculoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_veiculo")
@Entity
public class Veiculo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_veiculo;
	public String ds_modelo; 
	public String ds_marca;
	public String cor;
	public String placa;
	//@ManyToOne
	////@JoinColumn(name = "id_cliente")
	//public Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	public Veiculo() {
	}


	public Veiculo(Long id_veiculo, String ds_modelo, String ds_marca, String cor, String placa
			) {
		this.id_veiculo = id_veiculo;
		this.ds_modelo = ds_modelo;
		this.ds_marca = ds_marca;
		this.cor = cor;
		this.placa = placa;
	}

	
	public Veiculo(VeiculoDTO dto) {
		this.id_veiculo = dto.getId_veiculo();
	    this.ds_modelo = dto.getDs_modelo();
	    this.ds_marca = dto.getDs_marca();
	    this.placa = dto.getPlaca();
	    this.cor = dto.getCor();
	    
	
	}
 
		public Veiculo(VeiculoClienteDTO dto, Cliente cliente) {
			this.id_veiculo = dto.getId_veiculo();
			this.ds_modelo = dto.getDs_modelo();
			this.ds_marca = dto.getDs_marca();
			this.placa = dto.getPlaca();
			this.cor = dto.getCor();
			this.cliente = cliente;
		}

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getDs_modelo() {
		return ds_modelo;
	}


	public void setDs_modelo(String ds_modelo) {
		this.ds_modelo = ds_modelo;
	}


	public String getDs_marca() {
		return ds_marca;
	}


	public void setDs_marca(String ds_marca) {
		this.ds_marca = ds_marca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Veiculo [id_veiculo=" + id_veiculo + ", ds_modelo=" + ds_modelo
				+ ", ds_marca=" + ds_marca + ", cor=" + cor + ", placa=" + placa + /*", cliente=" + cliente */ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_veiculo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id_veiculo, other.id_veiculo);
	}
	
	
	
	
	
}

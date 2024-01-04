package com.techchallenge.parquimetro.DTO;

import com.techchallenge.parquimetro.entities.Cliente;
import com.techchallenge.parquimetro.entities.Veiculo;

public class VeiculoClienteDTO {
	
	public Long id_veiculo;
	public String ds_modelo;
	public String ds_marca;
	public String cor;
	public String placa;
	
	public ClienteDTO cliente;

	
	public VeiculoClienteDTO() {

	}

	public VeiculoClienteDTO(Long id_veiculo, String ds_modelo, String ds_marca, String cor, String placa, ClienteDTO cliente ) {
		this.id_veiculo = id_veiculo;
		this.ds_modelo = ds_modelo;
		this.ds_marca = ds_marca;
		this.cor = cor;
		this.placa = placa;
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
	
	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	//Criando metodo statico toEntity recebe dto e transforma em entidade
	//Criar também o metodo construtor na classe entidade no caso veiculo
	public static Veiculo toEntity(VeiculoClienteDTO dto, Cliente cliente) {
		return new Veiculo(dto, cliente); 
	}
	
	//Criando metodo que recebe a entidade e transforma para DTO fazendo o inverso  do toEntituy
	public static VeiculoClienteDTO fromEntity(Veiculo veiculo) {
		return new VeiculoClienteDTO(
		veiculo.getId_veiculo(),
		veiculo.getDs_modelo(),
		veiculo.getDs_marca(),
		veiculo.getCor(),
		veiculo.getPlaca(),
		veiculo.getCliente() != null ? ClienteDTO.fromEntity(veiculo.getCliente()): null
				);
	}	
     //Construindo o metodo mapper recebendo o dto e a entidade pra utilização na service 
	public static Veiculo mapperDtoToEntity(
			VeiculoClienteDTO dto, 
			Veiculo entity,
            Cliente cliente
            ) {
	     entity.setDs_modelo(dto.getDs_modelo());
	     entity.setDs_marca(dto.getDs_marca());
	     entity.setCor(dto.getCor());
	     entity.setPlaca(dto.getPlaca());
	     entity.setCliente(cliente);
		return entity;
	}

}

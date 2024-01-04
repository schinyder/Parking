package com.techchallenge.parquimetro.DTO;

import com.techchallenge.parquimetro.entities.Endereco;

public class EnderecoDTO {
	
	private Long id_endereco;
	private String endereco; 
	private int numero;
	private String bairro; 
	private String cidade;
	private String estado;
	private String cep;
	
	
	public EnderecoDTO() {
	}
	
	public EnderecoDTO(Long id_endereco, String endereco, int numero, String bairro, String cidade, String estado,
			String cep) {
		this.id_endereco = id_endereco;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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
	
	//Criando metodo statico toEntity recebe dto e transforma em entidade
		//Criar também o metodo construtor na classe entidade no caso veiculo
		public static Endereco toEntity(EnderecoDTO dto) {
			return new Endereco(dto);
		}
		
		//Criando metodo que recebe a entidade e transforma para DTO fazendo o inverso  do toEntituy
		public static EnderecoDTO fromEntity(Endereco endereco) {
			return new EnderecoDTO(
			endereco.getId_endereco(),
			endereco.getEndereco(),
			endereco.getNumero(),
			endereco.getBairro(),
			endereco.getCep(),
			endereco.getCidade(),
			endereco.getEstado()
					);
		}	
	     //Construindo o metodo mapper recebendo o dto e a entidade pra utilização na service 
		public static Endereco mapperDtoToEntity(EnderecoDTO dto, Endereco entity) {
		     entity.setEndereco(dto.getEndereco());
		     entity.setNumero(dto.getNumero());
		     entity.setBairro(dto.getBairro());
		     entity.setCidade(dto.getCidade());
		     entity.setEstado(dto.getEstado());
		     entity.setCep(dto.getCep());
			return entity;
		}
		
	

}

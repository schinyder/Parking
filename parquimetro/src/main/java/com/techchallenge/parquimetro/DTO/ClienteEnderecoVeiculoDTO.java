
package com.techchallenge.parquimetro.DTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.techchallenge.parquimetro.entities.Cliente;

public class ClienteEnderecoVeiculoDTO {
	private Long id_cliente;
	private String nome;
	private Instant dtcriacao;
	private LocalDate nascimento;
	private String sexo;
	private String email;
	private Set<EnderecoDTO> endereco;
	
	public ClienteEnderecoVeiculoDTO() {
		
	}
	
	//Campos de retorno do metodo
	public ClienteEnderecoVeiculoDTO(Long id_cliente, String nome, Instant dtcriacao, LocalDate nascimento, String sexo, String email,  Set<EnderecoDTO> endereco) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.dtcriacao = dtcriacao;
		this.endereco = endereco;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.email = email;
		//this.setEndereco(endereco);
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
	
	public Set<EnderecoDTO> getEndereco() {
		return endereco;
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

	public void setEndereco(Set<EnderecoDTO> endereco) {
		this.endereco = endereco;
	}
	
	
public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*Não precisa porque mais para mapeamento do Save que está usando outro DTO
   public static Cliente toEntity(ClienteEnderecoVeiculoDTO dto) {
	   return new Cliente(dto);
   }
*/
   //Inverso do toEntity -- Retorno do meu metodo get 
   public static ClienteEnderecoVeiculoDTO fromEntity(Cliente cliente) {
	  Set<EnderecoDTO> endereco = new HashSet<>();
	  if(!cliente.getEndereco().isEmpty()) {
		  cliente.getEndereco().forEach(end ->{
			 endereco.add(EnderecoDTO.fromEntity(end));
		 });
	  }
	   return new ClienteEnderecoVeiculoDTO(
			   cliente.getId_cliente(),
			   cliente.getNome(),
			   cliente.getDtcriacao(),
			   cliente.getNascimento(),
			   cliente.getSexo(),
			   cliente.getEmail(),
			   endereco
			   );		   
   }

   /*Não precisa utilizar 
   public static Cliente mapperDtoToEntity(ClienteEnderecoVeiculoDTO dto, Cliente entity) {
	   entity.setNome(dto.getNome());
	 //  entity.setDtcriacao(dto.getDtcriacao());
	   return entity;
   }*/
   
}
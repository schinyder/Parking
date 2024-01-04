package com.techchallenge.parquimetro.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.techchallenge.parquimetro.DTO.ClienteDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//Incluido as anotações @Table e @Entity para conexão com da sua entidade classe com sua tabela em banco de dados
//No @Table passar como parametro o nome da tabela criada no banco de dados
//TODO: não esquecer.

@Table(name = "tb_cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	private String nome;
	private LocalDate nascimento;
	private String sexo;
	private String email;
	private Instant dtcriacao;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "id_usuario") private Usuario usuario;
	 */

	// relacionamento entre tabelas veiculos para cliente
	@OneToMany(mappedBy = "cliente")
	private Set<Endereco> endereco = new HashSet<>();

	//relacionamento entre tabelas veiculos para cliente
	@OneToMany(mappedBy = "cliente")
	private Set<Veiculo> veiculo = new HashSet<>();
	
	//relacionamento entre tabelas veiculos para cliente
	@OneToMany(mappedBy = "cliente")
	private Set<Parquimetro> parquimetro = new HashSet<>();

	// Construtor Vazio
	public Cliente() {
	}

	// Construtor Cheio
	public Cliente(Long id_cliente, String nome, LocalDate nascimento, String sexo, Instant dtcriacao, String email) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.dtcriacao = dtcriacao;
		this.email = email;
	}

	// Construtor da DTO para o Mapper onde defino o que será apresentado na
	// requisição
	public Cliente(ClienteDTO dto) {
		this.id_cliente = dto.getId_cliente();
		this.nome = dto.getNome();
		this.dtcriacao = dto.getDtcriacao();
		this.nascimento = dto.getNascimento();
		this.sexo = dto.getSexo();
		this.email = dto.getEmail();
	}

	// Getters and Setters
	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Instant getDtcriacao() {
		return dtcriacao;
	}

	public void setDtcriacao(Instant dtcriacao) {
		this.dtcriacao = dtcriacao;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Endereco> getEndereco() {
		return endereco;
	}

	public Set<Veiculo> getVeiculo() {
		return veiculo;
	}
	
	

	public Set<Parquimetro> getParquimetro() {
		return parquimetro;
	}

	// Criar metodo para inserção automatica da data
	@PrePersist
	public void prePersist() {
		dtcriacao = Instant.now();
	}

	
	// toString
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo
				+ ", dtcriacao=" + dtcriacao + ", email=" + email + "]";
	}

	// hashCodr
	@Override
	public int hashCode() {
		return Objects.hash(id_cliente);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id_cliente, other.id_cliente);
	}
}

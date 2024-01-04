package com.techchallenge.parquimetro.DTO;

import java.time.LocalDateTime;

import com.techchallenge.parquimetro.entities.Parquimetro;



public class ParquimetroDTO {

	private Long id_parquimetro;
	private int tipoTempo;
	private int opcaoDePagamento;
	private LocalDateTime dataHoraInicial;
	private LocalDateTime dataHoraFinal;
     

	public ParquimetroDTO(Long id_parquimetro, LocalDateTime dataHoraInicial,LocalDateTime dataHoraFinal,int opcaoDePagamento,int tipoTempo ) {
		this.id_parquimetro = id_parquimetro;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
		this.opcaoDePagamento = opcaoDePagamento;
		this.tipoTempo = tipoTempo;
	}


	public Long getId_parquimetro() {
		return id_parquimetro;
	}


	public void setId_parquimetro(Long id_parquimetro) {
		this.id_parquimetro = id_parquimetro;
	}


	public int getTipoTempo() {
		return tipoTempo;
	}


	public void setTipoTempo(int tipoTempo) {
		this.tipoTempo = tipoTempo;
	}


	public int getOpcaoDePagamento() {
		return opcaoDePagamento;
	}


	public void setOpcaoDePagamento(int opcaoDePagamento) {
		this.opcaoDePagamento = opcaoDePagamento;
	}


	public LocalDateTime getDataHoraInicial() {
		return dataHoraInicial;
	}


	public void setDataHoraInicial(LocalDateTime dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}


	public LocalDateTime getDataHoraFinal() {
		return dataHoraFinal;
	}


	public void setDataHoraFinal(LocalDateTime dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}


	//Criando metodo statico toEntity recebe dto e transforma em entidade
	//Criar também o metodo construtor na classe entidade no caso veiculo
	public static Parquimetro toEntity(ParquimetroDTO dto) {
		return new 	Parquimetro(dto);
	}
	
	//Criando metodo que recebe a entidade e transforma para DTO fazendo o inverso  do toEntituy
	public static ParquimetroDTO fromEntity(Parquimetro parquimetro) {
		return new ParquimetroDTO(
	    parquimetro.getId_parquimetro(),
		parquimetro.getDataHoraInicial(),
		parquimetro.getDataHoraFinal(),
		parquimetro.getOpcaoDePagamento(),
		parquimetro.getTipoTempo()
				);
	}	
	
	
     //Construindo o metodo mapper recebendo o dto e a entidade pra utilização na service 
	public static Parquimetro mapperDtoToEntity(ParquimetroDTO dto, Parquimetro entity) {
	     entity.setDataHoraInicial(dto.getDataHoraFinal());
	     entity.setDataHoraFinal(dto.getDataHoraFinal());
	     entity.setOpcaoDePagamento(dto.getOpcaoDePagamento());
	     entity.setTipoTempo(dto.getTipoTempo());
		return entity;
	}

		
}

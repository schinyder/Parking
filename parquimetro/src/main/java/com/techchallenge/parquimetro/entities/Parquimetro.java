package com.techchallenge.parquimetro.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.techchallenge.parquimetro.DTO.ParquimetroClienteDTO;
import com.techchallenge.parquimetro.DTO.ParquimetroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_parquimetro")
@Entity
public class Parquimetro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_parquimetro;
	private int tipoTempo;
	private int opcaoDePagamento;
	private LocalDateTime dataHoraInicial;
	private LocalDateTime dataHoraFinal;
     
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	
	
	public Parquimetro() {
	}

	public Parquimetro(Long id_parquimetro, int tipoTempo, int opcaoDePagamento, LocalDateTime dataHoraInicial,
			LocalDateTime dataHoraFinal) {
		this.id_parquimetro = id_parquimetro;
		this.tipoTempo = tipoTempo;
		this.opcaoDePagamento = opcaoDePagamento;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
	}
	
	public Parquimetro(ParquimetroDTO dto) {
		this.id_parquimetro = dto.getId_parquimetro();
		this.dataHoraInicial = dto.getDataHoraInicial();
		this.dataHoraFinal = dto.getDataHoraFinal();
		this.opcaoDePagamento = dto.getOpcaoDePagamento();
		this.tipoTempo = dto.getTipoTempo();
		
	}
	
	public Parquimetro(ParquimetroClienteDTO dto, Cliente cliente) {
		this.id_parquimetro = dto.getId_parquimetro();
		this.dataHoraInicial = dto.getDataHoraInicial();
		this.dataHoraFinal = dto.getDataHoraFinal();
		this.opcaoDePagamento = dto.getOpcaoDePagamento();
		this.tipoTempo = dto.getTipoTempo();
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
/*
	// Metodo Retorna Tempo Formatado
	public String tempo() {
		Duration duracao = Duration.between(dataHoraInicial, dataHoraFinal);
		long horas = duracao.toHours();
		long minutos = duracao.toMinutes() % 60;
		LocalTime tempo = LocalTime.of((int) horas, (int) minutos);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return tempo.format(formatter);
	}

	public String calcularValor() {

		// Formatar o valor em r
		DecimalFormat df = new DecimalFormat("#,###.00");
		// Calcula a diferença de tempo entre as datas iniciais e finais
		Duration duracao = Duration.between(dataHoraInicial, dataHoraFinal);

		// Converte a diferença de tempo para horas
		long minutos = duracao.toMinutes();

		// Calcula o valor com base em R$ 1,00 por hora
		double valor = minutos * 0.1014;

		return df.format(valor);
	}

	
	public String escolhaTempo() {
		if (tipoTempo == 1) {
			return "FIXO";
		} else if (tipoTempo == 2) {
			return "VARIAVEL";
		} else {
			return "Tipo de tempo desconhecido";
		}
	}

	public String escolhaPagamento() {
		if (opcaoDePagamento == 1) {
			return "PIX";
		} else if (opcaoDePagamento == 2) {
			return "DÉBITO";
		} else if (opcaoDePagamento == 3) {
			return "CRÉDITO";
		}
		else  {
			return "Tipo de tempo desconhecido";
		}
	}
*/
	@Override
	public String toString() {
		return "Parquimetro [id_parquimetro=" + id_parquimetro + ", tipoTempo=" + tipoTempo + ", opcaoDePagamento="
				+ opcaoDePagamento + ", dataHoraInicial=" + dataHoraInicial + ", dataHoraFinal=" + dataHoraFinal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_parquimetro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parquimetro other = (Parquimetro) obj;
		return Objects.equals(id_parquimetro, other.id_parquimetro);
	}
	
}

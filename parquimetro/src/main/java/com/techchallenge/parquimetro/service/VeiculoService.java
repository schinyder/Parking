package com.techchallenge.parquimetro.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techchallenge.parquimetro.DTO.VeiculoClienteDTO;
import com.techchallenge.parquimetro.entities.Veiculo;
import com.techchallenge.parquimetro.exception.ControllerNotFoundException;
import com.techchallenge.parquimetro.exception.DatabaseException;
import com.techchallenge.parquimetro.repository.ClienteRepository;
import com.techchallenge.parquimetro.repository.VeiculoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	// Atributo da Classe
	private final VeiculoRepository veiculoRepository;
	private final ClienteRepository clienteRepository;

	// Metodo
	public VeiculoService(
			VeiculoRepository veiculoRepository, 
			ClienteRepository clienteRepository
			) {
		this.veiculoRepository = veiculoRepository;
		this.clienteRepository = clienteRepository;
	}

	// Criando o metodo findALL
	@Transactional()
	public Page<VeiculoClienteDTO> findAll(PageRequest pageRequest) {
		var veiculo = veiculoRepository.findAll(pageRequest);
		return veiculo.map(VeiculoClienteDTO::fromEntity);
	}

	// Criando o metodo findById
	@Transactional
	public VeiculoClienteDTO findByiD(Long id) {
		var veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Veiculo não encontrado"));
		return VeiculoClienteDTO.fromEntity(veiculo);
	}

	// Criando o metodo de inserção
	@Transactional
	public VeiculoClienteDTO insert(VeiculoClienteDTO dto) {
		try {
		var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
		var entity = VeiculoClienteDTO.toEntity(dto, cliente);
		var veiculoInsert = veiculoRepository.save(entity);
		return VeiculoClienteDTO.fromEntity(veiculoInsert);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Veiculo não encontrado");
		}
}
	// Criando o metodo de Atualização
	@Transactional
	public VeiculoClienteDTO update(Long id, VeiculoClienteDTO dto) {
		try {
			Veiculo entity = veiculoRepository.getReferenceById(id);
			var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
			VeiculoClienteDTO.mapperDtoToEntity(dto, entity, cliente);
			entity = veiculoRepository.save(entity);
			return VeiculoClienteDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Veiculo/Cliente não encontrado");
		}
	}

	// Criando o metodo de Exclusão tipo void para não retornar nada
	@Transactional
	public void delete(Long id) {
		try {
			veiculoRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade dos dados");	
		}
	}
}
        


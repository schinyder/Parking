package com.techchallenge.parquimetro.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techchallenge.parquimetro.DTO.ParquimetroClienteDTO;
import com.techchallenge.parquimetro.entities.Parquimetro;
import com.techchallenge.parquimetro.exception.ControllerNotFoundException;
import com.techchallenge.parquimetro.exception.DatabaseException;
import com.techchallenge.parquimetro.repository.ClienteRepository;
import com.techchallenge.parquimetro.repository.ParquimetroRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ParquimetroService {

	// Atributo da Classe
	private final ParquimetroRepository parquimetroRepository;
	private final ClienteRepository clienteRepository;

	// Metodo
	public ParquimetroService(
			ParquimetroRepository parquimetroRepository, 
			ClienteRepository clienteRepository
			) {
		this.parquimetroRepository = parquimetroRepository;
		this.clienteRepository = clienteRepository;
	}

	// Criando o metodo findALL
	@Transactional()
	public Page<ParquimetroClienteDTO> findAll(PageRequest pageRequest) {
		var parquimetro = parquimetroRepository.findAll(pageRequest);
		return parquimetro.map(ParquimetroClienteDTO::fromEntity);
	}

	// Criando o metodo findById
	@Transactional
	public ParquimetroClienteDTO findByiD(Long id) {
		var parquimetro = parquimetroRepository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Veiculo não encontrado"));
		return ParquimetroClienteDTO.fromEntity(parquimetro);
	}

	// Criando o metodo de inserção
	@Transactional
	public ParquimetroClienteDTO insert(ParquimetroClienteDTO dto) {
		try {
		var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
		var entity = ParquimetroClienteDTO.toEntity(dto, cliente);
		var parquimetroInsert = parquimetroRepository.save(entity);
		return ParquimetroClienteDTO.fromEntity(parquimetroInsert);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Veiculo não encontrado");
		}
}
	// Criando o metodo de Atualização
	@Transactional
	public ParquimetroClienteDTO update(Long id, ParquimetroClienteDTO dto) {
		try {
			Parquimetro entity = parquimetroRepository.getReferenceById(id);
			var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
			ParquimetroClienteDTO.mapperDtoToEntity(dto, entity, cliente);
			entity = parquimetroRepository.save(entity);
			return ParquimetroClienteDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Veiculo/Cliente não encontrado");
		}
	}

	// Criando o metodo de Exclusão tipo void para não retornar nada
	@Transactional
	public void delete(Long id) {
		try {
			parquimetroRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade dos dados");	
		}
	}
}
        


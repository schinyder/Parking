package com.techchallenge.parquimetro.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techchallenge.parquimetro.DTO.EnderecoClienteDTO;
import com.techchallenge.parquimetro.entities.Endereco;
import com.techchallenge.parquimetro.exception.ControllerNotFoundException;
import com.techchallenge.parquimetro.exception.DatabaseException;
import com.techchallenge.parquimetro.repository.ClienteRepository;
import com.techchallenge.parquimetro.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	// Atributo da Classe
	private final EnderecoRepository enderecoRepository;
	private final ClienteRepository clienteRepository;

	// Metodo
	public EnderecoService(
			EnderecoRepository enderecoRepository, 
			ClienteRepository clienteRepository
			) {
		this.enderecoRepository = enderecoRepository;
		this.clienteRepository = clienteRepository;
	}

	// Criando o metodo findALL
	@Transactional()
	public Page<EnderecoClienteDTO> findAll(PageRequest pageRequest) {
		var endereco = enderecoRepository.findAll(pageRequest);
		return endereco.map(EnderecoClienteDTO::fromEntity);
	}

	// Criando o metodo findById
	@Transactional
	public EnderecoClienteDTO findByiD(Long id) {
		var endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Endereco não encontrado"));
		return EnderecoClienteDTO.fromEntity(endereco);
	}

	// Criando o metodo de inserção
	@Transactional
	public EnderecoClienteDTO insert(EnderecoClienteDTO dto) {
		try {
	    var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
		var entity = EnderecoClienteDTO.toEntity(dto, cliente);
		var enderecoInsert = enderecoRepository.save(entity);
		return EnderecoClienteDTO.fromEntity(enderecoInsert);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Cliente não encontrado");
		}
	}

	// Criando o metodo de Atualização
	@Transactional
	public EnderecoClienteDTO update(Long id, EnderecoClienteDTO dto) {
		try {
			Endereco entity = enderecoRepository.getReferenceById(id);
			var cliente = clienteRepository.getReferenceById(dto.getCliente().getId_cliente());
			EnderecoClienteDTO.mapperDtoToEntity(dto, entity, cliente);
			entity = enderecoRepository.save(entity);
			return EnderecoClienteDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Cliente/Endereco não encontrado");
		}
	}

	// Criando o metodo de Exclusão tipo void para não retornar nada
	@Transactional
	public void delete(Long id) {
		try {
			enderecoRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade dos dados");	
		}
	}
}
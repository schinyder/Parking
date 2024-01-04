package com.techchallenge.parquimetro.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techchallenge.parquimetro.DTO.ClienteDTO;
import com.techchallenge.parquimetro.DTO.ClienteEnderecoVeiculoDTO;
import com.techchallenge.parquimetro.entities.Cliente;
import com.techchallenge.parquimetro.exception.ControllerNotFoundException;
import com.techchallenge.parquimetro.exception.DatabaseException;
import com.techchallenge.parquimetro.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepository;
	
	//Construtor
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	

	// Não bloqueia o banco de dados na escrita fica mais rapido o banco
	@Transactional
	public ClienteEnderecoVeiculoDTO findById(Long id) {
	//Optional <Cliente> entity = clienteRepository.findById(id);
		var cliente = clienteRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado"));
		//Cliente cliente = entity.orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado"));
		return ClienteEnderecoVeiculoDTO.fromEntity(cliente);
	}
	
	@Transactional
	public Page<ClienteEnderecoVeiculoDTO>  findAll(PageRequest pageRequest) {
		//Page<Cliente> list=  clienteRepository.findAll(pageRequest);
		//return list.map(x -> new ClienteDTO(x));
		var cliente =clienteRepository.findAll(pageRequest);
		return cliente.map(ClienteEnderecoVeiculoDTO::fromEntity);
	}
    
	/*
	@Transactional
	public ClienteDTO save(ClienteDTO cliente) {
		Cliente entity = new Cliente();
		mapperDtoToEntity(cliente, entity);
		return new ClienteDTO();
	}
	*/
	
	@Transactional
	public ClienteDTO insert (ClienteDTO dto) {
		try {
			//var usuario = usuarioRepository.getReferenceById(dto.getUsuario().getId_usuario());
			var entity = ClienteDTO.toEntity(dto);
	        var clienteinsert = clienteRepository.save(entity);
	        return ClienteDTO.fromEntity(clienteinsert);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Usuário não encontrado");
		}
		
	}
	
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			//var usuario = usuarioRepository.getReferenceById(dto.getUsuario().getId_usuario());
			Cliente entity = clienteRepository.getReferenceById(id);
			entity = ClienteDTO.mapperDtoToEntity(dto, entity);
			entity = clienteRepository.save(entity);
			return ClienteDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Cliente não Encontrado, id: " + id);
		}
	}
    
	
	@Transactional
	public void delete(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException("Cliente não localizado" + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de Integridade");

		}
	}
}
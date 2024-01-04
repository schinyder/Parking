package com.techchallenge.parquimetro.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techchallenge.parquimetro.DTO.ClienteDTO;
import com.techchallenge.parquimetro.DTO.ClienteEnderecoVeiculoDTO;
import com.techchallenge.parquimetro.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	private ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}

	/*@GetMapping(value = "/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		ClienteDTO result = service.findById(id);
		return result;
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEnderecoVeiculoDTO> findById(@PathVariable long id) {
		ClienteEnderecoVeiculoDTO clienteDTO = service.findById(id);
		return ResponseEntity.ok(clienteDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<ClienteEnderecoVeiculoDTO>> findAll(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade,
			@RequestParam(value = "direcao", defaultValue = "DESC") String direcao,
			@RequestParam(value = "ordenacao", defaultValue = "nome") String ordenacao) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidade, Sort.Direction.valueOf(direcao),ordenacao);
		var list = service.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto) {
		ClienteDTO clienteDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((clienteDTO.getId_cliente())).toUri();
		return ResponseEntity.created(uri).body(clienteDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(
			@PathVariable Long id,
			@RequestBody ClienteDTO dto
			){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(
			@PathVariable Long id
			){
	      service.delete(id);
	return ResponseEntity.noContent().build();
}
	

}
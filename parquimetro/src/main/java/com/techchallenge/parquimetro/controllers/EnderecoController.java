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

import com.techchallenge.parquimetro.DTO.EnderecoClienteDTO;
import com.techchallenge.parquimetro.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
   
	//Atributo da classe Service 
	private final EnderecoService enderecoService;
	
	//Construtor 
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
		
	}
	
	//Metodo findById
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoClienteDTO> findById(@PathVariable long id) {
		EnderecoClienteDTO enderecoDTO = enderecoService.findByiD(id);
		return ResponseEntity.ok(enderecoDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<EnderecoClienteDTO>> findAll(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade,
			@RequestParam(value = "direcao", defaultValue = "DESC") String direcao,
			@RequestParam(value = "ordenacao", defaultValue = "endereco") String ordenacao) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidade, Sort.Direction.valueOf(direcao),ordenacao);
		var list = enderecoService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EnderecoClienteDTO> insert(@RequestBody EnderecoClienteDTO dto) {
		EnderecoClienteDTO enderecoDTO = enderecoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((enderecoDTO.getId_endereco())).toUri();
		return ResponseEntity.created(uri).body(enderecoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoClienteDTO> update(
			@PathVariable Long id,
			@RequestBody EnderecoClienteDTO dto
			){
		var endereco = enderecoService.update(id, dto);
		return ResponseEntity.ok(endereco);
		//dto = veiculoService.update(id, dto);
		//return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		enderecoService.delete(id);
	       return ResponseEntity.noContent().build();
	}

}
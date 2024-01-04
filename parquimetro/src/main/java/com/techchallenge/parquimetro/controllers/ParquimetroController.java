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

import com.techchallenge.parquimetro.DTO.ParquimetroClienteDTO;
import com.techchallenge.parquimetro.service.ParquimetroService;

@RestController
@RequestMapping(value = "/parquimetro")
public class ParquimetroController {
   
	//Atributo da classe Service 
	private final ParquimetroService parquimetroService;
	
	//Construtor 
	public ParquimetroController(ParquimetroService parquimetroService) {
		this.parquimetroService = parquimetroService;
		
	}
	
	//Metodo findById
	@GetMapping("/{id}")
	public ResponseEntity<ParquimetroClienteDTO> findById(@PathVariable long id) {
		ParquimetroClienteDTO parquimetroDTO = parquimetroService.findByiD(id);
		return ResponseEntity.ok(parquimetroDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<ParquimetroClienteDTO>> findAll(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade,
			@RequestParam(value = "direcao", defaultValue = "DESC") String direcao,
			@RequestParam(value = "ordenacao", defaultValue = "tipoTempo") String ordenacao) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidade, Sort.Direction.valueOf(direcao),ordenacao);
		var list = parquimetroService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ParquimetroClienteDTO> insert(@RequestBody ParquimetroClienteDTO dto) {
		ParquimetroClienteDTO parquimetroDTO = parquimetroService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((parquimetroDTO.getId_parquimetro())).toUri();
		return ResponseEntity.created(uri).body(parquimetroDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParquimetroClienteDTO> update(
			@PathVariable Long id,
			@RequestBody ParquimetroClienteDTO dto
			){
		var parquimetro = parquimetroService.update(id, dto);
		return ResponseEntity.ok(parquimetro);
		//dto = veiculoService.update(id, dto);
		//return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		parquimetroService.delete(id);
	       return ResponseEntity.noContent().build();
	}

}
	
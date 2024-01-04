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

import com.techchallenge.parquimetro.DTO.VeiculoClienteDTO;
import com.techchallenge.parquimetro.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {
   
	//Atributo da classe Service 
	private final VeiculoService veiculoService;
	
	//Construtor 
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
		
	}
	
	//Metodo findById
	@GetMapping("/{id}")
	public ResponseEntity<VeiculoClienteDTO> findById(@PathVariable long id) {
		VeiculoClienteDTO veiculoDTO = veiculoService.findByiD(id);
		return ResponseEntity.ok(veiculoDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<VeiculoClienteDTO>> findAll(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade,
			@RequestParam(value = "direcao", defaultValue = "DESC") String direcao,
			@RequestParam(value = "ordenacao", defaultValue = "placa") String ordenacao) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidade, Sort.Direction.valueOf(direcao),ordenacao);
		var list = veiculoService.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<VeiculoClienteDTO> insert(@RequestBody VeiculoClienteDTO dto) {
		VeiculoClienteDTO veiculoDTO = veiculoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((veiculoDTO.getId_veiculo())).toUri();
		return ResponseEntity.created(uri).body(veiculoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VeiculoClienteDTO> update(
			@PathVariable Long id,
			@RequestBody VeiculoClienteDTO dto
			){
		var veiculo = veiculoService.update(id, dto);
		return ResponseEntity.ok(veiculo);
		//dto = veiculoService.update(id, dto);
		//return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
	       veiculoService.delete(id);
	       return ResponseEntity.noContent().build();
	}

}
	
package br.edu.ifg.sistemaleilao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifg.sistemaleilao.model.Lance;
import br.edu.ifg.sistemaleilao.service.LanceService;

@RestController
@RequestMapping("/leilao")
public class LanceController {

	@Autowired
	LanceService service;
	
	@GetMapping("/lances/{id}")
	public List<Lance> listarLancesId(@PathVariable Long id){
		return service.listarPorLeilao(id);
	}
	
	@PostMapping("/lance")
	public ResponseEntity<Lance> salvarLance(@RequestBody @Valid Lance lance) {
		return service.checar(lance);
	}

	@PutMapping("/lance")
	public Lance atualizarLance(@RequestBody @Valid Lance lance) {
		return service.salvar(lance);
	}
	
	@DeleteMapping("/lance")
	public void deletarLance(@RequestBody Lance lance) {
		service.deletar(lance);
	}
	
}

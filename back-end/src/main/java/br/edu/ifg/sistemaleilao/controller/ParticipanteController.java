package br.edu.ifg.sistemaleilao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifg.sistemaleilao.model.Participante;
import br.edu.ifg.sistemaleilao.service.ParticipanteService;

@RestController
@RequestMapping("/leilao")
public class ParticipanteController {
	
	@Autowired
	ParticipanteService service;

	@GetMapping("/participantes")
	public List<Participante> listarParticipantes(){
		return service.listar();
	}
	
	@PostMapping("/participante")
	public Participante salvarParticipante(@RequestBody @Valid Participante participante) {
		return service.salvar(participante);
	}
	
	@PutMapping("/participante")
	public Participante atualizarParticipante(@RequestBody @Valid Participante participante) {
		return service.salvar(participante);
	}
	
	@DeleteMapping("/participante")
	public void deletarParticipante(@RequestBody Participante participante) {
		service.deletar(participante);
	}
	
}

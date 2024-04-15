package br.edu.ifg.sistemaleilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifg.sistemaleilao.model.Participante;
import br.edu.ifg.sistemaleilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	ParticipanteRepository repository;
	
	public Participante salvar(Participante participante) {
		return repository.save(participante);
	}
	
	public void deletar(Participante participante) {
		repository.delete(participante);
	}
	
	public List<Participante> listar(){
		return repository.findAll();
	}
}

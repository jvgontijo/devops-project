package br.edu.ifg.sistemaleilao.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifg.sistemaleilao.model.Leilao;
import br.edu.ifg.sistemaleilao.model.StatusSituacao;
import br.edu.ifg.sistemaleilao.repository.LeilaoRepository;

@Service
public class LeilaoService {

	@Autowired
	LeilaoRepository repository;
	
	public List<Leilao> listar() {
		List<Leilao> listaLeilao = repository.findAll();
	    for(Leilao leilao : listaLeilao){
	        LocalDate date = LocalDate.parse(leilao.getDataFechamento());
	        if(date.isBefore(LocalDate.now())) {
	            if(leilao.getStatus().equals(StatusSituacao.INATIVO)){
	                leilao.setStatus(StatusSituacao.EXPIRADO);
	                salvar(leilao);
	            }
	            if(leilao.getStatus().equals(StatusSituacao.ABERTO)){
	                leilao.setStatus(StatusSituacao.EXPIRADO);
	                salvar(leilao);
	            }
	        }
	    }
	    listaLeilao = repository.findAll();
	    return listaLeilao;
	}
	
	public Leilao salvar(Leilao leilao) {
		return repository.save(leilao);
	}
	
	public List<Leilao> listarPorStatus(StatusSituacao status){
		return repository.findByStatus(status);
	}
	
	public void deletar(Leilao leilao) {
		repository.delete(leilao);
	}
	
	
}

package br.edu.ifg.sistemaleilao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.sistemaleilao.model.Leilao;
import br.edu.ifg.sistemaleilao.model.StatusSituacao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long>{
	
	List<Leilao> findByStatus(StatusSituacao status);
}

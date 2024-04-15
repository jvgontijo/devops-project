package br.edu.ifg.sistemaleilao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.sistemaleilao.model.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long>{
	
	List<Lance> findByLeilao_Id(Long leilaoId);
	
	Lance findTopByOrderByIdDesc();
	
	Lance findTopByOrderByValorDesc();
	
	List<Lance> findTop2ByOrderByIdDesc();
}

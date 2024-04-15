package br.edu.ifg.sistemaleilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifg.sistemaleilao.model.Lance;
import br.edu.ifg.sistemaleilao.repository.LanceRepository;

@Service
public class LanceService {

    @Autowired
    LanceRepository repository;

    public List<Lance> listar() {
        return repository.findAll();
    }

    public List<Lance> listarPorLeilao(Long id) {
        return repository.findByLeilao_Id(id);
    }

    public ResponseEntity<Lance> checar(Lance lance) {

        List<Lance> listaLances = repository.findAll();

        double valor = 0;
        if (lance.getValor() < lance.getLeilao().getLanceMinimo()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for (Lance lance2 : listaLances) {
            if (lance2.getLeilao().getId() == lance.getLeilao().getId()) {
                if (lance.getValor() < lance2.getLeilao().getLanceMinimo()) {
                    valor = lance2.getLeilao().getLanceMinimo();
                }
                if (valor <= lance2.getValor()) {
                    valor = lance2.getValor();
                }
            }
        }

        for (Lance lance2 : listaLances) {
            if (lance2.getLeilao().getId() == lance.getLeilao().getId()) {
                if (lance.getValor() <= valor) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
        }

        if (repository.findTopByOrderByIdDesc() == null) {
            salvar(lance);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        if (lance.getLeilao().getId() == repository.findTopByOrderByIdDesc().getLeilao().getId()
                && lance.getParticipante().getId() == repository.findTopByOrderByIdDesc().getParticipante().getId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Lance> listaParcitipanteID = repository.findTop2ByOrderByIdDesc();
        for (Lance lance2 : listaParcitipanteID) {
            if (lance.getParticipante().getId() == repository.findTopByOrderByIdDesc().getParticipante().getId()
                    && lance2.getLeilao().getId() == lance.getLeilao().getId()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        salvar(lance);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public Lance salvar(Lance lance) {
        return repository.save(lance);
    }

    public void deletar(Lance lance) {
        repository.delete(lance);
    }

}
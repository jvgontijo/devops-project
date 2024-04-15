package br.edu.ifg.sistemaleilao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome to Item não pode estar em branco")
    private String item;

    @NotBlank(message = "Data de abertura não pode estar em branco")
    private String dataAbertura;

    @NotNull
    private double lanceMinimo;

    @NotBlank(message = "Data de fechamento não pode estar em branco")
    private String dataFechamento;

    @Enumerated(EnumType.STRING)
    private StatusSituacao status = StatusSituacao.INATIVO;

    @ManyToOne
    private Lance lanceAtual;

    @OneToMany
    private List<Lance> lances = new ArrayList<>();

}
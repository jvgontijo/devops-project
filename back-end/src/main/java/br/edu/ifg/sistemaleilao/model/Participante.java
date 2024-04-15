package br.edu.ifg.sistemaleilao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	@Size(min = 5)
	private String nome;

	@NotBlank(message = "Telefone não pode estar em branco")
	@Size(min = 10, max = 11)
	private String telefone;

	@NotBlank(message = "Email não pode estar em branco")
	@Size(min = 8)
	private String email;

	@NotBlank(message = "Data Nascimento não pode estar em branco")
	@Size(min = 8)
	private String dataNascimento;

	@NotBlank(message = "CPF não pode estar em branco")
	@Size(min = 11, max = 11)
	private String cpf;

}

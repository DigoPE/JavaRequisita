package com.projetorodrigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({												   
	@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),	   
	@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE codigo = :codigo")
})

public class Usuario {

	@Id // O @ID serve para informar que esse campo fab_codigo é uma chave primaria da tabela.
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera o auto incremento para o campo chave da tabela.
	@Column(name = "usu_codigo")
	private Long codigo;
	
	
	//Anotations (Validador)de Validação dos campos no formulário.
	@NotEmpty(message = "O campo nome é Obrigatório.")
	@Size(min = 5, max = 50, message = "O nome só é válido com o internvalo de 5 a 50 caracteres.")
	
	@Column(name = "usu_nome", length = 50, nullable = false)
	private String nome;
	
	//Validador E-mail
	@Email(message = "E-mail Inválido!")
	@Column(name = "usu_email", length = 14, nullable = false, unique = true)
	private String email;

	@NotEmpty(message = "Campo senha é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo senha, terá que ser de 6 a 8 caracteres.")
	@Column(name = "usu_senha", length = 32, nullable = false)
	private String senha;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	    
    
}

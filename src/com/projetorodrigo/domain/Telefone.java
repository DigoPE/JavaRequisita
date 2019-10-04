package com.projetorodrigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.projetorodrigo.domain.Usuario;

//Metodo para criação de Entidades das Tabelas.
//No caso tabela tbl_telefones.
@Entity
@Table(name = "tbl_telefones")
//Utilizando o HQL, coloca o nome da entidade ao invés da tabela, isso facilita a manutenção so sistema.
@NamedQueries({	
	@NamedQuery(name = "Telefone.listar", query = "SELECT telefone FROM Telefone telefone"), 
	@NamedQuery(name = "Telefone.buscarPorCodigo", query = "SELECT telefone FROM Telefone telefone WHERE telefone.tel_codigo = :tel_codigo")
})


public class Telefone {

	@Id // O @ID serve para informar que esse campo tel_codigo é uma chave primaria da tabela.
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera o auto incremento para o campo chave da tabela.
	@Column(name = "tel_codigo")
	private Long tel_codigo;

	@Column(name = "tel_ddd", length = 50, nullable = false)
	private Number tel_ddd;
	
	@Column(name = "tel_numero", precision = 9, scale = 2, nullable = false)
	private String tel_numero;
	
	@Column(name = "tel_tipo", nullable = false)
	private String tel_tipo;
	
	//Relacionamento para a chave estrangeira (m para 1).
	@ManyToOne(fetch = FetchType.EAGER)
	//Relaciona as duas tabelas com a chave estrangeira da tabela, por esse motivo. 
	//Não se usa @Column e sim @JoinColumn, como se fosse o INNER JOIN.
	//Coloca em "name" o nome da tabela filha e "referencedColumnName" quer dizer, qual o nome dele na tabela pai.
	@JoinColumn(name = "tbl_usuarios_usu_codigo", referencedColumnName = "usu_codigo", nullable = false)
	private Usuario usuario;

	public Long getTeleCodigo() {
		return tel_codigo;
	}

	public void setTeleCodigo(Long tel_codigo) {
		this.tel_codigo = tel_codigo;
	}

	public Number getTeleDDD() {
		return tel_ddd;
	}

	public void setTeleDDD(Number tel_ddd) {
		this.tel_ddd = tel_ddd;
	}

	public String getTeleNumero() {
		return tel_numero;
	}

	public void setTeleNumero(String tel_numero) {
		this.tel_numero = tel_numero;
	}

	public String getTeleTipo() {
		return tel_tipo;
	}

	public void setTeleTipo(String tel_tipo) {
		this.tel_tipo = tel_tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Telefone [codigo=" + tel_codigo + ", tel_ddd=" + tel_ddd + ", tel_numero=" + tel_numero + ", tel_tipo="
				+ tel_tipo + ", usuario=" + usuario + "]";
	}

}

package com.projetorodrigo.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.projetorodrigo.dao.UsuarioDAO;
import com.projetorodrigo.dao.TelefoneDAO;
import com.projetorodrigo.domain.Usuario;
import com.projetorodrigo.domain.Telefone;

public class TelefoneDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(5L);
		
		Telefone telefone = new Telefone();
		telefone.setTeleDDD(81);
		telefone.setTeleNumero("98884-4524");
		telefone.setTeleTipo("Celular");
		telefone.setUsuario(usuario);
		
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		telefoneDAO.salvar(telefone);
	}
	
	@Test
	@Ignore
	public void listar(){
		TelefoneDAO dao = new TelefoneDAO();
		List<Telefone> telefones = dao.listar();
		//Listagem sem o for
		System.out.println(telefones);
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		TelefoneDAO dao = new TelefoneDAO();
		
		Telefone prod1 = dao.buscarPorCodigo(1L);
		
		System.out.println(prod1);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		TelefoneDAO dao = new TelefoneDAO();
		
		Telefone telefone = dao.buscarPorCodigo(2L);
		
		if(telefone != null){
			dao.excluir(telefone);
		}
	}

	//Editar 
	@Test
	@Ignore
	public void editar(){
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		
		Telefone telefone = telefoneDAO.buscarPorCodigo(1L);
		
		telefone.setTeleDDD(81);
		telefone.setTeleNumero("3444-8888");
		telefone.setTeleTipo("Residencial");
		
		//Ajuste para troca de chave estrangeira.
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);
		telefone.setUsuario(usuario);
		
		telefoneDAO.editar(telefone);
		
	}
}

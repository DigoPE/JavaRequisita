package com.projetorodrigo.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.projetorodrigo.dao.UsuarioDAO;
import com.projetorodrigo.domain.Usuario;

public class UsuarioDAOTeste {
	@Test
	@Ignore //Ignora o salvar()
	public void salvar(){
		
		Usuario usuario = new Usuario();
		usuario.setemail("usu@bol.com.br");
		usuario.setNome("Usuario Teste");
		usuario.setSenha("123");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.salvar(usuario);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.listar();
		
		//Listagem sem o for
		System.out.println(usuarios);
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario f1 = dao.buscarPorCodigo(3L); //3L quer dizer que é 3 do tipo Long.
		Usuario f2 = dao.buscarPorCodigo(17L);
		
		System.out.println(f1);
		System.out.println(f2);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = dao.buscarPorCodigo(3L);
		
		dao.excluir(usuario);
		
	}
	
	//Editar 
	@Test
	@Ignore
	public void editar(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorCodigo(2L);
		
		usuario.setemail("usu@bol.com.br");
		usuario.setNome("Rodrigo Barros dos Santos");
		usuario.setSenha("123456");
		
		dao.editar(usuario);
		
	}
}

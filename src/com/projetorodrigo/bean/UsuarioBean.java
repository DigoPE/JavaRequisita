package com.projetorodrigo.bean;

import java.util.List;

import com.projetorodrigo.dao.UsuarioDAO;
import com.projetorodrigo.domain.Usuario;
import com.projetorodrigo.util.FacesUtil;

public class UsuarioBean {


	private Usuario UsuarioCadastro;
	private List<Usuario> listaUsuario;
	private List<Usuario> listaUsuarioFiltrado;
	private String acao; 
	private Long codigo;
	
		//Esse é o Get and Set's da Tela de Usuario.java em domain.
		public Usuario getUsuarioCadastro() {
			return UsuarioCadastro;
		}
		public void setUsuarioCadastro(Usuario UsuarioCadastro) {
			this.UsuarioCadastro = UsuarioCadastro;
		}
		
		//Esse é o Get and Set's para a Listagem de Usuarios
		public List<Usuario> getListaUsuario() {
			return listaUsuario;
		}
		
		public void setListaUsuario(List<Usuario> listaUsuario) {
			this.listaUsuario = listaUsuario;
		}
		
		public List<Usuario> getListaUsuarioFiltrado() {
			return listaUsuarioFiltrado;
		}
		
		public void setListaUsuarioFiltrado(List<Usuario> listaUsuarioFiltrado) {
			this.listaUsuarioFiltrado = listaUsuarioFiltrado;
		}
	
		public String getAcao() {
			return acao;
		}
		public void setAcao(String acao) {
			this.acao = acao;
		}
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public void novo(){
			//Reinstanciar para que o formulario seja limpo.
		}
	
	public void salvar(){
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.salvar(UsuarioCadastro);
			
			//Reinstanciar para que o formulario seja limpo após o cadastro.
			UsuarioCadastro = new Usuario();
			
			FacesUtil.addMsgInfo("Usuario Salvo com Sucesso!");
						
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgErro("Erro ao tentar incluir o Usuario: " + ex.getMessage());
		}
	}

	
	public void carregarPesq(){
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			listaUsuario = UsuarioDAO.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace(); 
			FacesUtil.addMsgErro("Erro ao tentar carregar Pesquisa do Usuario: " + ex.getMessage());
		}
		
	}
	
	public void carregarCadastro(){
		try {
			if(codigo != null){
				UsuarioDAO UsuarioDAO = new UsuarioDAO();
				
				UsuarioCadastro = UsuarioDAO.buscarPorCodigo(codigo);
			}else{
				//Caso o valor vier nulo ele instancia do UsuarioCadastro.
				UsuarioCadastro = new Usuario();
			}
			
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Erro ao tentar carregar o Usuario: " + ex.getMessage());
		}
		
	}
	
	public void excluir(){
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.excluir(UsuarioCadastro);
			
			FacesUtil.addMsgInfo("Usuario Excluído com Sucesso!");
						
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Erro ao tentar excluir o Usuario: " + ex.getMessage());
		}

	}
	
	public void editar(){
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.editar(UsuarioCadastro);
					
			FacesUtil.addMsgInfo("Usuario Editado com Sucesso!");
						
		} catch (RuntimeException ex) {
			ex.printStackTrace(); //Isso ratreia o erro. Pode ser utilizado para debugar o código, serve apenas para o programador.
			FacesUtil.addMsgErro("Erro ao tentar editar os dados do Usuario: " + ex.getMessage());
		}
	}
	
	
}

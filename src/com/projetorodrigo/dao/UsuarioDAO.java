package com.projetorodrigo.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projetorodrigo.domain.Usuario;
import com.projetorodrigo.util.HibernateUtil;

public class UsuarioDAO {
	//SalvaUsuario.
			public void salvar(Usuario usuario){
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				Transaction transacao = null;
				
				try {
					transacao = sessao.beginTransaction();
					sessao.save(usuario);
					transacao.commit();
					
					//JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!!");
					
				} catch (RuntimeException ex) {
					if(transacao != null){
						transacao.rollback();
						JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
					}
					throw ex;
				}finally {
					sessao.close();
				}
				
			}
			

			//Listar Usuario.
			@SuppressWarnings("unchecked")
			public List<Usuario> listar(){
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				List<Usuario> usuarios = null;
				Query consulta = null;
				
				try {
					consulta = sessao.getNamedQuery("Usuario.listar");
					usuarios = consulta.list();
					
					//JOptionPane.showMessageDialog(null, "Usuarios Listados com Sucesso!!");
					
				} catch (RuntimeException ex) {
					if(consulta != null){
						JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
					}
					throw ex;
				}finally {
					sessao.close();
				}
				return usuarios;
			}
			

			//Busca Usuario com Pesquisa.
			public Usuario buscarPorCodigo(Long codigo){
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				Usuario usuario = null;
				
				try {
					Query consulta = sessao.getNamedQuery("Usuario.buscarPorCodigo");
					consulta.setLong("codigo", codigo);
					
					usuario = (Usuario) consulta.uniqueResult();
					
					//JOptionPane.showMessageDialog(null, "Usuarios Buscado com Sucesso!!");
					
				} catch (RuntimeException ex) {
					if(usuario != null){
						JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
					}
					throw ex;
				}finally {
					sessao.close();
				}
				return usuario;
			}
			
			//Exclui Usuario
			public void excluir(Usuario usuario){
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				Transaction transacao = null;
				
				try {
					transacao = sessao.beginTransaction();
					sessao.delete(usuario);
					transacao.commit();
					
					//JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso!!");
					
				} catch (RuntimeException ex) {
					if(transacao != null){
						transacao.rollback();
						JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
					}
					throw ex;
				}finally {
					sessao.close();
				}
				
			}
			

			//Editar Usuario.
			public void editar(Usuario usuario){
				Session sessao = HibernateUtil.getSessionFactory().openSession();
				Transaction transacao = null;
				
				try {
					transacao = sessao.beginTransaction();
					//Dessa forma, temos que ter certeza que todos os campos obrigatorios estejam preenchidos.
					sessao.update(usuario);
					transacao.commit();
					
					//JOptionPane.showMessageDialog(null, "Usuario Editado com Sucesso!!");
					
				} catch (RuntimeException ex) {
					if(transacao != null){
						transacao.rollback();
						JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
					}
					throw ex;
				}finally {
					sessao.close();
				}
				
			}
}

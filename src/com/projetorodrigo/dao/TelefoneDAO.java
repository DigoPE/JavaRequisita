package com.projetorodrigo.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projetorodrigo.domain.Telefone;
import com.projetorodrigo.util.HibernateUtil;

public class TelefoneDAO {


	public void salvar(Telefone telefone){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(telefone);
			transacao.commit();
			
			JOptionPane.showMessageDialog(null, "Telefone Cadastrado com Sucesso!!");
			
		} catch (Exception ex) {
			if(transacao != null){
				transacao.rollback();
				JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
			}
			throw ex; //Repropago a sessão, para exibir o erro.
		}finally {
			sessao.close();
		}
	}
	
	//Listar Telefone.
		@SuppressWarnings("unchecked")
		public List<Telefone> listar(){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<Telefone> telefones = null;
			Query consulta = null;
			
			try {
				consulta = sessao.getNamedQuery("Telefone.listar");
				telefones = consulta.list();
				
				JOptionPane.showMessageDialog(null, "Telefones Listados com Sucesso!!");
				
			} catch (RuntimeException ex) {
				if(consulta != null){
					JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
				}
				throw ex;
			}finally {
				sessao.close();
			}
			return telefones;
		}
		

		public Telefone buscarPorCodigo(Long codigo){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Telefone telefone = null;
			
			try {
				Query consulta = sessao.getNamedQuery("Telefone.buscarPorCodigo");
				         //codigo do HQL,  codigo do parâmetro
				consulta.setLong("codigo", codigo);
				
				telefone = (Telefone) consulta.uniqueResult();
				
				JOptionPane.showMessageDialog(null, "Telefones Buscado com Sucesso!!");
				
			} catch (RuntimeException ex) {
				if(telefone != null){
					JOptionPane.showMessageDialog(null, "Erro Fatal: " + ex);
				}
				throw ex;
			}finally {
				sessao.close();
			}
			return telefone;
		}
		
		//Exclui Telefone
		public void excluir(Telefone telefone){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(telefone);
				transacao.commit();
				
				JOptionPane.showMessageDialog(null, "Telefone Excluido com Sucesso!!");
				
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
		
		//Edita Telefone.
		public void editar(Telefone telefone){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try {
				transacao = sessao.beginTransaction();

				//Dessa forma, temos que ter certeza que todos os campos obrigatorios estejam preenchidos.
				sessao.update(telefone);
				transacao.commit();
				
				JOptionPane.showMessageDialog(null, "Telefone Editado com Sucesso!!");
				
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

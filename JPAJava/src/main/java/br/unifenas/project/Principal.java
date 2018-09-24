package br.unifenas.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unifenas.model.Aluno;
import br.unifenas.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = JPAUtil.getEntityMananger();
		
		Aluno aluno = new Aluno("João", "143412", "223.432.123-54");
		
		//Inserir
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		
		//Busca por Id
		Aluno alunoBusca = em.find(Aluno.class, 1);
	    System.out.println("Objeto Consultado: " + alunoBusca.getNome());
	    
	    //Remove
	    em.getTransaction().begin();
	    em.remove(alunoBusca);
	    em.getTransaction().commit();
	    
	    //Altera
	    alunoBusca.setNome("Maria");
	    em.getTransaction().begin();
	    em.merge(alunoBusca);
	    em.getTransaction().commit();
	    
		
		//Busca Todos
	    Query query = em.createQuery("from Aluno");
	    List<Aluno> alunos = query.getResultList();
	    
	    for (Aluno al : alunos) {
			System.out.println("Cliente:" + al.getNome());
		}
	    
	    JPAUtil.close();
		
	}

}

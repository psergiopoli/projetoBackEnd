package br.com.projetoteste.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.projetoteste.models.Contato;

@Repository
@Transactional 
public class ContatoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Contato> all()
   {
      return manager.createQuery("select c from Contato c", Contato.class).getResultList();
   }
   
   @SuppressWarnings("unchecked")
   public List<Contato> findByUser(Integer usuarioId)
   {
      Query query = manager.createQuery("select c from Contato c where c.usuario.id=:usuarioid", Contato.class);
      query.setParameter("usuarioid", usuarioId);
      return query.getResultList();
   }

   public Contato save(Contato contato)
   {
      manager.persist(contato);
      manager.flush();
      return contato;
   }

   public Contato findById(Integer id)
   {
      return manager.find(Contato.class, id);
   }

   public void remove(Contato contato)
   {
      manager.remove(contato);
   }

   public Contato update(Contato contato)
   {
      manager.merge(contato);
      manager.flush();
      return contato;
   }

}

package br.com.projetoteste.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.projetoteste.models.Usuario;

@Repository
@Transactional 
public class UsuarioDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Usuario> all()
   {
      return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
   }

   public Usuario save(Usuario usuario)
   {
      manager.persist(usuario);
      manager.flush();
      return usuario;
   }

   public Usuario findById(Integer id)
   {
      return manager.find(Usuario.class, id);
   }

   public void remove(Usuario usuario)
   {
      manager.remove(usuario);
   }

   public Usuario update(Usuario usuario)
   {
      manager.merge(usuario);
      manager.flush();
      return usuario;
   }

}

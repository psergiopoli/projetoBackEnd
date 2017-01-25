package br.com.projetoteste.endpoint.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoteste.daos.UsuarioDao;
import br.com.projetoteste.models.Usuario;

@RestController
public class UsuarioEndpoints {
	
	@Autowired
	UsuarioDao usuarioDao;
	
    @RequestMapping(value = "/usuario/list",method = RequestMethod.GET)
    public List<Usuario> list() {
        return usuarioDao.all();
    }
    
    @RequestMapping(value = "/usuario/{usuarioId}",method = RequestMethod.GET)
    public Usuario list(@PathVariable Integer usuarioId) {
        return usuarioDao.findById(usuarioId);
    }
    
    @RequestMapping(value = "/usuario",method = RequestMethod.POST)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioDao.save(usuario);
    }
    
    @RequestMapping(value = "/usuario/{usuarioId}",method = RequestMethod.PUT)
    public Usuario update(@PathVariable Integer usuarioId,@RequestBody Usuario usuario) {
    	usuario.setId(usuarioId);
        return usuarioDao.update(usuario);
    }
}

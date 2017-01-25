package br.com.projetoteste.endpoint.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoteste.daos.ContatoDao;
import br.com.projetoteste.daos.UsuarioDao;
import br.com.projetoteste.models.Contato;
import br.com.projetoteste.models.Usuario;

@RestController
public class ContatoEndpoints {
	
	@Autowired
	ContatoDao contatoDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
    @RequestMapping(value = "/contato/list",method = RequestMethod.GET)
    public List<Contato> list() {
        return contatoDao.all();
    }
    
    @RequestMapping(value = "/contato/list/{usuarioId}",method = RequestMethod.GET)
    public List<Contato> listByUser(@PathVariable Integer usuarioId) {
        return contatoDao.findByUser(usuarioId);
    }
    
    @RequestMapping(value = "/contato/{contatoId}",method = RequestMethod.GET)
    public Contato list(@PathVariable Integer contatoId) {
        return contatoDao.findById(contatoId);
    }
    
    @RequestMapping(value = "/contato/usuario/{usuarioId}",method = RequestMethod.POST)
    public Contato save(@RequestBody Contato contato,@PathVariable Integer usuarioId) {
    	Usuario usuario = usuarioDao.findById(usuarioId);
    	contato.setUsuario(usuario);
        return contatoDao.save(contato);
    }
    
    @RequestMapping(value = "/contato/{contatoId}/usuario/{usuarioId}",method = RequestMethod.PUT)
    public Contato update(@PathVariable Integer contatoId,@PathVariable Integer usuarioId,@RequestBody Contato contato) {
       	Usuario usuario = usuarioDao.findById(usuarioId);
    	contato.setUsuario(usuario);
    	contato.setId(contatoId);
        return contatoDao.update(contato);
    }
}

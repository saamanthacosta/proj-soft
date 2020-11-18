package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.model.Vendedor;
import projetoSoftware.com.mercado.repository.UsuarioRepository;


@Service
public class VendedorServico {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean autentica(Vendedor usuario){
        return usuarioRepository.login(usuario);

    }
}

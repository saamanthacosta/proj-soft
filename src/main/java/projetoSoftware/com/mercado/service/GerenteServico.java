package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Gerente;
import projetoSoftware.com.mercado.repository.GerenteRepository;


@Service
public class GerenteServico {

    @Autowired
    GerenteRepository gerenteRepository;


    public boolean autentica(String usuario, String senha) {
        try {
            Gerente gerente = gerenteRepository.findByUsuario(usuario);
            return gerente != null && senha.equals(gerente.getSenha());
        } catch (Exception err) {
            return false;
        }
    }

}

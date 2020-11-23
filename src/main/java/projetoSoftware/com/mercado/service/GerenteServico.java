package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.enumerado.cargoEnum;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.repository.UsuarioRepository;


@Service
public class GerenteServico {

    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario autentica(String usuario, String senha) {
        try {
            Usuario gerente = usuarioRepository.findByUsuario(usuario);
            if (gerente != null && senha.equals(gerente.getSenha()) && gerente.getCargo().equals(cargoEnum.GERENTE)){
                return gerente;
            }return null;

        } catch (Exception err) {
            return null;
        }
    }

}

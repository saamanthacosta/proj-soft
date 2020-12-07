package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.enumerado.cargoEnum;
import projetoSoftware.com.mercado.modelo.Usuario;
import projetoSoftware.com.mercado.repositorio.UsuarioRepositorio;


@Service
public class GerenteServico {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    public Usuario autentica(String usuario, String senha) {
        try {
            Usuario gerente = usuarioRepositorio.findByUsuario(usuario);
            if (gerente != null && senha.equals(gerente.getSenha()) && gerente.getCargo().equals(cargoEnum.GERENTE)) {
                return gerente;
            }
            return null;

        } catch (Exception err) {
            return null;
        }
    }

    public Usuario criar(Usuario gerente) {
        try {
            return usuarioRepositorio.save(gerente);
        } catch (Exception e) {
            return null;
        }
    }

}

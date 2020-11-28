package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.Usuario;
import projetoSoftware.com.mercado.modelo.Venda;
import projetoSoftware.com.mercado.repositorio.UsuarioRepositorio;

@Service
public class VendedorServico {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario login(String usuario, String senha) {
        try {
            Usuario vendedor = usuarioRepositorio.findByUsuario(usuario);
            if (vendedor != null && senha.equals(vendedor.getSenha())) {
                vendedor.setSenha("");
                return vendedor;
            }
            return null;

        } catch (Exception err) {
            return null;
        }
    }

    public Venda iniciarVenda(String cliente_cpf, String vendedor_id) {
        //n eh pra ser feito
        return null;
    }
}

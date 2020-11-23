package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.repository.UsuarioRepository;

@Service
public class VendedorServico {

    @Autowired
    UsuarioRepository usuarioRepository;



    public Usuario login(String usuario, String senha) {
        try {
            Usuario vendedor = usuarioRepository.findByUsuario(usuario);
            if(vendedor != null && senha.equals(vendedor.getSenha())) {
                vendedor.setSenha("");
                return vendedor;
            } return null;

        } catch (Exception err) {
            return null;
        }
    }

    public Venda iniciarVenda(String cliente_cpf, String vendedor_id) {
        //n eh pra ser feito
        return null;
    }
}

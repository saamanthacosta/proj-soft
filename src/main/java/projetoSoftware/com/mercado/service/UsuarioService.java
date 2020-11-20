package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario login(String usuario, String senha){
        try{
            Usuario user = usuarioRepository.findByUsuario(usuario);
            if (user != null && senha.equals(user.getSenha())){
                user.setSenha("");
                return user;
            }
            else{
                return null;
            }
        }catch (Exception err){
            return null;
        }
    }
}

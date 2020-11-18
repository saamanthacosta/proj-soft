package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario login(Usuario usuario);
}

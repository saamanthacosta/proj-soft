package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    Usuario save(Usuario usuario);

    Usuario findByUsuario(String usuario);
}

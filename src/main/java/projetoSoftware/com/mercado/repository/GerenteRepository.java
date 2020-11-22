package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, String> {
   Gerente save(Gerente usuario);
   Gerente findByUsuario(String usuario);
}

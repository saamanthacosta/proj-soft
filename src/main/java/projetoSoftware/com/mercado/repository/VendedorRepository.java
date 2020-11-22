package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String> {
   Vendedor save(Vendedor usuario);
   Vendedor findByUsuario(String usuario);
}

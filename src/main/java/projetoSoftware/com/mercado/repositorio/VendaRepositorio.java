package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Integer> {
    Venda save(Venda venda);
}

package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Venda;

public interface VendaRepository extends JpaRepository<Venda,Integer> {
    Venda save(Venda venda);
}

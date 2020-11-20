package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Estoque findByCodigoDeBarrasProduto(Integer codigoDeBarras);
    Estoque save(Estoque estoque);
}

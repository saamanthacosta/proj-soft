package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Estoque;

public interface EstoqueRepositorio extends JpaRepository<Estoque, Integer> {
    Estoque findByCodigoDeBarrasProduto(Integer codigoDeBarras);

    Estoque save(Estoque estoque);
}

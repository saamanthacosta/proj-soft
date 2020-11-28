package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    Produto encontrarPorCodigoDeBarras(Integer codigoDeBarras);

    Produto save(Produto produto);

    void delete(Produto produto);
}

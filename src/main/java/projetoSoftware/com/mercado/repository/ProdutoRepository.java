package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findBycodigoDeBarras(Integer codigoDeBarras);
    Produto save(Produto produto);
    void delete(Produto produto);
}

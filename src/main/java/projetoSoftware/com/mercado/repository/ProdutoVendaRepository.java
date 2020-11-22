package projetoSoftware.com.mercado.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.ProdutoVenda;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Integer> {
    ProdutoVenda save(ProdutoVenda produtoVenda);

}

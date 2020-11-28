package projetoSoftware.com.mercado.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.ProdutoVenda;

public interface ProdutoVendaRepositorio extends JpaRepository<ProdutoVenda, Integer> {
    ProdutoVenda save(ProdutoVenda produtoVenda);

}
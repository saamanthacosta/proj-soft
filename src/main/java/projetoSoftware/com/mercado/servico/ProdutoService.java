package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.Produto;
import projetoSoftware.com.mercado.repositorio.ProdutoRepositorio;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepositorio produtoRepositorio;

    @Autowired
    EstoqueService estoqueService;

    public List<Produto> listProdutos() {
        return produtoRepositorio.findAll();
    }

    public Produto getProdutoById(int codigoDeBarras) {
        return produtoRepositorio.encontrarPorCodigoDeBarras(codigoDeBarras);
    }

    public void createProduto(Produto produto) {
        produtoRepositorio.save(produto);
    }

    public void createProdutoComQuantidade(Produto produto, int quantidade) {
        Produto produtoSalvo = produtoRepositorio.save(produto);
        estoqueService.adcEstoque(produtoSalvo.getCodigoDeBarras(), quantidade);
    }

    public void deleteProduto(Produto produto) {
        produtoRepositorio.delete(produto);
    }

}

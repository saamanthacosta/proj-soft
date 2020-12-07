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

    public List<Produto> listar() {
        return produtoRepositorio.findAll();
    }

    public Produto consultarPorIdentificador(int codigoDeBarras) {
        try{
            return produtoRepositorio.findByCodigoDeBarras(codigoDeBarras);
        }catch (Exception err){
            return null;
        }
    }

    public void criar(Produto produto) {
        produtoRepositorio.save(produto);
    }

    public void criarComQuantidade(Produto produto, int quantidade) {
        Produto produtoSalvo = produtoRepositorio.save(produto);
        estoqueService.adicionar(produtoSalvo.getCodigoDeBarras(), quantidade);
    }

    public void remover(Produto produto) {
        produtoRepositorio.delete(produto);
    }

}

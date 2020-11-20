package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(int codigoDeBarras) {
        return produtoRepository.findBycodigoDeBarras(codigoDeBarras);
    }

    public void createProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public void deleteProduto(Produto produto){ produtoRepository.delete(produto);}

}

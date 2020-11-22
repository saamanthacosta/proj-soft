package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Estoque;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.model.ProdutoVenda;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.repository.ProdutoVendaRepository;
import projetoSoftware.com.mercado.repository.VendaRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class VendaServico {
    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoVendaRepository produtoVendaRepository;
    @Autowired
    ProdutoService produtoService;

    public Venda criarVenda(String cliente, String vendedor, ArrayList<Estoque> produtos, String formaPagamento ){
        try{

            Venda venda = Venda.builder().cliente(cliente).vendedor(vendedor).data(new Date()).formaPagamento(formaPagamento).totalAPagar(calculaPagamento(produtos)).build();
            Venda concluida = vendaRepository.save(venda);
            System.out.println("VendaServico :: criarVenda :: VendaController "+ concluida.getIdentificador());
            this.salvarProdutos(produtos, concluida.getIdentificador() );

            return venda;

        }catch (Exception err){
            System.out.println("VendaServico :: criarVenda :: Erro ao criar venda");
            return null;
        }
    }
    private float calculaPagamento(ArrayList<Estoque> produtos){
        final float[] precoTotal = {0};
        produtos.forEach(estoque -> {
            Produto produto = produtoService.getProdutoById(estoque.getCodigoDeBarrasProduto());
            float valorTotalProduto = produto.getPreco()*estoque.getQuantidade();
            precoTotal[0] = precoTotal[0] + valorTotalProduto;
        });
        return precoTotal[0];
    }
    private void salvarProdutos(ArrayList<Estoque> produtos, Integer idVenda ){
        produtos.forEach(produto -> {
            ProdutoVenda produtoVenda = ProdutoVenda.builder().idProduto(produto.getCodigoDeBarrasProduto()).venda(idVenda).quantidade(produto.getQuantidade()).build();
            produtoVendaRepository.save(produtoVenda);
        });
    }
}

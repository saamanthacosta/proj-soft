package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.*;
import projetoSoftware.com.mercado.enumerado.formaPagamentoEnum;
import projetoSoftware.com.mercado.repositorio.ProdutoVendaRepositorio;
import projetoSoftware.com.mercado.repositorio.VendaRepositorio;

import java.util.ArrayList;
import java.util.Date;

@Service
public class VendaServico {
    @Autowired
    VendaRepositorio vendaRepositorio;

    @Autowired
    ProdutoVendaRepositorio produtoVendaRepositorio;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    EstoqueService estoqueService;
    public Venda criar(String cliente, String vendedor, ArrayList<Estoque> produtos, String formaPagamento) {
        try {

            Venda venda = Venda.builder().cliente(cliente).vendedor(vendedor).data(new Date()).formaPagamento(this.pagar(formaPagamento)).totalAPagar(calculaPagamento(produtos)).build();
            Venda concluida = vendaRepositorio.save(venda);
            System.out.println("VendaServico :: criarVenda :: VendaController " + concluida.getIdentificador());
            this.salvarProdutos(produtos, concluida.getIdentificador());
            return venda;

        } catch (Exception err) {
            System.out.println("VendaServico :: criarVenda :: Erro ao criar venda");
            return null;
        }
    }
    private String pagar(String formapagamento){
        String[] infos = formapagamento.split("\\.");
        System.out.println(infos);
        if (infos[0] == formaPagamentoEnum.CARTAO){
            Cartao.pagar(infos[0],infos[1]);
        }else if(infos[0] == formaPagamentoEnum.PIX){
            Pix.verificarChave(infos[1]);
        }
        return infos[0];
    }
    private float calculaPagamento(ArrayList<Estoque> produtos) {
        final float[] precoTotal = {0};
        produtos.forEach(estoque -> {
            Produto produto = produtoService.consultarPorIdentificador(estoque.getCodigoDeBarrasProduto());
            if(produto != null){
            float valorTotalProduto = produto.getPreco() * estoque.getQuantidade();
            precoTotal[0] = precoTotal[0] + valorTotalProduto;
            }else{
                precoTotal[0]+=0;
            }
        });
        return precoTotal[0];
    }

    private void salvarProdutos(ArrayList<Estoque> produtos, Integer idVenda) {
        produtos.forEach(produto -> {
            ProdutoVenda produtoVenda = ProdutoVenda.builder().idProduto(produto.getCodigoDeBarrasProduto()).venda(idVenda).quantidade(produto.getQuantidade()).build();
            produtoVendaRepositorio.save(produtoVenda);
            estoqueService.retirar(produto.getCodigoDeBarrasProduto(),produto.getQuantidade());
        });
    }
}

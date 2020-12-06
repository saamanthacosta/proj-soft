package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.Estoque;
import projetoSoftware.com.mercado.repositorio.EstoqueRepositorio;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepositorio estoqueRepositorio;

    public Estoque getByProdutoId(int id) {
        return estoqueRepositorio.findByCodigoDeBarrasProduto(id);
    }

    public Estoque adcEstoque(int codigoDeBarrasProduto, int qtdAdc) {
        try {
            Estoque estoque = this.confirmarCodBarras(codigoDeBarrasProduto);
            estoque.adicionar(qtdAdc);

            Estoque novo = estoqueRepositorio.save(estoque);
            System.out.println("EstoqueServico :: adicionarEstoque :: quantidade adicionada no estoque " +
                    novo.getCodigoDeBarrasProduto());
            return novo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Estoque retiraEstoque(int codigoDeBarrasProduto, int qtdRetira) {
        try {
            Estoque estoque = this.confirmarCodBarras(codigoDeBarrasProduto);
            estoque.retirar(qtdRetira);
            Estoque novo = estoqueRepositorio.save(estoque);
            if (novo == null) {
                System.out.println("Não foi possível fazer a retirada do Estoque");
                return null;
            }
            System.out.println("EstoqueServico :: adicionarEstoque ::"+qtdRetira+" unidades retiradas do produto " +
                    novo.getCodigoDeBarrasProduto());
            return novo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Estoque confirmarCodBarras(int codigoDeBarrasProduto) {
        try {
            Estoque estoque = estoqueRepositorio.findByCodigoDeBarrasProduto(codigoDeBarrasProduto);
            if (estoque == null) {
                return new Estoque(codigoDeBarrasProduto, 0);
            }
            return estoque;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

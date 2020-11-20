package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Estoque;
import projetoSoftware.com.mercado.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public Estoque getByProdutoId(int id) {
        return estoqueRepository.findByCodigoDeBarrasProduto(id);
    }

    public Estoque addEstoque(int codigoDeBarrasProduto, int qtdAdd) {
        try {
            Estoque estoque = this.confirmarCodBarras(codigoDeBarrasProduto);
            estoque.addEstoque(qtdAdd);
            Estoque novo = estoqueRepository.save(estoque);
            System.out.println("EstoqueServico :: adicionarEstoque :: quantidade adicionada no estoque " + novo.getCodigoDeBarrasProduto());
            return novo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Estoque retiraEstoque(int codigoDeBarrasProduto, int qtdRetira) {
        try {
            Estoque estoque = this.confirmarCodBarras(codigoDeBarrasProduto);
            estoque.retiraEstoque(qtdRetira);
            Estoque novo = estoqueRepository.save(estoque);
            System.out.println("EstoqueServico :: adicionarEstoque :: quantidade retirada do estoque " + novo.getCodigoDeBarrasProduto());
            return novo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Estoque confirmarCodBarras(int codigoDeBarrasProduto) {
        try {
            Estoque estoque = estoqueRepository.findByCodigoDeBarrasProduto(codigoDeBarrasProduto);
            return estoque;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

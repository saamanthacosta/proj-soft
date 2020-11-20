package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Estoque;
import projetoSoftware.com.mercado.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public Estoque getByProdutoId(int id){
        return estoqueRepository.findByCodigoDeBarrasProduto(id);
    }

   public Estoque addEstoque(int codigoDeBarrasProduto, int qtdAdd){
        try{
            Estoque estoque = this.estoqueRepository.findByCodigoDeBarrasProduto(codigoDeBarrasProduto);
            estoqueRepository.addEstoque(qtdAdd);

        }
   }

}

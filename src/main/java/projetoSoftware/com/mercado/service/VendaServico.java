package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.repository.VendaRepository;

@Service
public class VendaServico {
    @Autowired
    VendaRepository vendaRepository;

    public Venda criarVenda(Venda venda){
        System.out.println("VendaServico :: criarVenda :: Venda "+ venda.getIdentificador());
        try{
            Venda vendaCriada = vendaRepository.save(venda);
            return vendaCriada;
        }catch (Exception err){
            System.out.println("VendaServico :: criarVenda :: Erro ao criar venda");
            return null;
        }
    }
}

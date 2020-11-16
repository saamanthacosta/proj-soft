package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Reclamacao;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;
@Service
public class ReclamacaoServico {
    @Autowired
    ReclamacaoRepository reclamacaoRepository;

    public void realizarReclamacao(String cpf, String reclamacao){
        Reclamacao novo = new Reclamacao(cpf, reclamacao);
        reclamacaoRepository.save(novo);
    }

}

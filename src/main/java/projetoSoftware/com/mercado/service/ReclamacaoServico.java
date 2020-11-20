package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Reclamacao;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;
@Service
public class ReclamacaoServico {
    @Autowired
    ReclamacaoRepository reclamacaoRepository ;

    public void realizarReclamacao(String cpf, String reclamacao){
        Reclamacao novo = new Reclamacao(cpf, reclamacao);
        this.save(novo);
    }
    public Reclamacao save(Reclamacao reclamacao){
        try{
            Reclamacao reclamacaoSalva = reclamacaoRepository.save(reclamacao);
            System.out.println("Reclamacao :: save :: reclamação salva");
            return reclamacaoSalva;
        }catch(Exception err){
            System.out.println("Reclamacao :: save :: Erro ao salvar reclamação :" + err.toString());
            return null;
        }
    }
}

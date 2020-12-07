package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.Assunto;
import projetoSoftware.com.mercado.modelo.Reclamacao;
import projetoSoftware.com.mercado.repositorio.ReclamacaoRepositorio;

@Service
public class ReclamacaoServico {
    @Autowired
    ReclamacaoRepositorio reclamacaoRepositorio;

    public void realizar(String cpf, String reclamacao, Assunto assunto) {
        Reclamacao novo = new Reclamacao(cpf, reclamacao, assunto);
        this.salvar(novo);
    }

    public Reclamacao salvar(Reclamacao reclamacao) {
        try {
            Reclamacao reclamacaoSalva = reclamacaoRepositorio.save(reclamacao);
            System.out.println("Reclamacao :: save :: reclamação salva");
            return reclamacaoSalva;
        } catch (Exception err) {
            System.out.println("Reclamacao :: save :: Erro ao salvar reclamação :" + err.toString());
            return null;
        }
    }
}

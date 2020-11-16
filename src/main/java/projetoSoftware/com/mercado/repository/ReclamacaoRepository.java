package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Reclamacao;

public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {
    Reclamacao save(Reclamacao reclamacao);
}

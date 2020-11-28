package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Reclamacao;

public interface ReclamacaoRepositorio extends JpaRepository<Reclamacao, Integer> {
    Reclamacao save(Reclamacao reclamacao);
}

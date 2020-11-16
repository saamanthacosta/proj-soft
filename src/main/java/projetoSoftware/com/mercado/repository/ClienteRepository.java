package projetoSoftware.com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Cliente save(Cliente cliente);
    Cliente findByCpf(String cpf);
}

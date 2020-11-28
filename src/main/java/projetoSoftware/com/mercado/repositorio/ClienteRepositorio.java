package projetoSoftware.com.mercado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoSoftware.com.mercado.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
    Cliente save(Cliente cliente);

    Cliente findByCpf(String cpf);
}

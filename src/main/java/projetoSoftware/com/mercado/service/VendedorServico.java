package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.enumerado.statusVenda;
import projetoSoftware.com.mercado.model.Cliente;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.model.Vendedor;
import projetoSoftware.com.mercado.repository.VendedorRepository;


@Service
public class VendedorServico {

    @Autowired
    VendedorRepository vendedorRepository;
    @Autowired
    ClienteServico clienteServico;
    @Autowired
    VendaServico vendaServico;


    public boolean login(String usuario, String senha) {
        try {
            Vendedor vendedor = vendedorRepository.findByUsuario(usuario);
            return vendedor != null && senha.equals(vendedor.getSenha());
        } catch (Exception err) {
            return false;
        }
    }

    public Venda iniciarVenda(String cliente_cpf, String vendedor_id) {
        Cliente cliente = clienteServico.confirmarIdentificacao(cliente_cpf);

        if (cliente != null) {
            return vendaServico.criarVenda(Venda.builder().cliente(cliente_cpf).vendedor(vendedor_id).status(statusVenda.EM_ANDAMENTO).build());
        }
        return null;
    }
}

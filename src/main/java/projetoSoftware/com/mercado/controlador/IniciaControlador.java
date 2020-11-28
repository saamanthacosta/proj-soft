package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoSoftware.com.mercado.modelo.Cliente;
import projetoSoftware.com.mercado.modelo.Produto;
import projetoSoftware.com.mercado.modelo.Usuario;
import projetoSoftware.com.mercado.servico.ClienteServico;
import projetoSoftware.com.mercado.servico.GerenteServico;
import projetoSoftware.com.mercado.servico.ProdutoService;
import projetoSoftware.com.mercado.servico.VendedorServico;

import java.util.ArrayList;

@RestController
public class IniciaControlador {

    @Autowired
    ProdutoService produtoServico;

    @Autowired
    GerenteServico gerenteServico;

    @Autowired
    VendedorServico vendedorServico;

    @Autowired
    ClienteServico clienteServico;

    @GetMapping("/iniciar/padrao")
    public ResponseEntity<?> iniciarSistemaComValores() {
        ArrayList<Produto> produtos = new ArrayList();
        produtos.add(new Produto(1, "Nescau", new Float(10), "Guanabara"));
        produtos.add(new Produto(2, "Leite", new Float(4), "Guanabara"));
        produtos.add(new Produto(3, "Arroz", new Float(3), "Guanabara"));
        produtos.add(new Produto(4, "feijão", new Float(2), "Guanabara"));
        for (Produto produto : produtos) {
            produtoServico.createProdutoComQuantidade(produto, 40);
        }
        Usuario gerente = Usuario.builder().cargo("GERENTE").nome("Paulo Machado").usuario("gerente").senha("password").build();
        Usuario gerenteExiste = gerenteServico.autentica(gerente.getUsuario(), gerente.getSenha());
        if (gerenteExiste == null) {
            gerenteServico.criarGerente(gerente);
        }
        Usuario vendedor = Usuario.builder().cargo("GERENTE").nome("Lucas Almeida").usuario("vendedor").senha("password").build();
        Usuario vendedorExiste = vendedorServico.login(vendedor.getUsuario(), vendedor.getSenha());
        if (vendedorExiste == null) {
            gerenteServico.criarGerente(gerente);
        }
        Cliente cliente = Cliente.builder().cpf("98765432100").email("cliente@email.com").identidade("112223331").ehPreferencial(true).pontosAcumulados(100).build();
        Cliente cliente2 = Cliente.builder().cpf("98765432101").email("cliente2@email.com").identidade("112223331").ehPreferencial(false).pontosAcumulados(100).build();

        Cliente cliente1 = clienteServico.confirmarIdentificacao(cliente.getCpf());
        Cliente cliente21 = clienteServico.confirmarIdentificacao(cliente2.getCpf());
        if (cliente1 == null) {
            clienteServico.cadastrarCliente(cliente);
        }
        if (cliente2 == null) {
            clienteServico.cadastrarCliente(cliente2);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}

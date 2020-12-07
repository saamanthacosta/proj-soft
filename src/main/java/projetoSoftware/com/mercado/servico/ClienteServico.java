package projetoSoftware.com.mercado.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.modelo.Cliente;
import projetoSoftware.com.mercado.repositorio.ClienteRepositorio;

import java.util.Date;

@Service
public class ClienteServico {

    @Autowired
    ClienteRepositorio clienteRepositorio;

//    ReclamacaoServico reclamacaoServico = new ReclamacaoServico();

    public Cliente cadastrar(Cliente cliente) {
        try {
            cliente.setDataCadastro(new Date());
            Cliente novo = clienteRepositorio.save(cliente);
            return novo;

        } catch (Exception err) {
            System.out.println("ClienteServico");
            return null;
        }
    }

    public Cliente confirmarIdentificacao(String cpf) {
        try {
            Cliente clienteEncontrado = clienteRepositorio.findByCpf(cpf);
            System.out.println("ClienteServico :: confirmarIdentificação :: Cliente encontrado: " + clienteEncontrado.getIdentidade());
            return clienteEncontrado;
        } catch (Exception err) {
            System.out.println("ClienteServico :: confirmarIdentificação :: Deu erro na busca do banco, erro: " + err.toString());
            return null;
        }
    }

    public Cliente adicionarPontos(String cpf, int pontos) {
        try {
            Cliente cliente = this.confirmarIdentificacao(cpf);
            cliente.adicionarPontos(pontos);
            Cliente novo = clienteRepositorio.save(cliente);
            System.out.println("ClienteServico :: adicionarPontos :: pontos adicionados no usuário " + novo.getCpf());
            return novo;

        } catch (Exception err) {
            System.out.println("ClienteServico :: adicionarPontos :: Deu erro : " + err.toString());
            return null;
        }
    }

    public boolean trocarPontos(String cpf, int pontos) {
        try {
            Cliente cliente = this.confirmarIdentificacao(cpf);
            if (cliente.adicionarPontos(pontos)) {
                cliente.adicionarPontos(-pontos);
                Cliente novo = clienteRepositorio.save(cliente);
                System.out.println("ClienteServiço :: trocarPontos :: Pontos trocados no usuário : " + novo.getCpf());
                return true;
            } else {
                System.out.println("ClienteServiço :: trocarPontos :: Pontos insuficientes no usuário: " + cliente.getCpf());
                return false;
            }

        } catch (Exception err) {
            System.out.println("ClienteServiço :: trocarPontos :: Deu erro : " + err.toString());
            return false;
        }
    }

}

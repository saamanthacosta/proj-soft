package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Cliente;
import projetoSoftware.com.mercado.model.Reclamacao;
import projetoSoftware.com.mercado.repository.ClienteRepository;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;

import java.util.Date;

@Service
public class ClienteServico {

    @Autowired
    ClienteRepository clienteRepository;

//    ReclamacaoServico reclamacaoServico = new ReclamacaoServico();

    public Cliente cadastrarCliente(Cliente cliente){
        try {
            cliente.setDataCadastro(new Date());
            Cliente novo = clienteRepository.save(cliente);
            return novo;

        }catch (Exception err){
            System.out.println("ClienteServico");
            return null;
        }
    }
    public Cliente confirmarIdentificacao(String cpf){
        try{
        Cliente clienteEncontrado = clienteRepository.findByCpf(cpf);
        System.out.println("ClienteServico :: confirmarIdentificação :: Cliente encontrado: "+clienteEncontrado.getIdentidade());
        return clienteEncontrado;
        }catch(Exception err){
            System.out.println("ClienteServico :: confirmarIdentificação :: Deu erro na busca do banco, erro: "+err.toString());
            return null;
        }
    }
    public Cliente adicionarPontos(String cpf, int pontos){
        try {
        Cliente cliente = this.confirmarIdentificacao(cpf);
        cliente.adicionarPontos(pontos);
        Cliente novo = clienteRepository.save(cliente);
        System.out.println("ClienteServico :: adicionarPontos :: pontos adicionados no usuário "+novo.getCpf());
        return novo;

        }catch (Exception err){
            System.out.println("ClienteServico :: adicionarPontos :: Deu erro : "+err.toString());
            return null;
        }
    }
    public boolean trocarPontos(String cpf, int pontos){
        try {
            Cliente cliente = this.confirmarIdentificacao(cpf);
            if(cliente.adicionarPontos(pontos)){
                cliente.adicionarPontos(-pontos);
                Cliente novo = clienteRepository.save(cliente);
                System.out.println("ClienteServiço :: trocarPontos :: Pontos trocados no usuário : "+novo.getCpf());
                return true;
            }else{
                System.out.println("ClienteServiço :: trocarPontos :: Pontos insuficientes no usuário: "+cliente.getCpf());
                return false;
            }

        }catch (Exception err){
            System.out.println("ClienteServiço :: trocarPontos :: Deu erro : "+err.toString());
            return false;
        }
    }
//    public void registraReclamacao(String cpf, String reclamacaoTxt){
//        Cliente cliente = this.confirmarIdentificacao(cpf);
//        reclamacaoServico.realizarReclamacao(cliente.getCpf(), reclamacaoTxt);
//    }

}

package projetoSoftware.com.mercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoSoftware.com.mercado.model.Cliente;
import projetoSoftware.com.mercado.repository.ClienteRepository;

import java.util.Date;

@Service
public class ClienteServico {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        cliente.setDataCadastro(new Date());
        Cliente novo = clienteRepository.save(cliente);
        return novo;
    }
    public Cliente confirmarIdentificacao(String cpf){
        try{
        Cliente clienteEncontrado = clienteRepository.findByCpf(cpf);
        return clienteEncontrado;
        }catch(Exception err){
            System.out.println("ClienteServiço :: confirmarIdentificação :: Deu erro na busca do banco, erro: "+err.toString());
            return null;
        }
    }
    public Cliente adicionarPontos(String cpf, int pontos){
        try {
        Cliente cliente = this.confirmarIdentificacao(cpf);
        cliente.adicionarPontos(pontos);
        Cliente novo = clienteRepository.save(cliente);
        return novo;

        }catch (Exception err){
            System.out.println("ClienteServiço :: adicionarPontos :: Deu erro : "+err.toString());
            return null;
        }
    }
    public boolean trocarPontos(String cpf, int pontos){
        try {
            Cliente cliente = this.confirmarIdentificacao(cpf);
            if(cliente.adicionarPontos(pontos)){
                cliente.adicionarPontos(-pontos);
                Cliente novo = clienteRepository.save(cliente);
                return true;
            }else{
                return false;
            }

        }catch (Exception err){
            System.out.println("ClienteServiço :: trocarPontos :: Deu erro : "+err.toString());
            return false;
        }
    }

}

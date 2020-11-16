package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Cliente;
import projetoSoftware.com.mercado.service.ClienteServico;

@RestController
public class ClienteController {
    @Autowired
    ClienteServico clienteServico;
    @PostMapping("/cliente/cadastro")
    public ResponseEntity cadastrarCliente(@RequestBody Cliente cliente){
        System.out.println("ClienteControlador :: cadastrarCliente :: Entrou cliente" + cliente.toString());
        Cliente clienteGerado = clienteServico.cadastrarCliente(cliente);
        return new ResponseEntity<Cliente>(clienteGerado, HttpStatus.OK);
    }
    @GetMapping("/cliente/identificar")
    public ResponseEntity identificarCliente(@RequestParam String cpf){
        Cliente cliente = clienteServico.confirmarIdentificacao(cpf);
        if (cliente != null){
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/cliente/adicionarPontos")
    public ResponseEntity<Cliente> adicionarPontos(@RequestParam String cpf, @RequestParam String pontos){
        System.out.println("ClienteControlador :: reclamacaoCliente :: Entrou cliente" );
        Cliente cliente = clienteServico.adicionarPontos(cpf, Integer.parseInt(pontos));
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }
    @PostMapping("/cliente/trocarPontos")
    public ResponseEntity<String> trocarPontos(@RequestParam String cpf, @RequestParam String pontos){
        System.out.println("ClienteControlador :: reclamacaoCliente :: Entrou cliente" );
        boolean resposta = clienteServico.trocarPontos(cpf, Integer.parseInt(pontos));
        if (resposta){
            return new ResponseEntity<String>("Pontos trocados com sucesso",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Erro ao trocar os pontos. Verifique se tem pontos suficientes",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/cliente/reclamacao")
    public void reclamacaoCliente(@RequestBody String reclamacao, @RequestHeader String cpf){
        System.out.println("ClienteControlador :: reclamacaoCliente :: Entrou cliente" );
        clienteServico.registraReclamacao(cpf, reclamacao);
    }
}

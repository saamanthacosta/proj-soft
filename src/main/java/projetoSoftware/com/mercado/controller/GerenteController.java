package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Gerente;
import projetoSoftware.com.mercado.model.Vendedor;
import projetoSoftware.com.mercado.service.VendedorServico;

import javax.validation.constraints.Null;

@RequestMapping("/gerente")
@RestController
public class GerenteController {


    @PostMapping("/iniciaSis")
    public ResponseEntity<?> iniciarSistema() {
        System.out.println("GerenteController :: iniciarSistema :: Iniciando sistema ");
        return new ResponseEntity<String>("Sistema iniciado com sucesso!", HttpStatus.OK);

    }

    @GetMapping("/alteraProduto")
    public ResponseEntity<?> alteraProduto(@RequestBody Produto produto) {
        System.out.println("GerenteController :: alteraProduto :: tentando alterar produto ");
        return new ResponseEntity<Null>(HttpStatus.NO_CONTENT);

    }

}

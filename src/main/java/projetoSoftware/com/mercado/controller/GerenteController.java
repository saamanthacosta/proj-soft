package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.enumerado.cargoEnum;
import projetoSoftware.com.mercado.model.Gerente;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.service.GerenteServico;


@RequestMapping("/gerente")
@RestController
public class GerenteController {

    @Autowired
    GerenteServico gerenteServico;

    @PostMapping("/iniciaSistema")
    public ResponseEntity<?> iniciarSistema(@RequestBody Gerente gerente) {
        System.out.println("GerenteController :: iniciarSistema :: Iniciando sistema ");
        Usuario gerenteAuth = gerenteServico.autentica(gerente.getUsuario(), gerente.getSenha());
        if (gerenteAuth != null) {
            gerenteAuth.setSenha("");
            return new ResponseEntity<Usuario>(gerenteAuth, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Não foi possivel autenticar gerente!", HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/alteraProduto")
    public ResponseEntity<?> alteraProduto(@RequestBody Produto produto) {
        System.out.println("GerenteController :: alteraProduto :: tentando alterar produto ");

        return new ResponseEntity<String>("Altera produto", HttpStatus.NO_CONTENT);
    }

}

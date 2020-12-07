package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.modelo.Gerente;
import projetoSoftware.com.mercado.modelo.Produto;
import projetoSoftware.com.mercado.modelo.Usuario;
import projetoSoftware.com.mercado.servico.GerenteServico;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gerente")
@RestController
public class GerenteControlador {

    @Autowired
    GerenteServico gerenteServico;

    @PostMapping("/iniciaSistema")
    public ResponseEntity<?> login(@RequestBody Gerente gerente) {
        System.out.println("GerenteControlador :: iniciarSistema :: Iniciando sistema ");
        Usuario gerenteAuth = gerenteServico.autentica(gerente.getUsuario(), gerente.getSenha());
        if (gerenteAuth != null) {
            gerenteAuth.setSenha("");
            return new ResponseEntity<Usuario>(gerenteAuth, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Não foi possivel autenticar gerente!", HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/alteraProduto")
    public ResponseEntity<?> alteraProduto(@RequestBody Produto produto) {
        System.out.println("GerenteControlador :: alteraProduto :: tentando alterar produto ");

        return new ResponseEntity<String>("Altera produto", HttpStatus.NO_CONTENT);
    }

}

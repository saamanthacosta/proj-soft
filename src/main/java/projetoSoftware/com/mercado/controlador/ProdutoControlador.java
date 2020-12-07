package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.modelo.Produto;
import projetoSoftware.com.mercado.servico.ProdutoService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/produto")
public class ProdutoControlador {
    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
        List<Produto> produtos = produtoService.listar();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @RequestMapping(path = "/get_one/{identificador}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarPorIdentificador(
            @PathVariable int identificador
    ) {
        Produto produto = produtoService.consultarPorIdentificador(identificador);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> criar(
            @RequestBody Produto newProduto
    ) {
        produtoService.criar(newProduto);
        return new ResponseEntity<>("{\"Mensagem\": \"Criado.\"}", HttpStatus.CREATED);
    }

    @PostMapping(path = "/atualizar/{identificador}")
    public ResponseEntity<?> atualizar(
            @RequestBody Produto produto, @PathVariable Integer identificador
    ) {
        Produto produtoBuscado = produtoService.consultarPorIdentificador(identificador);
        produtoBuscado.atualizar(produto);
        produtoService.criar(produtoBuscado);
        return new ResponseEntity<>("{\"Mensagem\": \"Atualizado.\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/remover/{identificador}")
    public ResponseEntity<?> remover(
            @RequestBody Produto produto, @PathVariable Integer identificador
    ) {
        Produto produtoBuscado = produtoService.consultarPorIdentificador(identificador);
        produtoService.remover(produtoBuscado);
        return new ResponseEntity<>("{\"Mensagem\": \"Deletado.\"}", HttpStatus.OK);
    }

}

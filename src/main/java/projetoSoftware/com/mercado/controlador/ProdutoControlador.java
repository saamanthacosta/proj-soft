package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.modelo.Produto;
import projetoSoftware.com.mercado.servico.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoControlador {
    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> listProdutos() {
        List<Produto> produtos = produtoService.listProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @RequestMapping(path = "/get_one/{identificador}", method = RequestMethod.GET)
    public ResponseEntity<?> getProdutoById(
            @PathVariable int identificador
    ) {
        Produto produto = produtoService.getProdutoById(identificador);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createProduto(
            @RequestBody Produto newProduto
    ) {
        produtoService.createProduto(newProduto);
        return new ResponseEntity<>("{\"Mensagem\": \"Criado.\"}", HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/{identificador}")
    public ResponseEntity<?> updateProduto(
            @RequestBody Produto produto, @PathVariable Integer identificador
    ) {
        Produto produtoBuscado = produtoService.getProdutoById(identificador);
        produtoBuscado.atualizar(produto);
        produtoService.createProduto(produtoBuscado);
        return new ResponseEntity<>("{\"Mensagem\": \"Atualizado.\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/delete/{identificador}")
    public ResponseEntity<?> deleteProduto(
            @RequestBody Produto produto, @PathVariable Integer identificador
    ) {
        Produto produtoBuscado = produtoService.getProdutoById(identificador);
        produtoService.deleteProduto(produtoBuscado);
        return new ResponseEntity<>("{\"Mensagem\": \"Deletado.\"}", HttpStatus.OK);
    }

}

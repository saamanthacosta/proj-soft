package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> listProdutos(){
        List<Produto> produtos = produtoService.listProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @RequestMapping(path = "/get_one/{identificador}", method = RequestMethod.GET)
    public ResponseEntity<?> getProdutoById(
            @PathVariable int identificador
    ){
        Produto produto = produtoService.getProdutoById(identificador);
        return new ResponseEntity<>(produto,HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createProduto(
            @RequestBody Produto newProduto
    ){
        produtoService.createProduto(newProduto);
        return new ResponseEntity<>("{\"Message\": \"Created.\"}", HttpStatus.CREATED);
    }

}

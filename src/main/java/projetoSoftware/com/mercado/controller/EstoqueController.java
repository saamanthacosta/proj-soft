package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Estoque;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    EstoqueService estoqueService;

    @RequestMapping(path = "/get_one/{identificador}", method = RequestMethod.GET)
    public ResponseEntity<?> getProdutoById(
            @PathVariable int identificador
    ) {
        Estoque estoque = estoqueService.getByProdutoId(identificador);
        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }

    @PostMapping(path = "/addEstoque")
    public ResponseEntity<?> addEstoque(@RequestParam int codigoDeBarrasProduto, @RequestParam int qtdAdd) {
        Estoque produtoAdicionado = estoqueService.addEstoque(codigoDeBarrasProduto, qtdAdd);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque add.\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/retiraEstoque")
    public ResponseEntity<?> retiraEstoque(@RequestParam int codigoDeBarrasProduto, @RequestParam int qtdRetira) {
        Estoque produtoRetirado = estoqueService.retiraEstoque(codigoDeBarrasProduto, qtdRetira);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque retira.\"}", HttpStatus.OK);
    }
}

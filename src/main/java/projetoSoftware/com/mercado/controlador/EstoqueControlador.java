package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.modelo.Estoque;
import projetoSoftware.com.mercado.servico.EstoqueService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/estoque")
public class EstoqueControlador {
    @Autowired
    EstoqueService estoqueServico;

    @RequestMapping(path = "/consulta/{identificador}", method = RequestMethod.GET)
    public ResponseEntity<?> getProdutoById(
            @PathVariable int identificador
    ) {
        Estoque estoque = estoqueServico.getByProdutoId(identificador);
        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }

    @PostMapping(path = "/adcEstoque")
    public ResponseEntity<?> adcEstoque(@RequestParam int codigoDeBarrasProduto, @RequestParam int qtdAdc) {
        Estoque produtoAdicionado = estoqueServico.adcEstoque(codigoDeBarrasProduto, qtdAdc);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque add.\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/retiraEstoque")
    public ResponseEntity<?> retiraEstoque(@RequestParam int codigoDeBarrasProduto, @RequestParam int qtdRetira) {
        Estoque produtoRetirado = estoqueServico.retiraEstoque(codigoDeBarrasProduto, qtdRetira);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque retira.\"}", HttpStatus.OK);
    }
}

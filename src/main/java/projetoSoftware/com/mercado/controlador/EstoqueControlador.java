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
    public ResponseEntity<?> consultarPorIdentificador(
            @PathVariable int identificador
    ) {
        Estoque estoque = estoqueServico.consultarPeloIdentificador(identificador);
        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }

    @PostMapping(path = "/adicionar")
    public ResponseEntity<?> adicionar(@RequestParam int codigoDeBarrasProduto, @RequestParam int quantidade) {
        Estoque produtoAdicionado = estoqueServico.adicionar(codigoDeBarrasProduto, quantidade);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque add.\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/retirar")
    public ResponseEntity<?> retirar(@RequestParam int codigoDeBarrasProduto, @RequestParam int quantidade) {
        Estoque produtoRetirado = estoqueServico.retirar(codigoDeBarrasProduto, quantidade);
        return new ResponseEntity<>("{\"Mensagem\": \"Estoque retira.\"}", HttpStatus.OK);
    }
}

package projetoSoftware.com.mercado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.modelo.Estoque;
import projetoSoftware.com.mercado.modelo.Venda;
import projetoSoftware.com.mercado.servico.VendaServico;

import java.util.ArrayList;

@RestController
@RequestMapping("/venda")
public class VendaControlador {

    @Autowired
    VendaServico vendaServico;

    @PostMapping(path = "/registrar")
    public ResponseEntity<?> registrar(@RequestBody ArrayList<Estoque> produtos, @RequestParam String vendedor, @RequestParam String cliente, @RequestParam String formapagamento) {
        try {
            Venda venda = vendaServico.criar(cliente, vendedor, produtos, formapagamento);
            return new ResponseEntity<Venda>(venda, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

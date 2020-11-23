package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Estoque;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.service.VendaServico;

import java.util.ArrayList;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaServico vendaServico;

    @PostMapping(path = "/registrar")
    public ResponseEntity<?> registrarVenda(@RequestBody ArrayList<Estoque> produtos, @RequestParam String vendedor, @RequestParam String cliente, @RequestParam String formapagamento) {
    try{
        Venda venda = vendaServico.criarVenda(cliente, vendedor,produtos,formapagamento);
        return new ResponseEntity<Venda>(venda, HttpStatus.OK);
    }catch (Exception err){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }
}

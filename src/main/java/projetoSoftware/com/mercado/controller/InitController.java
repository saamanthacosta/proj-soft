package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoSoftware.com.mercado.model.Produto;
import projetoSoftware.com.mercado.service.ProdutoService;

import java.util.ArrayList;

@RestController
public class InitController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/iniciar/padrao")
    public ResponseEntity<?> iniciarSistemaComValores(){
        ArrayList<Produto> produtos = new ArrayList();
        produtos.add(new Produto(1,"Nescau",new Float(10), "Guanabara"));
        produtos.add(new Produto (2,"Leite",new Float(4), "Guanabara"));
        produtos.add(new Produto(3,"Arroz",new Float(3), "Guanabara"));
        produtos.add(new Produto(4,"feijão",new Float(2), "Guanabara"));
		for (Produto produto : produtos) {
			produtoService.createProduto(produto);
		}
        System.out.println(produtos.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}

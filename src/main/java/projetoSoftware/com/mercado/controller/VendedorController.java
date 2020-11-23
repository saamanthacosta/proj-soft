package projetoSoftware.com.mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Usuario;
import projetoSoftware.com.mercado.model.Venda;
import projetoSoftware.com.mercado.model.Vendedor;
import projetoSoftware.com.mercado.service.VendedorServico;

@RequestMapping("/vendedor")
@RestController
public class VendedorController {

    @Autowired
    VendedorServico vendedorServico;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Vendedor vendedor) {
        System.out.println("VendedorController :: login :: Tentando autenticar vendedor ");
        Usuario vendedorAuth = vendedorServico.login(vendedor.getUsuario(), vendedor.getSenha());
        vendedor.setSenha("");
        if (vendedorAuth != null) {
            return new ResponseEntity<Usuario>(vendedorAuth, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Não foi possivel autenticar vendedor", HttpStatus.UNAUTHORIZED);

    }

    @PostMapping("/iniciaVenda")
    public ResponseEntity<?> iniciarVenda(@RequestParam String cliente, @RequestParam String vendedor) {
        System.out.println("VendedorController :: iniciarVenda :: Iniciando venda");

        Venda venda = vendedorServico.iniciarVenda(cliente, vendedor);
        if (venda != null) {
            return new ResponseEntity<Venda>(vendedorServico.iniciarVenda(cliente, vendedor), HttpStatus.OK);
        }
        return new ResponseEntity<Venda>(HttpStatus.METHOD_NOT_ALLOWED);
    }

}

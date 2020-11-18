package projetoSoftware.com.mercado.controller;

import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoSoftware.com.mercado.model.Vendedor;
import projetoSoftware.com.mercado.service.VendedorServico;

@RequestMapping("/vendedor")
@RestController
public class VendedorController {

    @Autowired
    VendedorServico vendedorServico;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Vendedor vendedor) {
        System.out.println("VendedorController :: login :: Tentando autenticar vendedor " + vendedor.getLogin());
        boolean auth = vendedorServico.autentica(vendedor);
        if(auth)
            return new ResponseEntity<Vendedor>(vendedor, HttpStatus.ACCEPTED);
        return new ResponseEntity<Vendedor>(vendedor, HttpStatus.UNAUTHORIZED);

    }

}

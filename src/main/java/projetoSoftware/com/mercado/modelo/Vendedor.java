package projetoSoftware.com.mercado.modelo;

import projetoSoftware.com.mercado.enumerado.cargoEnum;

public class Vendedor extends Usuario{

    public Vendedor(){
        this.setCargo(cargoEnum.VENDEDOR);
    }

}
package projetoSoftware.com.mercado.model;

import projetoSoftware.com.mercado.enumerado.cargoEnum;

public class Gerente extends Usuario {

    public Gerente(){
        this.setCargo(cargoEnum.GERENTE);
    }


}
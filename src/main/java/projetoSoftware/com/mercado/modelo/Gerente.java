package projetoSoftware.com.mercado.modelo;

import projetoSoftware.com.mercado.enumerado.cargoEnum;

public class Gerente extends Usuario {

    public Gerente() {
        this.setCargo(cargoEnum.GERENTE);
    }
}
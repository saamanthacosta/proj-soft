export default class Venda {

    constructor(vendedor, cliente, produtos, formaDePagamento) {
        this._vendedor = vendedor;
        this._cliente = cliente;
        this._produtos = produtos;
        this._formaDePagamento = formaDePagamento
    }

    get vendedor() {
        return this._vendedor;
    };

    set vendedor(vendedor) {
        return this._vendedor = vendedor;
    }

    get cliente() {
        return this._cliente;
    }

    set cliente(cliente) {
        return this._cliente = cliente;
    }

    get produtos() {
        return this._produtos;
    };

    set produtos(produtos) {
        return this._produtos = produtos;
    }

    get cliente() {
        return this._formaDePagamento;
    }

    set cliente(formaDePagamento) {
        return this._formaDePagamento = formaDePagamento;
    }
    
}
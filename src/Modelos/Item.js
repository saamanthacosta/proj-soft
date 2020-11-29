export default class Item {

    constructor(produto, quantidade) {
        this._produto = produto;
        this._quantidade = quantidade;
    }

    get produto() {
        return this._produto;
    }

    set produto(produto) {
        this._produto = produto;
    }

    get quantidade() {
        return this._quantidade;
    }

    set quantidade(quantidade) {
        this._quantidade = quantidade;
    }
}
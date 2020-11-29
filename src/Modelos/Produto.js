export default class Produto {

    constructor(codigoDeBarras, nome, preco, quantidade) {
        this._codigoDeBarras = codigoDeBarras;
        this._nome = nome;
        this._preco = preco;
        this._quantidade = quantidade;
        this._valorTotal = this._quantidade * this._preco
    }

    get codigoDeBarras() {
        return this._codigoDeBarras;
    };

    set codigoDeBarras(codigoDeBarras) {
        return this._codigoDeBarras = codigoDeBarras;
    }

    get nome() {
        return this._nome;
    }

    set nome(nome) {
        return this._nome = nome;
    }

    get preco() {
        return this._preco;
    }

    set preco(preco) {
        return this._preco = preco;
    }

    get quantidade() {
        return this._quantidade;
    }

    set quantidade(quantidade) {
        return this._quantidade = quantidade;
    }

    get valorTotal() {
        return this._valorTotal;
    }

    set valorTotal(valorTotal) {
        return this._valorTotal = valorTotal;
    }

    // valorTotal = () => {
    //     return this._quantidade * this._preco
    // }
    
}
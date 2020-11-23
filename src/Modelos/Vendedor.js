import Usuario from "./Usuario";

export default class Vendedor extends Usuario{

    constructor(nome) {
        this._nome = nome;
    }

    get nome() {
        return this._nome;
    };

    set nome(nome) {
        return this._nome = nome;
    }
    
}
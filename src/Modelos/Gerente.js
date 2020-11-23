export default class Gerente {

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
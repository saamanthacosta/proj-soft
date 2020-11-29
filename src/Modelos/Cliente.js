export default class Cliente {

    constructor(cpf, nome, preferencial) {
        this._cpf = cpf;
        this._nome = nome;
        this._preferencial = preferencial;
    }

    get cpf() {
        return this._cpf;
    };

    set cpf(cpf) {
        return this._cpf = cpf;
    }

    get nome() {
        return this._nome;
    }

    set nome(nome) {
        return this._nome = nome;
    }
    
    get preferencial() {
        return this._preferencial;
    }

    set preferencial(preferencial) {
        return this._preferencial = preferencial;
    }

}
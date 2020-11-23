export default class Usuario {

    constructor(usuario, senha) {
        this._usuario = usuario;
        this._senha = senha;
    }

    get usuario() {
        return this._usuario;
    };

    set usuario(usuario) {
        return this._usuario = usuario;
    }

    get senha() {
        return this._senha;
    }

    set senha(senha) {
        return this._senha = senha;
    }
    
}
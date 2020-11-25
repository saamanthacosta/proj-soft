import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class GerenteStore extends EventEmitter { 


    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    erro = {
        mensagem: ''
    }

    gerenteLogado = false;

    dispatcherCallBack(action) {
        switch (action.actionType) {
            case 'LOGIN_GERENTE':
                this.gerenteLogado = true;
                this.emit('LOGIN');
                break;
            case 'LOGIN_GERENTE_ERRO':
                this.erro.mensagem = action.value.mensagem;
                this.emit('ERRO');
                break;
            default: break;
        };
    };
}

export default new GerenteStore();
import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class ClienteStore extends EventEmitter { 


    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    erro = {
        mensagem: ''
    }

    cliente = null;

    dispatcherCallBack(action) {
        switch (action.actionType) {
            case 'CPF_EXISTE':
                this.cliente = true;
                this.emit('CHANGE');
                break;
            case 'CPF_ERRO':
                this.erro.mensagem = action.value.mensagem;
                this.emit('CHANGE');
                break;
            default: break;
        };
    };
}

export default new ClienteStore();
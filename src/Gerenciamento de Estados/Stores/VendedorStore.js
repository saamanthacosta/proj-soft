import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class VendedorStore extends EventEmitter { 


    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    erro = {
        mensagem: ''
    }

    vendedorLogado = false;

    dispatcherCallBack(action) {
        switch (action.actionType) {
            case 'LOGIN_VENDEDOR_ERRO':
                this.vendedorLogado = true;
                this.emit('CHANGE');
                break;
            case 'LOGIN_VENDEDOR_ERRO':
                this.erro.mensagem = action.value.mensagem;
                this.emit('CHANGE');
                break;
            default: break;
        };
    };
}

export default new VendedorStore();
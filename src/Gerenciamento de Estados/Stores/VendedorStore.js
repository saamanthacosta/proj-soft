import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class VendedorStore extends EventEmitter { 


    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    erro = null

    vendedorLogado = false;

    dispatcherCallBack(action) {
        switch (action.actionType) {
            case 'LOGIN_VENDEDOR_ERRO':
                this.vendedorLogado = true;
                this.emit('LOGIN');
                break;
            case 'LOGIN_VENDEDOR_ERRO':
                this.erro = action.value;
                this.emit('ERRO');
                break;
            default: break;
        };
    };
}

export default new VendedorStore();
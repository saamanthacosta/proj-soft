import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class VendaStore extends EventEmitter { 


    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    dispatcherCallBack(action) {
        switch (action.actionType) {
                case 'VENDA_CRIADA':
                    this.emit('CHANGE');
                    break;
            default: break;
        };
    };
}

export default new VendaStore();
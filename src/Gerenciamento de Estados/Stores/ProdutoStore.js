import Dispatcher from '../Dispatcher/Dispatcher'
import { EventEmitter } from 'events';

class ProdutoStore extends EventEmitter { 

    constructor() {
        super();
        this.dispatchToken = Dispatcher.register(this.dispatcherCallBack.bind(this));
    };

    erro = {
        mensagem: ''
    }

    
    criarData = (nome, valorUnitario, quantidade) => {
        var valorTotal = valorUnitario * quantidade;
        return { nome, valorUnitario, quantidade, valorTotal };
    }

    produto = null;

    dispatcherCallBack(action) {
        switch (action.actionType) {
            case 'DISPONIBILIDADE':
                this.produto = this.criarData("AAAAAAAAAA", 30.5, 3);
                this.emit('DISPONIBILIDADE');
                break;
            case 'DISPONIBILIDADE_ERRO':
                this.erro.mensagem = action.value.mensagem;
                this.emit('CHANGE');
                break;
            default: break;
        };
    };
}

export default new ProdutoStore();
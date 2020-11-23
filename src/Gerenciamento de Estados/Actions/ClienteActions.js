import Dispatcher from '../Dispatcher/Dispatcher'
import ServicoDeCliente from '../../Servicos/ServicoDeCliente';

class ClienteActions {

    verificarCPF(cpf) {
        ServicoDeCliente.verificarCPF(cpf).then(
            resp => {
                Dispatcher.dispatch({
                    actionType: 'CPF_EXISTE',
                    value: resp.value
                });
            },
            erro => {
                Dispatcher.dispatch({
                    actionType: 'CPF_ERRO',
                    value:  {
                        status:  'ERRO',
                        mensagem: erro.response.data
                    }
                });
            }
        )
    }
}

export default new ClienteActions();
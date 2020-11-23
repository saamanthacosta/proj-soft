import Dispatcher from '../Dispatcher/Dispatcher'
import ServicoDeVendedor from '../../Servicos/ServicoDeVendedor';

class VendedorActions {

    login(usuario) {
        ServicoDeVendedor.autenticar(usuario).then(
            resp => {
                Dispatcher.dispatch({
                    actionType: 'LOGIN',
                    value: resp.value
                });
            },
            erro => {
                Dispatcher.dispatch({
                    actionType: 'LOGIN_ERRO',
                    value:  {
                        status:  'ERRO',
                        mensagem: erro.response.data
                    }
                });
            }
        )
    }
}

export default new VendedorActions();
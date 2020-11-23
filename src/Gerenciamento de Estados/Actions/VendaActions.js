import Dispatcher from '../Dispatcher/Dispatcher'
import ServicoDeVenda from '../../Servicos/ServicoDeVenda'
;
class VendaActions {

    cadastrar(venda) {
        ServicoDeVenda.cadastrar(venda).then(
            resp => {
                Dispatcher.dispatch({
                    actionType: 'VENDA_CRIADA',
                    value: resp.value
                });
            },
            erro => {
                Dispatcher.dispatch({
                    actionType: 'ERRO_VENDA',
                    value:  {
                        status:  'ERRO',
                        mensagem: erro.response.data
                    }
                });
            }
        )
    }
}

export default new VendaActions();
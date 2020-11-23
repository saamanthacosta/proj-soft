import Dispatcher from '../Dispatcher/Dispatcher'
import ServicoDeProduto from '../../Servicos/ServicoDeProduto';

class ProdutoActions {

    verificarDisponibilidade(codigoDeBarras, quantidade) {
        ServicoDeProduto.verificarDisponibilidade(codigoDeBarras, quantidade).then(
            resp => {
                Dispatcher.dispatch({
                    actionType: 'DISPONIBILIDADE',
                    value: resp.value
                });
            },
            erro => {
                Dispatcher.dispatch({
                    actionType: 'DISPONIBILIDADE_ERRO',
                    value:  {
                        status:  'ERRO',
                        mensagem: erro.response.data
                    }
                });
            }
        )
    }
}

export default new ProdutoActions();
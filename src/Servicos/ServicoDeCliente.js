import Request, { API } from './Request';
import { ROTAS } from '../Config/routes';

class ServicoDeCliente {
    
    async verificarCPF(cpf) {

        let resposta = null;

        await Request.get(ROTAS.API.cliente.verificarCpf + cpf)
            .then( resultado => resposta = resultado)
            .catch( erro => resposta = erro );

        return resposta;
    };
}

export default new ServicoDeCliente();
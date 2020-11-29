import Request from './Request';
import { ROTAS } from '../Config/routes';

class ServicoDeGerente {
    
    async autenticar(usuario) {
        
        // return await Request.post(ROTAS.API.gerente.autenticar, usuario);

        return true;
    };
}

export default new ServicoDeGerente();
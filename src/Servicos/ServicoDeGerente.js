import Request from './Request';

class ServicoDeGerente {
    
    async autenticar(usuario) {

        // let resultado = {
        //     status: null
        // }

        // await Request.post('/login', usuario).then(resp => {
        //     resultado.status = resp;
        // });

        return {
            nome: 'teste'
        };
    };
}

export default new ServicoDeGerente();
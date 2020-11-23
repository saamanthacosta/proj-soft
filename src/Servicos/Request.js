import axios from 'axios';

const API = '';

class Request {

    get(url) {
        var resposta = axios.get(API + url);
        return resposta;
    };

    post(url, obj) {
        var resposta;

        resposta = axios.post(API + url, obj);

        return resposta;
    };

    delete(url, id) {
        var resposta = axios.delete(API + url, { 
            params: {id: id} } );
        return resposta 
    };

    put(url, obj) {
        var resposta = axios.put(API + url, obj);
        return resposta;
    };
}

export default new Request();
import axios from 'axios';

export const API = axios.create(
    {
            baseURL: "http://localhost:8000/",
            withCredentials: false,
            headers: {
              'Access-Control-Allow-Origin' : '*',
              'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',   
          }
      })

class Request {

    async get(url) {
        var resposta = await API.get(`cliente/identificar?cpf=98765432100`)
        return resposta;
    };

    post(url, obj, headers) {
        var resposta;

        if (headers === null) {
            resposta = API.post(url, obj);
        } else {
            resposta = API.post(url, obj, headers);
        }

        return resposta;
    };

    delete(url, id) {
        var resposta = API.delete(url, { params: {id: id} } );
        return resposta 
    };

    put(url, obj) {
        var resposta = API.put(url, obj);
        return resposta;
    };
}

export default new Request();
import React, { Component } from 'react';
import Login from '../Genericos/Login';
import ModalCliente from '../Modais/Cliente';
import VendedorActions from '../../Gerenciamento de Estados/Actions/VendedorActions';
import Usuario from '../../Modelos/Usuario';

export default class LoginVendedor extends Component {

  constructor(props) {
    super(props);
    this.state = {
      usuario: new Usuario()
    }
  };

  onChange = (evento) => {
    evento.preventDefault();
    const { name, value } = evento.target;
    let usuario = this.state.usuario;
    usuario[name] = value;
    this.setState({ usuario });
  };

  realizarLogin = (evento) => {
    evento.preventDefault();
    VendedorActions.login(this.state.usuario);
  }

  render() {
    return <>
      <ModalCliente />
      <Login realizarLogin={this.realizarLogin} onChange={this.onChange} tipoUsuario="Vendedor" />
    </>;
  }
}
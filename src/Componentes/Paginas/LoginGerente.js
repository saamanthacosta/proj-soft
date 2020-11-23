import React, { Component } from 'react';
import Login from '../Genericos/Login';
import GerenteActions from '../../Gerenciamento de Estados/Actions/GerenteActions';
import GerenteStore from '../../Gerenciamento de Estados/Stores/GerenteStore';
import { routes } from '../../Config/routes'
import Usuario from '../../Modelos/Usuario';

export default class LoginGerente extends Component {

  constructor(props) {
    super(props);
    this.state = {
      usuario: new Usuario()
    }
  };

  componentDidMount() {
    GerenteStore.on('LOGIN', this.redirecionar);
  }

  componentWillUnmount() {
    GerenteStore.removeListener('LOGIN', this.redirecionar)
  }

  redirecionar = () => {
    return this.props.history.push(routes.DASHBOARD_GERENTE);
  }

  onChange = (evento) => {
    evento.preventDefault();
    const { name, value } = evento.target;
    let usuario = this.state.usuario;
    usuario[name] = value;
    this.setState({ usuario });
  };

  realizarLogin = (e) => {
    e.preventDefault();
    GerenteActions.login(this.state.usuario);
  }

  render() {
    return (
      <Login realizarLogin={this.realizarLogin} onChange={this.onChange} tipoUsuario="Gerente" />
    );
  }
}
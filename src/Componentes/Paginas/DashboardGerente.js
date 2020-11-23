import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import { dashboardGerente } from '../../Estilização/estilizacao';
import { Icon } from '../../Estilização/icon';
import { routes } from '../../Config/routes'
import { NavLink } from 'react-router-dom';

export default function DashboardGerente() {
  const classes = dashboardGerente();

  const itensMenu = <>
    <NavLink to={routes.LOGIN_VENDEDOR} style={{color: 'inherit', textDecoration: 'none'}}>
      <ListItem button>
        <ListItemIcon>
          <Icon.ShoppingCart />
        </ListItemIcon>
        <ListItemText primary="Iniciar Venda" />
      </ListItem>
    </NavLink>
    <ListItem button>
      <ListItemIcon>
        <Icon.People />
      </ListItemIcon>
      <ListItemText primary="Cadastrar vendedor" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <Icon.People />
      </ListItemIcon>
      <ListItemText primary="Cadastrar cliente" />
    </ListItem>
  </>;

  return (
    <div className={classes.dashboard}>
      <CssBaseline />
      <AppBar position="absolute" className={classes.appBar}>
        <Toolbar className={classes.toolbar}>
          <Typography component="h1" variant="h6" color="inherit" noWrap className={classes.title}>
            Dashboard Gerente
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer variant="permanent" classes={{ paper: clsx(classes.drawerPaper, false) }} open={true} >
        <Divider />
        <List>{itensMenu}</List>
      </Drawer>
      <main className={classes.content}>

      </main>
    </div>
  );
}
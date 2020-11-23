import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';

const useStyles = {
  title: {
    fontSize: 14,
    marginBottom: 15
  },
  pos: {
      marginTop: 15,
    marginBottom: 10,
  },
};

export default function CardProduto() {
  const classes = useStyles;

  return (
    <Card>
      <CardContent>
        <Typography style={classes.title} color="textSecondary" gutterBottom>
          Produto que foi batido
        </Typography>
        <Typography variant="h5" component="h2">
            Nome do Produto
        </Typography>
        <Typography style={classes.pos} color="textSecondary">
          Valor do Produto
        </Typography>
        <Typography style={classes.pos} color="textSecondary">
          Codigo de Barras
        </Typography>
      </CardContent>
    </Card>
  );
}
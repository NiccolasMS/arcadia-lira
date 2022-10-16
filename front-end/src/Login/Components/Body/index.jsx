import React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import Botao from "./Botao/index";
import imagem from "../../../../assets/imagemlogin.png";

import useStyles from "./styles";

function Body() {
  const styles = useStyles();
  return (
    <Grid container>
      <Grid item sm={12} md={6}>
        <Box sx={styles.bola} />
        <Box component="img" src={imagem} sx={styles.imagem} />
      </Grid>
      <Grid item sm={12} md={6} sx={styles.centralizar}>
        <Grid sx={styles.h1} item md={12}>
          <Typography variant="h5">Seja bem-vindo</Typography>
        </Grid>
        <Grid item md={12}>
          <TextField sx={styles.TextField} label="Email" variant="outlined" />
        </Grid>
        <Grid item md={12}>
          <TextField sx={styles.TextField} label="Senha" variant="outlined" />
        </Grid>
        <Grid item md={12}>
          <Botao />
        </Grid>
        <Grid item md={12}>
          <Typography>
            Não possui conta? <a href="">Cadastre-se</a>
          </Typography>
        </Grid>
        <Grid item md={12}>
          <Typography>
            <a href="">Esqueceu a senha?</a>
          </Typography>
        </Grid>
      </Grid>
    </Grid>
  );
}

export default Body;

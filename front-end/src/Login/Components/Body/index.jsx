import React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import Botao from "./Botao/index";
import imagem from "../../../../assets/imagemlogin.png";

import useStyles from "./styles";

function Adicionar() {
  const navigate = useNavigate();

  function Cadastrar(event) {
    event.preventDefault();

    const novaMusica = {
      nome: event.target.nome.value,
      artista: event.target.artista.value,
      genero: event.target.genero.value,
      ano: event.target.ano.value,
      imagem: event.target.imagem.value,
    };
    api
      .post(`/`, novaMusica)
      .then((res) => {
        window.alert("Música adicionada");
        navigate("/musicas");
      })
      .catch((error) => {
        window.alert("Erro ao adicionar nova Música!");
      });
  }
}

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
          <Typography sx={styles.typography} variant="h5">
            Seja bem-vindo
          </Typography>
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
          <Typography sx={styles.typography}>
            Não possui conta? <a href="/cadastro">Cadastre-se</a>
          </Typography>
        </Grid>
        <Grid item md={12}>
          <Typography sx={styles.typography}>
            <a href="">Esqueceu a senha?</a>
          </Typography>
        </Grid>
      </Grid>
    </Grid>
  );
}

export default Body;

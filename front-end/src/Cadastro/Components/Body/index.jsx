import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import imagem from "../../../../assets/imagemcadastro.png";
import { useFormik } from "formik";
import * as yup from "yup";
import Button from "@mui/material/Button";
import api from "../../../services/api";

import useStyles from "./styles";

const validationSchema = yup.object({
  usuario: yup
    .string("Insira seu nome de usuário")
    .required("Nome de usuário é obrigatório"),
  email: yup
    .string("Insira seu email")
    .email("Insira seu email")
    .required("Emai é obrigatório"),
  senha: yup.string("Insira sua senha").required("Senha é obrigatória"),
  telefone: yup
    .string("Insira seu telefone")
    .required("Telefone é obrigatório"),
  bloco: yup.string("Insira seu bloco").required("Bloco é obrigatório"),
});

function Body() {
  const styles = useStyles();

  const formik = useFormik({
    initialValues: {
      usuario: "",
      email: "",
      senha: "",
      telefone: "",
      bloco: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api.post("/usuarios/cadastrarMorador", {
        nome: values.usuario,
        email: values.email,
        senha: values.senha,
        telefone: values.telefone,
        bloco: values.bloco,
      });
    },
  });

  return (
    <form onSubmit={formik.handleSubmit}>
      <Grid container>
        <Grid item sm={12} md={6}>
          <Box sx={styles.bola} />
          <Box component="img" src={imagem} sx={styles.imagem} />
        </Grid>
        <Grid item sm={12} md={6} sx={styles.centralizar}>
          <Grid sx={styles.h1} item md={12}>
            <Typography sx={styles.typography} variant="h5">
              Crie sua conta
            </Typography>
          </Grid>
          <Grid item md={12}>
            <TextField
              sx={styles.TextField}
              label="Usuário"
              id="usuario"
              name="usuario"
              type="usuario"
              value={formik.values.usuario}
              onChange={formik.handleChange}
              variant="outlined"
            />
          </Grid>
          <Grid item md={12}>
            <TextField
              sx={styles.TextField}
              label="Email"
              id="email"
              name="email"
              variant="outlined"
              value={formik.values.email}
              onChange={formik.handleChange}
            />
          </Grid>
          <Grid item md={12}>
            <TextField
              sx={styles.TextField}
              label="Senha"
              id="senha"
              name="senha"
              type="password"
              value={formik.values.senha}
              onChange={formik.handleChange}
              variant="outlined"
            />
          </Grid>
          <Grid item md={12}>
            <TextField
              sx={styles.TextField}
              label="Telefone"
              id="telefone"
              name="telefone"
              value={formik.values.telefone}
              onChange={formik.handleChange}
              variant="outlined"
            />
          </Grid>
          <Grid item md={12}>
            <TextField
              sx={styles.TextField}
              label="Bloco"
              id="bloco"
              name="bloco"
              value={formik.values.bloco}
              onChange={formik.handleChange}
              variant="outlined"
            />
          </Grid>
          <Grid item md={12}>
            <Button
              sx={styles.botao}
              type="submit"
              size="large"
              variant="contained"
            >
              Criar minha conta
            </Button>
          </Grid>
          <Grid item md={12}>
            <Typography sx={styles.typography}>
              Já possui conta? <a href="/login">Login</a>
            </Typography>
          </Grid>
        </Grid>
      </Grid>
    </form>
  );
}

export default Body;

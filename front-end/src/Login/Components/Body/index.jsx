import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import Button from "@mui/material/Button";
import { useFormik } from "formik";
import * as yup from "yup";
import imagem from "../../../../assets/imagemlogin.png";
import api from "../../../services/api";

import useStyles from "./styles";

const validationSchema = yup.object({
  email: yup
    .string("Insira seu email")
    .email("Verifique se o email está escrito conforme o padrão!")
    .required("Emai é obrigatório"),
  senha: yup.string("Insira sua senha").required("Senha é obrigatória"),
});

function Body() {
  const styles = useStyles();

  const formik = useFormik({
    initialValues: {
      email: "",
      senha: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api
        .post(`/usuarios/loginMorador/${values.email}/${values.senha}`)
        .then((res) => {
          alert("Login realizado com sucesso!");
        })
        .catch((erro) => {
          alert("Erro ao realizar o Login");
          console.log(erro);
        });
    },
  });

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
          <Button
            sx={styles.botao}
            type="submit"
            size="large"
            variant="contained"
          >
            Entrar
          </Button>
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

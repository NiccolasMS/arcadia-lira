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
import { useNavigate } from "react-router-dom";

const validationSchema = yup.object({
  email: yup
    .string("Insira seu email")
    .email("Insira seu email")
    .required("Email é obrigatório"),
  senha: yup.string("Insira sua senha").required("Senha é obrigatória"),
});

function Body() {
  const styles = useStyles();
  const navigate = useNavigate();

  const formik = useFormik({
    initialValues: {
      email: "",
      senha: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api
        .post("/usuarios/login", {
          email: values.email,
          senha: values.senha,
        })
        .then((res) => {
          alert("Login realizado com sucesso!");
          navigate("/morador");
        })
        .catch((erro) => {
          alert("Erro ao realizar o Login");
          console.log(erro);
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
        </Grid>
      </Grid>
    </form>
  );
}

export default Body;

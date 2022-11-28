import React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import { useFormik } from "formik";
import Botao from "./Botao/index";
import imagem from "../../../../assets/CoronaIndex.png";
import imagemBarra from "../../../../assets/setaDupla.png";
import ellipse from "../../../../assets/Ellipse.png";
import * as yup from "yup";
import api from "../../../services/api";
import Button from "@mui/material/Button";

import useStyles from "./styles";

const validationSchema = yup.object({
  email: yup
    .string("Insira o email")
    .email("Email é necessário")
    .required("Email é obrigatório"),
});

function Body() {
  const formik = useFormik({
    initialValues: {
      email: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api
        .post(`/porteiros/enviarEmailIndex/${values.email}`)
        .then((res) => {
          alert("Email enviado com sucesso!");
        })
        .catch((erro) => {
          alert("Erro ao enviar Email");
          console.log(erro);
        });
    },
  });

  const styles = useStyles();
  return (
    <form onSubmit={formik.handleSubmit}>
      <Grid container>
        <Grid item sm={12} md={6}>
          <Box component="img" src={ellipse} sx={styles.ellipse} />
          <Box component="img" src={imagem} sx={styles.imagem} />
          <Grid sx={styles.centralizar}>
            <Typography sx={styles.typography} variant="h5">
              Inovação para descomplicar sua gestão
            </Typography>
          </Grid>
          <Grid>
            <Grid sx={styles.centralizar2}>
              <Grid>
                <Typography sx={styles.typography2}>
                  Insira seu Email
                </Typography>
                <Grid md={12}>
                  <TextField
                    sx={styles.TextField}
                    label="Email"
                    id="email"
                    name="email"
                    variant="outlined"
                    value={formik.values.email}
                    onChange={formik.handleChange}
                  />
                  <Button type="submit" sx={styles.botao}>
                    Enviar Email
                  </Button>
                </Grid>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </form>
  );
}

export default Body;

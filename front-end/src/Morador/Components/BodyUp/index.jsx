import { React, ReactDOM, useState, useEffect } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Box, Typography } from "@mui/material";
import { useFormik } from "formik";
import imgBox from "../../../../assets/box.png";
import * as yup from "yup";
import api from "../../../services/api";

import useStyles from "./styles";
import BodyRight from "../BodyRight";
// import { Container } from './styles';
import ItemEncomenda from "./components";

const validationSchema = yup.object({
  codigoDeRastreio: yup
    .string("Insira o código do produto")
    .max("Código deve conter até 10 caracteres")
    .min("Código deve conter no mínimo 3 caracteres")
    .required("Código do produto é obrigatório"),
  descricao: yup
    .string("Insira a descrição")
    .max("Descrição deve conter até 200 caracteres")
    .required("descrição do produto é obrigatória"),
});

function BodyUp() {
  const styles = useStyles();

  const [listaEncomendas, setListaEncomendas] = useState([]);

  useEffect(() => {
    api
      .get("/encomendas")
      .then((res) => {
        setListaEncomendas(res.data.reverse());
      })
      .catch((erro) => {
        console.log(erro);
      });
  }, [listaEncomendas]);

  const formik = useFormik({
    initialValues: {
      codigoDeRastreio: "",
      descricao: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api
        .post(
          `/encomendas/cadastrarEncomenda/${values.codigoDeRastreio}/${values.descricao}`
        )
        .then((res) => {
          alert("Encomenda cadastrada com sucesso!");
        })
        .catch((erro) => {
          alert("Erro ao cadastrar Encomenda");
          console.log(erro);
        });
    },
  });

  return (
    <form onSubmit={formik.handleSubmit}>
      <Grid sx={styles.align}>
        <Grid sx={styles.container2}>
          <Grid sx={styles.container}>
            <Grid item sm={12} md={6} sx={styles.centralizar2}>
              <Grid sx={styles.h1} item md={12}>
                <Typography sx={styles.typography2} variant="h5">
                  Insira o código da compra aqui:
                </Typography>
              </Grid>
              <Grid sx={styles.h1} item md={12}>
                <Typography sx={styles.typography2} variant="h5">
                  Nome do pedido:
                </Typography>
              </Grid>
            </Grid>
            <Grid item sm={12} md={6} sx={styles.centralizar}>
              <Grid item md={12}>
                <TextField
                  sx={styles.TextField}
                  label="Código"
                  id="codigoDeRastreio"
                  name="codigoDeRastreio"
                  variant="outlined"
                  value={formik.values.codigoDeRastreio}
                  onChange={formik.handleChange}
                />
              </Grid>
              <Grid item md={12}>
                <TextField
                  sx={styles.TextField}
                  label="Descrição"
                  id="descricao"
                  name="descricao"
                  variant="outlined"
                  value={formik.values.descricao}
                  onChange={formik.handleChange}
                />
              </Grid>
              <Grid item md={12}>
                <Button sx={styles.botao} type="submit" variant="contained">
                  Inserir Produto
                </Button>
              </Grid>
            </Grid>
          </Grid>
          <Grid sx={styles.container}>
            <Grid item sm={12} md={6} sx={styles.centralizarContent}>
              <Grid sx={styles.h1} item md={12}>
                <Typography sx={styles.typographyContent} variant="h5">
                  <Box
                    sx={styles.alignicon}
                    component="img"
                    src={imgBox}
                    height="35px"
                  />
                  Encomendas Pendentes:
                </Typography>
                <Grid sx={styles.encomendas} item md={12}>
                  {listaEncomendas.map((encomendas) => (
                    <ItemEncomenda
                      key={encomendas.id}
                      descricao={encomendas.descricao}
                      codigoDeRastreio={encomendas.codigoDeRastreio}
                      id={encomendas.id}
                    />
                  ))}
                </Grid>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
        <BodyRight />
      </Grid>
    </form>
  );
}

export default BodyUp;

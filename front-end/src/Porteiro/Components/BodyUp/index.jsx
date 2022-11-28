import { React, ReactDOM, useState, useEffect } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Box, Typography } from "@mui/material";
import imgBox from "../../../../assets/box.png";
import api from "../../../services/api";
import ItemEncomendaTeste from "../../../Porteiro/Components/BodyUp/components/index";

import useStyles from "./styles";
import BodyRight from "../BodyRight";
// import { Container } from './styles';

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

  return (
    <>
      <Grid sx={styles.align}>
        <Grid sx={styles.container2}>
          <Grid sx={styles.container}>
            <Grid item sm={12} md={6} sx={styles.centralizar2}>
              <Grid sx={styles.alignicon}>
                <Box component="img" src={imgBox} height="35px" />
              </Grid>
              <Grid sx={styles.h1} item md={12}>
                <Typography sx={styles.typography2} variant="h5">
                  Insira o código da encomenda aqui:
                </Typography>
              </Grid>
            </Grid>
            <Grid item sm={12} md={6} sx={styles.centralizar}>
              <Grid item md={12}>
                <TextField
                  sx={styles.TextField}
                  label="Buscar pelo código"
                  id="codigo"
                  name="codigo"
                  variant="outlined"
                />
              </Grid>
              <Grid item md={12}>
                <Button sx={styles.botao} type="submit" variant="contained">
                  BUSCAR
                </Button>
              </Grid>
            </Grid>
          </Grid>
          <Grid sx={styles.container}>
            <Grid sx={styles.alignicon2}>
              <Box component="img" src={imgBox} height="35px" />
            </Grid>
            <Grid item sm={12} md={6} sx={styles.centralizarContent}>
              <Grid sx={styles.h1} item md={12}>
                <Typography sx={styles.h1} variant="h5">
                  Encomendas
                </Typography>
                <Grid sx={styles.encomendas} item md={12}>
                  {listaEncomendas.map((encomendas) => (
                    <ItemEncomendaTeste
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
    </>
  );
}

export default BodyUp;

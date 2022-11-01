import React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import Botao from "./Botao/index";
import imagem from "../../../../assets/CoronaIndex.png";
import imagemBarra from "../../../../assets/setaDupla.png";
import ellipse from "../../../../assets/Ellipse.png";

import useStyles from "./styles";

function Informacoes() {
  const styles = useStyles();
  return (
    <Grid container>
      <Grid item sm={12} md={8}>
        <Grid sx={styles.centralizar}>
          <Typography sx={styles.typography} variant="h5">
            Como a Arcádia pode melhorar a minha gestão?
          </Typography>
          <Typography sx={styles.textoInfo} variant="h5">
            txt1
          </Typography>
          <Typography sx={styles.textoInfo} variant="h5">
            txt2
          </Typography>
          <Typography sx={styles.textoInfo} variant="h5">
            txt3
          </Typography>
        </Grid>
      </Grid>
      <Grid item sm={12} md={4} sx={styles.centralizar} />
    </Grid>
  );
}

export default Informacoes;

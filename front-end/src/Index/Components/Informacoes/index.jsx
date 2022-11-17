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
          <Typography sx={styles.textoInfo1} variant="h5">
            Ela agiliza os processos através de automatização;
          </Typography>
          <Typography sx={styles.textoInfo2} variant="h5">
            Auxilia no processo de organização de chegada, controle e saída ;
          </Typography>
          <Typography sx={styles.textoInfo3} variant="h5">
            Agrega mais segurança ao implementar um modelo de alertas e checks.
          </Typography>
        </Grid>
      </Grid>
      <Grid item sm={12} md={4} sx={styles.centralizar}>
        <Box sx={styles.folha1} />
        <Box sx={styles.folha2} />
        <Box sx={styles.folha3} />
        <Box sx={styles.folha4} />
      </Grid>
    </Grid>
  );
}

export default Informacoes;

import React from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Box, Typography } from "@mui/material";
import Botao from "./Botao/index";
import imagem from "../../../../assets/CoronaIndex.png";
import imagemBarra from "../../../../assets/setaDupla.png";
import ellipse from "../../../../assets/Ellipse.png";

import useStyles from "./styles";

function Body() {
  const styles = useStyles();
  return (
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
              <TextField />
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </Grid>
  );
}

export default Body;

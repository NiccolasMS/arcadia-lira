import React from "react";
import Grid from "@mui/material/Grid";
import { Box, Typography } from "@mui/material";
import useStyles from "./styles";

function Valores() {
  const styles = useStyles();
  return (
    <Grid container>
      <Grid item sm={12} md={8}>
        <Grid sx={styles.centralizar}>
          <Typography sx={styles.typography} variant="h5">
            teste
          </Typography>
        </Grid>
      </Grid>
      <Grid item sm={12} md={4} sx={styles.centralizar}>
        <Typography sx={styles.typography} variant="h5">
          teste2
        </Typography>
      </Grid>
      <Box sx={styles.fundo} />
    </Grid>
  );
}

export default Valores;

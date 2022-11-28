import { TextField } from "@mui/material";
import { Box } from "@mui/system";
import { Grid } from "@mui/material";
import React, { useState } from "react";

import useStyles from "./styles";

function ItemEncomenda(props) {
  const [descricaoInput, setDescricaoInput] = useState(props.descricao);
  const [codigoDeRastreioInput, setCodigoDeRastreioInput] = useState(
    props.codigoDeRastreio
  );

  const styles = useStyles();

  return (
    <>
      <Box sx={styles.centralizar}>
        <Box>
          <Grid sx={styles.espacamento}>
            <TextField
              sx={styles.textField}
              label="Descrição"
              type="text"
              disabled
              defaultValue={descricaoInput}
              onChange={(e) => setDescricaoInput(e.target.value)}
            />
          </Grid>
          <Grid>
            <TextField
              sx={styles.textField}
              label="Código"
              type="text"
              disabled
              variant="outlined"
              defaultValue={codigoDeRastreioInput}
              onChange={(e) => setCodigoDeRastreioInput(e.target.value)}
            />
          </Grid>
        </Box>
      </Box>
    </>
  );
}

export default ItemEncomenda;

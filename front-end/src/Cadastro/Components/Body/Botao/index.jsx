import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import useStyles from "./styles";

function Botao() {
  const styles = useStyles();

  return (
    <Button sx={styles.botao} type="submit" size="large" variant="contained">
      Criar minha conta
    </Button>
  );
}

export default Botao;

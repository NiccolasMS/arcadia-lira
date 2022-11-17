import React from "react";
import { Box } from "@mui/material";
import Header from "./Components/Header/index";
import Body from "./Components/Body/index";

import useStyles from "./styles";
import Informacoes from "./Components/Informacoes";
import Valores from "./Components/Valores";

function Index() {
  const styles = useStyles();
  return (
    <>
      <Box sx={styles.fundo}>
        <Header />
        <Body />
      </Box>
      <Informacoes />
      <Valores />
    </>
  );
}

export default Index;

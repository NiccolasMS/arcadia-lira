import React from "react";
import { Box } from "@mui/material";
import Header from "./Components/Header/index";
import Body from "./Components/Body/index";

import useStyles from "./styles";

function Index() {
  const styles = useStyles();
  return (
    <Box sx={styles.fundo}>
      <Header />
      <Body />
    </Box>
  );
}

export default Index;

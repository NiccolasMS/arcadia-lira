import React from "react";
import { Box, Stack } from "@mui/material";
import Logo from "./Logo/index";
import Botao from "./Botao/index";

import useStyles from "./styles";

function Header() {
  const styles = useStyles();
  return (
    <Box sx={styles.container}>
      <Box sx={styles.box}>
        <Stack sx={styles.header}>
          <Logo />
          <Botao />
        </Stack>
      </Box>
    </Box>
  );
}

export default Header;

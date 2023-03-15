import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";
import useStyles from "./styles";

function Botao() {
  const styles = useStyles();
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate("/login");
  };

  return (
    <Box sx={styles.margem}>
      <Button
        onClick={handleLogin}
        sx={styles.botaoLogin}
        size="medium"
        variant="contained"
      >
        Login
      </Button>
    </Box>
  );
}

export default Botao;

import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";
import useStyles from "./styles";

function Botao() {
  const styles = useStyles();
  const navigate = useNavigate();

  const handleInicio = () => {
    navigate(-1);
  };

  return (
    <Box sx={styles.margem}>
      <Button
        onClick={handleInicio}
        sx={styles.botaoLogin}
        size="medium"
        variant="contained"
      >
        Login
      </Button>
      <Button
        onClick={handleInicio}
        sx={styles.botaoCadastro}
        size="medium"
        variant="contained"
      >
        Cadastro
      </Button>
    </Box>
  );
}

export default Botao;

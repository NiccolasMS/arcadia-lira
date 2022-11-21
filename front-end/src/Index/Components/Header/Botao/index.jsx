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

  const handleCadastro = () => {
    navigate("/cadastro");
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
      <Button
        onClick={handleCadastro}
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

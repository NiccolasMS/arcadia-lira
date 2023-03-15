import React from "react";
import { Box } from "@mui/material";
import { useNavigate } from "react-router-dom";
import imagem from "../../../../../assets/logo-site.png";

function Logo() {
  const navigate = useNavigate();

  const handleInicio = () => {
    navigate(-1);
  };
  return (
    <Box
      onClick={handleInicio}
      component="img"
      src={imagem}
      height="70px"
      padding="20px"
      marginTop="15px"
    />
  );
}

export default Logo;

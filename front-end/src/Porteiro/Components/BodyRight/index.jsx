import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import { Box, Typography } from "@mui/material";
import Button from "@mui/material/Button";
import imagem from "../../../../assets/logo-site.png";
import imagemPortaria from "../../../../assets/alphaicon.png";
import imgExit from "../../../../assets/exit-icon.png";
import { useNavigate } from "react-router-dom";

import useStyles from "./styles";

function BodyRight() {
  const navigate = useNavigate();
  const styles = useStyles();

  const handleInicio = () => {
    navigate("/");
  };

  return (
    <>
      <Grid sx={styles.container}>
        <Box component="img" src={imagem} height="70px" padding="20px" />
        <Box component="img" src={imagemPortaria} sx={styles.circle}></Box>
        <Typography sx={styles.typography2} variant="h5">
          Alpha Condôminos
        </Typography>
        <Grid item md={12}>
          <Button
            onClick={handleInicio}
            sx={styles.botao}
            type="submit"
            variant="contained"
          >
            Sair
            <Box
              component="img"
              src={imgExit}
              height="20px"
              color={"#ffffff"}
            />
          </Button>
        </Grid>
      </Grid>
    </>
  );
}

export default BodyRight;

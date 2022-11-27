import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import { Box, Typography } from "@mui/material";
import Button from "@mui/material/Button";
import imagem from "../../../../assets/logo-site.png";
import imgExit from "../../../../assets/exit-icon.png";

import useStyles from "./styles";

function BodyRight() {
    const styles = useStyles();
    return (
        <>
            <Grid sx={styles.container}>
                <Box
                    component="img"
                    src={imagem}
                    height="70px"
                    padding="20px"
                />
                <Box sx={styles.circle}></Box>
                <Typography sx={styles.typography2} variant="h5">
                    Nome do Condominio
                </Typography>
                <Grid item md={12}>
                    <Button
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
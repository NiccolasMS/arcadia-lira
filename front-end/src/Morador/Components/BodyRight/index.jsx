import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import { Box, Typography } from "@mui/material";
import imagem from "../../../../assets/logo-site.png";

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
                    Maria
                </Typography>
            </Grid>
        </>
    );
}

export default BodyRight;
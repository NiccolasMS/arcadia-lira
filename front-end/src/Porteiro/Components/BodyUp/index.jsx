import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Box, Typography } from "@mui/material";
import imgBox from "../../../../assets/box.png";


import useStyles from "./styles";
import BodyRight from "../BodyRight";
// import { Container } from './styles';

function BodyUp() {
    const styles = useStyles();
    return (
        <>

            <Grid sx={styles.align}>
                <Grid sx={styles.container2}>
                    <Grid sx={styles.container}>
                        <Grid item sm={12} md={6} sx={styles.centralizar2}>
                            <Grid sx={styles.alignicon}>
                                <Box
                                    component="img"
                                    src={imgBox}
                                    height="35px"
                                />
                            </Grid>
                            <Grid sx={styles.h1} item md={12}>
                                <Typography sx={styles.typography2} variant="h5">
                                    Insira o código da encomenda aqui:
                                </Typography>
                            </Grid>
                        </Grid>
                        <Grid item sm={12} md={6} sx={styles.centralizar}>
                            <Grid item md={12}>
                                <TextField
                                    sx={styles.TextField}
                                    label="Buscar pelo código"
                                    id="codigo"
                                    name="codigo"
                                    variant="outlined"
                                />
                            </Grid>
                            <Grid item md={12}>
                                <Button
                                    sx={styles.botao}
                                    type="submit"
                                    variant="contained"
                                >
                                    BUSCAR
                                </Button>
                            </Grid>
                        </Grid>
                    </Grid>
                    <Grid sx={styles.container}>
                        <Grid item sm={12} md={6} sx={styles.centralizarContent}>
                            <Grid sx={styles.alignicon}>
                                <Box
                                    component="img"
                                    src={imgBox}
                                    height="35px"
                                />
                            </Grid>
                            <Grid sx={styles.h1} item md={12}>
                                <Typography sx={styles.typography2} variant="h5">
                                    Encomendas
                                </Typography>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
                <BodyRight />
            </Grid>
        </>
    );
}

export default BodyUp;
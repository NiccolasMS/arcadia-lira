import { React, ReactDOM } from "react";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Typography } from "@mui/material";


import useStyles from "./styles";
import BodyRight from "../BodyRight";
// import { Container } from './styles';

function BodyUp() {
    const styles = useStyles();
    return (
        <>
        <Grid sx={styles.align}>
            <Grid sx={styles.container}>
                <Grid item sm={12} md={6} sx={styles.centralizar2}>
                    <Grid sx={styles.h1} item md={12}>
                        <Typography sx={styles.typography2} variant="h5">
                            Insira o código da compra aqui:
                        </Typography>
                    </Grid>
                    <Grid sx={styles.h1} item md={12}>
                        <Typography sx={styles.typography2} variant="h5">
                            Nome do pedido:
                        </Typography>
                    </Grid>
                </Grid>
                <Grid item sm={12} md={6} sx={styles.centralizar}>
                    <Grid item md={12}>
                        <TextField
                            sx={styles.TextField}
                            label="Codigo"
                            id="codigo"
                            name="codigo"
                            variant="outlined"
                        />
                    </Grid>
                    <Grid item md={12}>
                        <TextField
                            sx={styles.TextField}
                            label="Nome do Pedido"
                            id="nomePedido"
                            name="nomePedido"
                            variant="outlined"
                        />
                    </Grid>
                    <Grid item md={12}>
                        <Button
                            sx={styles.botao}
                            type="submit"
                            variant="contained"
                        >
                            Inserir Produto
                        </Button>
                    </Grid>
                </Grid>
            </Grid>
            <BodyRight />
        </Grid>
        </>
    );
}

export default BodyUp;
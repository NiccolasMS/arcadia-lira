import { Box, Grid } from '@mui/material';
import React from 'react';
import useStyles from '../Login/styles';
import BodyRight from './Components/BodyRight';
import BodyUp from './Components/BodyUp';

// import { Container } from './styles';

function Morador() {
    const styles = useStyles();
    return (
        <Grid sx={styles.container}>
            <BodyUp />
        </Grid>
    );
}

export default Morador;
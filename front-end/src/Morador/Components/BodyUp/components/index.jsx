import { TextField } from "@mui/material";
import { Box } from "@mui/system";
import { Grid } from "@mui/material";
import React, { useState } from "react";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { useFormik } from "formik";
import * as yup from "yup";

import useStyles from "./styles";

const validationSchema = yup.object({
  id: yup.string("Insira o Id").required("Id é obrigatório"),
});

function ItemEncomenda(props) {
  const [descricaoInput, setDescricaoInput] = useState(props.descricao);
  const [statusInput, setStatusInput] = useState(props.status);
  const [codigoDeRastreioInput, setCodigoDeRastreioInput] = useState(
    props.codigoDeRastreio
  );

  const styles = useStyles();

  const formik = useFormik({
    initialValues: {
      id: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      api
        .put(`/encomendas/atualizar-status/${values.id}`)
        .then((res) => {
          alert("Status atualizado com sucesso!");
        })
        .catch((erro) => {
          alert("Erro ao atualizar o Status");
          console.log(erro);
        });
    },
  });

  return (
    <form onSubmit={formik.handleSubmit}>
      <Box sx={styles.centralizar}>
        <Grid sx={styles.espacamento}>
          <TextField
            sx={styles.textField}
            label="Descrição"
            type="text"
            disabled
            defaultValue={descricaoInput}
            onChange={(e) => setDescricaoInput(e.target.value)}
          />
        </Grid>
        <Grid sx={styles.espacamento}>
          <TextField
            sx={styles.textField}
            label="Código"
            type="text"
            disabled
            variant="outlined"
            defaultValue={codigoDeRastreioInput}
            onChange={(e) => setCodigoDeRastreioInput(e.target.value)}
          />
        </Grid>
        <Grid>
          <TextField
            sx={styles.textField}
            label="Status"
            type="text"
            disabled
            variant="outlined"
            defaultValue={statusInput}
            onChange={(e) => setStatusInput(e.target.value)}
          />
        </Grid>
      </Box>
    </form>
  );
}

export default ItemEncomenda;

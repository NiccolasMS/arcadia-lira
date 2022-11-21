import React, { useState, useEffect } from "react";

import api from "../services/api";

import ItemEncomenda from "../components/ItemEncomenda";
import { Box } from "@mui/material";

function TelaUsuario() {
  const [listaEncomendas, setListaEncomendas] = useState([]);

  useEffect(() => {
    api
      .get("/encomendas")
      .then((res) => {
        console.log(res);
        setListaEncomendas(res.data.reverse());
      })
      .catch((erro) => {
        console.log(erro);
      });
  }, []);

  return (
    <Box>
      <h1>teste</h1>
      {listaEncomendas.map((pedido) => (
        <ItemEncomenda
          key={pedido.id}
          nome={pedido.nome}
          codigoDeRastreio={pedido.codigoDeRastreio}
        />
      ))}
    </Box>
  );
}

export default TelaUsuario;

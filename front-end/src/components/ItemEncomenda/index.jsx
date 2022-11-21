import React, { useState } from "react";

import deleteIcon from "../../../assets/delete-icon.png";
import editIcon from "../../../assets/edit-icon.png";

import api from "../../services/api";

function ItemEncomenda(props) {
  const [nomeInput, setNomeInput] = useState(props.nome);
  const [codigoInput, setCodigoInput] = useState(props.codigo);

  const [editavel, setEditavel] = useState(false);

  function editar() {
    const musicaEditada = {
      nome: nomeInput,
      codigo: codigoInput,
    };

    // /musica-box/{id}
    api
      .put(`/${props.id}`, musicaEditada)
      .then((res) => {
        alert("Musica Atualizada!");
        setEditavel(false);
      })
      .catch((erro) => {
        alert("Deu erro, se vira!");
        console.log(erro);
      });

    console.log(musicaEditada);
  }

  return (
    <>
      <div className="card-music">
        <div className="info-music">
          <p>
            <strong className="card-title">música: </strong>
            <input
              className={
                editavel ? "input-music-enable" : "input-music-disabled"
              }
              disabled={!editavel}
              type="text"
              defaultValue={nomeInput}
              onChange={(e) => setNomeInput(e.target.value)}
            />
          </p>
          <p>
            <strong className="card-title">código: </strong>
            <input
              type="text"
              defaultValue={codigoInput}
              onChange={(e) => setCodigoInput(e.target.value)}
            />
          </p>
          <button
            className={editavel ? "btn-salvar-enable" : "btn-salvar-disabled"}
            onClick={editar}
          >
            Salvar
          </button>
        </div>
      </div>
    </>
  );
}

export default ItemEncomenda;

import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginBottom: "8%",
    marginLeft: "auto",
    marginRight: "3%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
    border: "2px solid #00A089",
    borderTopColor: "#FFFFFF",
    borderRightColor: "#FFFFFF",
    borderLeftColor: "#FFFFFF",
    borderBottomColor: "#FF862F",
  },
  espacamento: {
    marginBottom: "2%",
  },
  distancia:{
    marginTop: "10%",
  },
  textField: {
    color: "black",
    borderRadius: "5px",
    fontFamily: "'Montserrat', sans-serif",
    marginTop: "2%",
    marginLeft: "12%",
    marginBottom: "10%",
    backgroundColor: "white",
    width: "300px",
    "& label.Mui-focused": {
      color: "#00A089",
    },
    "& .MuiInput-underline:after": {
      borderBottomColor: "#00A089",
      color: "black",
    },
    "& .MuiOutlinedInput-root": {
      "& fieldset": {
        borderColor: "#00A089",
        color: "black",
      },
      "&:hover fieldset": {
        borderColor: "#00A089",
        color: "black",
      },
      "&.Mui-focused fieldset": {
        borderColor: "#00A089",
        color: "black",
      },
    },
  },
  botao: {
    marginTop: "10px",
    marginBottom: "6%",
    fontFamily: "'Montserrat', sans-serif",
    fontWeight: "bold",
    color: "white",
    backgroundColor: "#00A089",
    width: "300px",
    "&:hover": {
      fontFamily: "'Montserrat', sans-serif",
      backgroundColor: "#00A089",
      color: "white",
      fontWeight: "bolder",
    },
  },
});

export default useStyles;

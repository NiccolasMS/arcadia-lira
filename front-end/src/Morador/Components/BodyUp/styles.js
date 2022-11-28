import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginTop: "2%",
    marginLeft: "auto",
    marginRight: "3%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  centralizar2: {
    marginTop: "2%",
    display: "flex",
    flexDirection: "column",
  },
  centralizarContent: {
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
    marginBottom: "2%",
    marginTop: "2%",
  },
  h1: {
    fontFamily: "'Montserrat', sans-serif",
    marginBottom: "4%",
  },
  typography: {
    fontFamily: "'Montserrat', sans-serif",
  },
  typography2:{
    fontFamily: "'Montserrat', sans-serif",
    marginTop: "4%",
    marginLeft: "8%",
    width: "100%",
  },
  typographyContent:{
    fontFamily: "'Montserrat', sans-serif",
    width: "100%",
    marginBottom: "8%",
  },
  bola: {
    boxSizing: "border-box",
    borderRadius: "100%",
    position: "absolute",
    width: "300px",
    height: "300px",
    marginTop: "40px",
    marginLeft: "210px",
    background:
      "linear-gradient(180deg, #FF862F 17.19%, rgba(255, 134, 47, 0.6) 47.92%)",
    transform: "rotate(35.45deg)",
  },
  imagem: {
    boxSizing: "border-box",
    position: "absolute",
    width: "400px",
    height: "400px",
    marginLeft: "150px",
  },
  TextField: {
    borderRadius: "5px",
    fontFamily: "'Montserrat', sans-serif",
    marginTop: "2%",
    backgroundColor: "white",
    width: "300px",
    "& label.Mui-focused": {
      color: "#00A089",
    },
    "& .MuiInput-underline:after": {
      borderBottomColor: "#00A089",
    },
    "& .MuiOutlinedInput-root": {
      "& fieldset": {
        borderColor: "#00A089",
      },
      "&:hover fieldset": {
        borderColor: "#00A089",
      },
      "&.Mui-focused fieldset": {
        borderColor: "#00A089",
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
  container:{
    
    maxHeight: "457px",
    overflowX: "hidden",
    display: "flex",
    border: "2px solid #00A089",
    borderTopColor: "#FFFFFF",
    borderLeftColor: "#FFFFFF",
    borderRightColor: "#FFFFFF",
    borderBottomColor: "#FF862F",
  },
  container2:{
    display: "flex",
    flexDirection: "column",
    width: "70%",
   },
  align:{
    display: "flex",
  },
  alignicon:{
    textAlign: "center",
    marginRight: "10px",
    marginLeft: "15px",
  }
});

export default useStyles;

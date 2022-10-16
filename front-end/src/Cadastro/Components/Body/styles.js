import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginTop: "1%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  h1: {
    marginBottom: "4%",
  },
  typography: {
    fontFamily: "'Montserrat', sans-serif",
  },
  bola: {
    boxSizing: "border-box",
    borderRadius: "100%",
    position: "absolute",
    width: "300px",
    height: "300px",
    marginTop: "80px",
    marginLeft: "210px",
    background:
      "linear-gradient(180deg, #00A089 17.19%, rgba(0, 160, 137, 0.65) 52.6%)",
    transform: "rotate(35.45deg)",
  },
  imagem: {
    boxSizing: "border-box",
    position: "absolute",
    width: "400px",
    height: "400px",
    marginLeft: "150px",
    marginTop: "40px",
  },
  TextField: {
    borderRadius: "5px",
    marginBottom: "2%",
    marginTop: "2%",
    backgroundColor: "white",
    width: "500px",
    "& label.Mui-focused": {
      color: "#FF862F",
    },
    "& .MuiInput-underline:after": {
      borderBottomColor: "#FF862F",
    },
    "& .MuiOutlinedInput-root": {
      "& fieldset": {
        borderColor: "#FF862F",
      },
      "&:hover fieldset": {
        borderColor: "#FF862F",
      },
      "&.Mui-focused fieldset": {
        borderColor: "#FF862F",
      },
    },
  },
});

export default useStyles;

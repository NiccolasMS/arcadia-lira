import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginTop: "1%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  informacoes: {
    marginTop: "10%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  h1: {
    marginBottom: "4%",
  },
  barra: {
    position: "absolute",
    height: "122px",
    width: "543px",
    marginLeft: "79.5%",
    marginRight: "33%",
    marginTop: "29%",
    background: "#39BFBF",
    borderRadius: "30px",
  },
  typography: {
    paddingTop: "13%",
    paddingLeft: "15%",
    paddingBottom: "30%",
    fontWeight: "bold",
    fontSize: "40px",
    fontFamily: "'Montserrat', sans-serif",
  },
  typographyBarra: {
    paddingTop: "8.4%",
    paddingLeft: "15%",
    paddingBottom: "30%",
    color: "white",
    fontSize: "25px",
    fontFamily: "'Montserrat', sans-serif",
  },
  bola: {
    boxSizing: "border-box",
    borderRadius: "100%",
    position: "absolute",
    width: "500px",
    height: "500px",
    marginTop: "-400px",
    marginLeft: "920px",
    background:
      "linear-gradient(180deg, rgba(255, 134, 47, 0.6) 0%, rgba(255, 134, 47, 0.6) 100%)",
  },
  ellipse: {
    boxSizing: "border-box",
    position: "absolute",
    height: "300px",
    marginLeft: "843px",
    marginTop: "-130px",
    zIndex: 1,
  },
  imagem: {
    boxSizing: "border-box",
    position: "absolute",
    width: "450px",
    height: "450px",
    marginLeft: "685px",
    marginTop: "-80px",
    zIndex: 1,
  },
  imagemBarra: {
    height: "25px",
    boxSizing: "border-box",
    position: "absolute",
    marginLeft: "440px",
    marginTop: "-190px",
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

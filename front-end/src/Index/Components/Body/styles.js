import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginTop: "1%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  centralizar2: {
    height: "200px",
    marginTop: "8%",
    display: "flex",
    marginLeft: "15%",
    justifyContent: "center",
    flexDirection: "column",
    backgroundColor: "white",
    borderRadius: "10px",
    marginBottom: "91px"
  },
  informacoes: {
    marginTop: "10%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  textField: {
    color: "black",
    borderRadius: "5px",
    fontFamily: "'Montserrat', sans-serif",
    marginTop: "2%",
    marginLeft: "12%",
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
    background: "#bf4f39",
    borderRadius: "30px",
  },
  typography: {
    paddingTop: "13%",
    paddingLeft: "15%",
    fontWeight: "bold",
    fontSize: "40px",
    fontFamily: "'Montserrat', sans-serif",
  },
  typography2: {
    marginLeft: "10%",
    fontWeight: "bold",
    fontSize: "20px",
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
    height: "250px",
    marginLeft: "936px",
    marginTop: "-130px",
    zIndex: 1,
  },
  imagem: {
    boxSizing: "border-box",
    position: "absolute",
    width: "500px",
    height: "500px",
    marginLeft: "720px",
    marginTop: "-120px",
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
    marginLeft: "10%",
    borderRadius: "5px",
    marginBottom: "2%",
    marginTop: "2%",
    backgroundColor: "white",
    width: "252px",
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
  botao: {
    marginTop: "10px",
    marginBottom: "6%",
    fontFamily: "'Montserrat', sans-serif",
    fontWeight: "bold",
    color: "black",
    marginLeft: "5%",
    height: "58px",
    backgroundColor: "#FF862F",
    width: "160px",
    "&:hover": {
        fontFamily: "'Montserrat', sans-serif",
        backgroundColor: "#FF862F",
        color: "white",
        fontWeight: "bolder",
    },
},
});

export default useStyles;

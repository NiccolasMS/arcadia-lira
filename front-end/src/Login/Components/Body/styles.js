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
    marginBottom: "3%",
    marginTop: "3%",
    backgroundColor: "white",
    width: "500px",
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
});

export default useStyles;
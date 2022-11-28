import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginBottom: "14%",
    marginLeft: "auto",
    marginRight: "3%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  espacamento: {
    marginBottom: "5%",
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
});

export default useStyles;

import * as React from "react";

const useStyles = () => ({
  centralizar: {
    marginTop: "10%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
  },
  typography: {
    paddingLeft: "7%",
    marginTop: "20%",
    marginBottom: "5%",
    fontWeight: "bold",
    fontSize: "30px",
    fontFamily: "'Montserrat', sans-serif",
    zIndex: 10,
  },
  fundo: {
    position: "absolute",
    width: "1310px",
    height: "1500px",
    top: "1300px",
    background: "linear-gradient(180deg, #00A089 25%, #FF862F 100%)",
    borderRadius: "250px 250px 0px 0px",
  },
});

export default useStyles;

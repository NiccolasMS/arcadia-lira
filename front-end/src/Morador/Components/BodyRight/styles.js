import * as React from "react";

const useStyles = () => ({
  h1: {
    fontFamily: "'Montserrat', sans-serif",
    marginBottom: "4%",
  },
  typography: {
    fontFamily: "'Montserrat', sans-serif",
  },
  typography2:{
    fontFamily: "'Montserrat', sans-serif",
    width: "100%",
    textAlign: "center",
    marginBottom: "90%",
  },
  container:{
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    flexDirection: "column",
    border: "2px solid #00A089",
    borderTopColor: "#FFFFFF",
    borderLeftColor: "#FF862F",
    borderRightColor: "#FFFFFF",
    borderBottomColor: "#FFFFFF",
    backgroundColor: "#FAFAFA",
    width: "30%",
    height: "100vh",
  },
  circle:{
    width: "150px",
    height: "150px",
    backgroundColor:"#FFFFFF",
    borderRadius: "50%",
    marginBottom: "5%",
  }
});

export default useStyles;

import * as React from "react";

const useStyles = () => ({
    botao: {
        marginTop: "10px",
        marginBottom: "6%",
        fontFamily: "'Montserrat', sans-serif",
        fontWeight: "bold",
        color: "black",
        backgroundColor: "#FF862F",
        width: "500px",
        "&:hover": {
            fontFamily: "'Montserrat', sans-serif",
            backgroundColor: "#FF862F",
            color: "black",
            fontWeight: "bolder",
        },
    },
});

export default useStyles;

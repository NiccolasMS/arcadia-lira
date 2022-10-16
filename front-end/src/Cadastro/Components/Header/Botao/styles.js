import * as React from "react";

const useStyles = () => ({
    margem: {
        marginTop: "35px",
        marginRight: "35px",
    },
    botao: {
        fontFamily: "'Montserrat', sans-serif",
        color: "black",
        fontWeight: "bold",
        backgroundColor: "#FF862F",
        width: "120px",
        "&:hover": {
            fontFamily: "'Montserrat', sans-serif",
            backgroundColor: "#FF862F",
            color: "black",
            fontWeight: "bolder",
        },
        textTransform: "none",
    },
});

export default useStyles;
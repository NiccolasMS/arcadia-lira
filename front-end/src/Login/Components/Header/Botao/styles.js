import * as React from "react";

const useStyles = () => ({
    margem: {
        marginTop: "35px",
        marginRight: "35px",
    },
    botao: {
        fontFamily: "'Montserrat', sans-serif",
        fontWeight: "bold",
        color: "white",
        backgroundColor: "#00A089",
        width: "120px",
        "&:hover": {
            backgroundColor: "#00A089",
            color: "white",
            fontWeight: "bolder",
        },
        textTransform: "none",
    },
});

export default useStyles;
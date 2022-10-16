import * as React from "react";

const useStyles = () => ({
    botao: {
        marginTop: "10px",
        marginBottom: "6%",
        fontFamily: "'Montserrat', sans-serif",
        fontWeight: "bold",
        color: "white",
        backgroundColor: "#00A089",
        width: "500px",
        "&:hover": {
            fontFamily: "'Montserrat', sans-serif",
            backgroundColor: "#00A089",
            color: "white",
            fontWeight: "bolder",
        },
    },
});

export default useStyles;

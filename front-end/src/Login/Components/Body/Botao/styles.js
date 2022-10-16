import * as React from "react";

const useStyles = () => ({
    botao: {
        marginTop: "10px",
        marginBottom: "6%",
        fontFamily: "'Montserrat', sans-serif",
        color: "white",
        backgroundColor: "#00A089",
        width: "500px",
        "&:hover": {
            backgroundColor: "#00A089",
            color: "white",
        },
    },
});

export default useStyles;

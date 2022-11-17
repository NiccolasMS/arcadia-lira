import * as React from "react";

const useStyles = () => ({
    margem: {
        marginTop: "50px",
        marginRight: "35px",
        alignItems: "center",
        justifyContent: "space-between"
    },
    botaoLogin: {
        marginRight: "15px",
        marginLeft: "15px",
        fontFamily: "'Montserrat', sans-serif",
        color: "white",
        fontWeight: "bold",
        backgroundColor: "#00A089",
        width: "120px",
        "&:hover": {
            fontFamily: "'Montserrat', sans-serif",
            backgroundColor: "#00A089",
            color: "black",
            fontWeight: "bolder",
        },
        textTransform: "none",
    },
    botaoCadastro: {
        marginRight: "15px",
        marginLeft: "15px",
        fontFamily: "'Montserrat', sans-serif",
        color: "white",
        fontWeight: "bold",
        backgroundColor: "#00A089",
        width: "120px",
        "&:hover": {
            fontFamily: "'Montserrat', sans-serif",
            backgroundColor: "#00A089",
            color: "black",
            fontWeight: "bolder",
        },
        textTransform: "none",
    },
});

export default useStyles;
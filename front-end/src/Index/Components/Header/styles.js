import * as React from "react";

const useStyles = () => ({
    header: {
        width: "100%",
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-between",
        zIndex: 10 
    },
    box: {
        width: "100%",
        display: "flex",
    },
    container: {
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
    }
});

export default useStyles;
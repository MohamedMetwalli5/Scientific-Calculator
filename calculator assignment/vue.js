const app = Vue.createApp({
    data() {
        return {
            header: "Scientific Calculator",
            display: "",
            x: 0,
            y: 0,
            operator: "",

        };
    },

    methods: {
        //////////////////////////////////////////////////////////////////////////////////////////////////////        
        inverse: function () {
            axios
                .get("http://localhost:8080/inverse", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    if (response.data == "Can't divide over zero") {
                        this.x = 0
                        this.display = ""
                        this.y = 0
                        alert("Can't divide by zero");
                    } else {
                        this.display = response.data.toString();
                    }
                })
                .catch(error => {
                    console.log(error);
                });
        },

        signinverter: function () {
            axios
                .get("http://localhost:8080/signinverter", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.display = response.data.toString();
                })
                .catch(error => {
                    console.log(error);
                });
        },

        squareroot: function () {
            axios
                .get("http://localhost:8080/squareroot", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    if (response.data == "Can't have square root of negative") {
                        this.x = 0
                        this.display = ""
                        this.y = 0
                        alert("Can't have a square root of a negative number")
                    } else {
                        this.display = response.data.toString();
                    }
                })
                .catch(error => {
                    console.log(error);
                });
        },

        square: function () {
            axios
                .get("http://localhost:8080/square", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.display = response.data.toString();
                })
                .catch(error => {
                    console.log(error);
                });
        },

        percent: function () {
            axios
                .get("http://localhost:8080/percent", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.display = response.data.toString();
                })
                .catch(error => {
                    console.log(error);
                });
        },

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        add: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "+"
            this.display = ""
        },


        subtract: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "-"
            if (this.display.length == 0) {
                this.display = "-";
                this.x = this.display //////
            } else {
                this.display = "";
            }
        },

        multiply: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "*"
            this.display = ""
        },

        divide: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "/"
            this.display = ""
        },


        equal: function () {

            if (this.operator == "+") {
                axios
                    .get("http://localhost:8080/add", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.display = response.data.toString();
                    })
                    .catch(error => {
                        console.log(error);
                    });


            } else if (this.operator == "-") {
                axios
                    .get("http://localhost:8080/subtract", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.display = response.data.toString();
                    })
                    .catch(error => {
                        console.log(error);
                    });


            } else if (this.operator == "/") {
                axios
                    .get("http://localhost:8080/divide", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        if (response.data == "Can't divide over zero") {
                            this.x = 0
                            this.display = ""
                            this.y = 0
                            alert("Can't divide by zero")
                        } else {
                            this.display = response.data.toString();
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });


            } else if (this.operator == "*") {
                axios
                    .get("http://localhost:8080/multiply", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.display = response.data.toString();
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
            this.operator = ""
            //alert("equal");
        },

        deleteOneChar: function () {
            this.display = this.display.substring(0, this.display.length - 1);
        }



    }


});

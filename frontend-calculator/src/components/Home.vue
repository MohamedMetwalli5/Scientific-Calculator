<template>
    <div id="Home-class">
        <h1 class="big-title">{{ header }}</h1>

        <div>
            <h1 id="screen">{{ display }}</h1>
        </div>
        <div class="calculator-body">
            <div class="calculator-keys">
                <button type="" class="num" @click="percent">%</button>
                <button type="button" class="all-clear" @click="this.display = ''">CE</button>
                <button type="button" class="all-clear" value="" @click="this.display = ''">C</button>
                <button type="button" class="delete" @click="deleteOneChar"></button>
                <button type="button" @click="inverse">1/x</button>
                <button type="button" @click="square">x<sup>2</sup></button>
                <button type="button" @click="squareroot">&radic;</button>
                <button type="button" @click="divide">&divide;</button>
                <button type="button" @click="this.display += '7'">7</button>
                <button type="button" @click="this.display += '8'">8</button>
                <button type="button" @click="this.display += '9'">9</button>
                <button type="button" @click="multiply">*</button>
                <button type="button" @click="this.display += '4'">4</button>
                <button type="button" @click="this.display += '5'">5</button>
                <button type="button" @click="this.display += '6'">6</button>
                <button type="button" @click="subtract">&minus;</button>
                <button type="button" @click="this.display += '1'">1</button>
                <button type="button" @click="this.display += '2'">2</button>
                <button type="button" @click="this.display += '3'">3</button>
                <button type="button" @click="add">&plus;</button>
                <button type="button" @click="signinverter">+/-</button>
                <button type="button" @click="this.display += '0'">0</button>
                <button type="button" @click="this.display += '.'">.</button>
                <button type="button" class="equal-sign" @click="equal">=</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Home',
  data: {
    display: ''
  },
    methods: {     
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
                this.x = this.display 
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

}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap");

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, caption {
    margin: 0;
    padding: 0;
    border: 0;
    outline: 0;
    font-size: 100%;
    vertical-align: baseline;
    background: transparent;
}

#Home-class{  
  height: 94vh;
  background-image: linear-gradient(100deg, #feff24, #d87771);
  margin: 0;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
}

.calculator-body {
  border: 1px solid rgb(69, 156, 238);
  background: cyan;
  background-image: linear-gradient(100deg, cyan, #d3e4c3);
  border-radius: 20px;
  top: 60%;
  left: 50%;
  position: absolute;
  transform: translate(-50%, -50%);
  width: 420px;
}
.big-title {
  margin: auto;
  margin-top: 20px;
  margin-bottom: 50px;
  margin-left: center;
  margin-right: center;
  color: #2d8a02;
  font-size: 40px;
}

.calculator-keys {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 20px;
  padding: 20px;
}

button {
  height: 60px;
  background-color: #fff;
  border-radius: 15px;
  border: 2px solid #66d2e0;
  background-color: transparent;
  font-size: 2rem;
  color: rgb(37, 36, 36);
}

button:hover {
  background-color: #71cef3;
}

.operator {
  color: #337cac;
}

.all-clear {
  background-color: #ff1a22;
  border-color: #ff1a22;
  color: rgb(0, 0, 0);
}

.all-clear:hover {
  background-color: #f17377;
}

.equal-sign {
  background-color: #4297cf;
}
.equal-sign:hover {
  background-color: #74aed4;
}

.delete {
  background-image: url("../assets/delete.png");
  background-size: cover;
  background-color: #4cd6bf;
  background-position: center;
}
#screen {
  color: white;
  background-color: black;
  border-radius: 10px;
  margin-bottom: 10px;
  height: 50px; 
  width: 420px;
  top: 22%;
  left: 50%;
  position: absolute;
  transform: translate(-50%, -50%);
  text-align: right;
}
</style>

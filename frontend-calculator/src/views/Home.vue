<template>
    <div id="Home-class">
        <h1 id="page-title">{{ pageTitle }}</h1>
        <div id="screen">
            <h1>{{ display }}</h1>
        </div>
        <div id="calculator-body">
            <div class="calculator-keys">
                <button type="button" class="scientific-function" @click="sin()">sin</button>
                <button type="button" class="scientific-function" @click="cos()">cos</button>
                <button type="button" class="scientific-function" @click="tan()">tan</button>
                <button type="button" @click="UpdateDisplay('7')">7</button>
                <button type="button" @click="UpdateDisplay('8')">8</button>
                <button type="button" @click="UpdateDisplay('9')">9</button>
                <button type="button" class="scientific-operation" @click="abs()">abs</button>
                <button type="button" class="scientific-operation" @click="pi()">π</button>
                <button type="button" class="scientific-operation" @click="e('')">e</button>        
                <button type="button" class="scientific-function" @click="sinInverse()" data-superscript="-1">sin</button>
                <button type="button" class="scientific-function" @click="cosInverse()" data-superscript="-1">cos</button>
                <button type="button" class="scientific-function" @click="tanInverse()" data-superscript="-1">tan</button>
                <button type="button" @click="UpdateDisplay('4')">4</button>
                <button type="button" @click="UpdateDisplay('5')">5</button>
                <button type="button" @click="UpdateDisplay('6')">6</button>
                <button type="" class="scientific-operation" @click="percent">%</button>
                <button type="button" class="scientific-operation" @click="add()">&plus;</button>
                <button type="button" class="scientific-operation" @click="subtract()">&minus;</button>
                <button type="button" class="scientific-function" @click="exponent()" data-superscript="y">X</button>
                
                <button type="button" class="scientific-function" @click="inverse()">1/x</button>
                <button type="button" class="scientific-function" @click="square()" data-superscript="2">X</button>
                <button type="button" @click="UpdateDisplay('1')">1</button>
                <button type="button" @click="UpdateDisplay('2')">2</button>
                <button type="button" @click="UpdateDisplay('3')">3</button>
                <button type="button" class="scientific-operation" @click="multiply()">*</button>
                <button type="button" class="scientific-operation" @click="divide()">&divide;</button>
                <button type="button" class="scientific-operation" @click="squareroot()">&radic;</button>
                <button type="button" class="scientific-function" @click="ln()">ln</button>
                <button type="button" class="scientific-function" @click="nPr()">nPr</button>
                <button type="button" class="scientific-function" @click="nCr()">nCr</button>
                <button type="button" @click="UpdateDisplay('0')">0</button>
                <button type="button" @click="UpdateDisplay('.')">.</button>
                <button type="button" @click="signinverter()">+/-</button>
                <button type="button" id="delete" @click="deleteOneChar()"></button>
                <button type="button" class="all-clear" value="" @click="UpdateDisplay('')">C</button>                
                <button type="button" id="equal-sign" @click="equal()">=</button>
            </div>
    </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Home',
  data: function(){
      return {
        display: "",
        operator: "",
        pageTitle: "Scientific Calculator",
      };
  },
    methods: {     
       
       // Note : The port number of the Backend is 8082

       UpdateDisplay: function(NewValue){
            if(NewValue === ''){
                this.display = "";
            }else{
                this.display += NewValue;
            }
       },

       sin: function () {
            axios
                .get("http://localhost:8082/sin", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        cos: function () {
            axios
                .get("http://localhost:8082/cos", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        tan: function () {
            axios
                .get("http://localhost:8082/tan", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        sinInverse: function () {
            axios
                .get("http://localhost:8082/sininverse", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        cosInverse: function () {
            axios
                .get("http://localhost:8082/cosinverse", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        tanInverse: function () {
            axios
                .get("http://localhost:8082/taninverse", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        ln: function () {
            axios
                .get("http://localhost:8082/ln", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        abs: function () {
            axios
                .get("http://localhost:8082/abs", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },
        
        exponent: function () {
            if (this.operator.length == 1) {
                return;
            }
            this.x = this.display
            this.operator = "x"
            this.UpdateDisplay('');
        },

        nPr: function () {
            if (this.operator.length == 1 && this.display[0] != "-" && this.display[0] != "+") {
                return;
            }
            this.x = this.display
            this.operator = "p"
            this.UpdateDisplay('');
        },

        nCr: function () {
            if (this.operator.length == 1 && this.display[0] != "-" && this.display[0] != "+") {
                return;
            }
            this.x = this.display
            this.operator = "c"
            this.UpdateDisplay('');
        },

        inverse: function () {
            axios
                .get("http://localhost:8082/inverse", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    if (response.data == "Can't divide over zero") {
                        this.x = 0
                        this.UpdateDisplay('');
                        this.y = 0
                        alert("Can't divide by zero");
                    } else {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    }
                })
                .catch(error => {
                    console.log(error);
                });
        },

        signinverter: function () {
            axios
                .get("http://localhost:8082/signinverter", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        squareroot: function () {
            axios
                .get("http://localhost:8082/squareroot", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    if (response.data == "Can't have square root of negative") {
                        this.x = 0
                        this.UpdateDisplay('');
                        this.y = 0
                        alert("Can't have a square root of a negative number")
                    } else {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    }
                })
                .catch(error => {
                    console.log(error);
                });
        },

        square: function () {
            axios
                .get("http://localhost:8082/square", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        percent: function () {
            axios
                .get("http://localhost:8082/percent", {
                    params: {
                        data: Number(this.display),
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
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
            this.UpdateDisplay('');
        },

        subtract: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "-"
            if (this.display.length == 0) {
                this.UpdateDisplay("");
                this.UpdateDisplay("-");
                this.x = this.display 
            } else {
                 this.UpdateDisplay('');
            }
        },

        multiply: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "*"
            this.UpdateDisplay('');
        },

        divide: function () {
            if (this.operator.length == 1 && this.display[0] != "-") {
                return;
            }
            this.x = this.display
            this.operator = "/"
            this.UpdateDisplay('');
        },

        pi: function () {
            axios
                .get("http://localhost:8082/pi", {
                    params: {
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        e: function () {
            axios
                .get("http://localhost:8082/e", {
                    params: {
                    },
                })
                .then((response) => {
                    this.UpdateDisplay("");
                    this.UpdateDisplay(response.data.toString());
                })
                .catch(error => {
                    console.log(error);
                });
        },

        equal: function () {
            if (this.operator == "+") {
                axios
                    .get("http://localhost:8082/add", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });

            } else if (this.operator == "-") {
                axios
                    .get("http://localhost:8082/subtract", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });


            } else if (this.operator == "/") {
                axios
                    .get("http://localhost:8082/divide", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        if (response.data == "Can't divide over zero") {
                            this.x = 0
                            this.UpdateDisplay('');
                            this.y = 0
                            alert("Can't divide by zero")
                        } else {
                            this.UpdateDisplay("");
                            this.UpdateDisplay(response.data.toString());
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });


            } else if (this.operator == "*") {
                axios
                    .get("http://localhost:8082/multiply", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });
            } else if (this.operator == "x") {
                axios
                    .get("http://localhost:8082/exponent", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });
            } else if (this.operator == "p") {
                axios
                    .get("http://localhost:8082/npr", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });
            } else if (this.operator == "c") {
                axios
                    .get("http://localhost:8082/ncr", {
                        params: {
                            x: Number(this.x),
                            y: Number(this.display)
                        },
                    })
                    .then((response) => {
                        this.UpdateDisplay("");
                        this.UpdateDisplay(response.data.toString());
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
            
            this.operator = ""
            //alert("equal");
        },


        deleteOneChar: function () {
            this.UpdateDisplay("");
            this.UpdateDisplay(this.display.substring(0, this.display.length - 1));
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
  height: 100vh;
  background-image: linear-gradient(100deg, #feff24, #d87771);
  margin: 0;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
}

#screen {
  color: white;
  background-color: black;
  border-radius: 10px;
  height: 60px; 
  width: 520px;
  top: 22%;
  left: 50%;
  padding: 0 10px;
  font-size: 35px;
  position: fixed;
  transform: translate(-50%, -50%);
  text-align: right;
}

#calculator-body {
  border: 1px solid rgb(69, 156, 238);
  background: cyan;
  background-image: linear-gradient(100deg, cyan, #d3e4c3);
  border-radius: 20px;
  top: calc(60% + 20px);
  left: 50%;
  position: fixed;
  transform: translate(-50%, -50%);
  width: 980px;
}
#page-title {
  margin: auto;
  margin-bottom: 10px;
  color: #ffffff;
  font-size: 40px;
  border:solid;
  border-radius: 20px;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-top: #feff24;
  padding: 10px;
  background-color: #32c25e;
}

.calculator-keys {
  display: grid;
  grid-template-columns: repeat(9, 1fr);
  grid-gap: 10px;
  padding: 10px;
}

button {
  height: 60px;
  border-radius: 15px;
  border: 2px solid #66d2e0;
  background-color: transparent;
  font-size: 2rem;
  color: rgb(37, 36, 36);
}

button:hover {
  background-color: #71cef3;
  cursor: pointer;
}

button::after {
    content: attr(data-superscript);
    vertical-align: super;
}

.operator {
  color: #337cac;
}

.all-clear {
  background-color: rgb(245, 70, 70);
  color: rgb(0, 0, 0);
}

.all-clear:hover {
  background-color: #9f131c;
}

.scientific-function {
  background-color: #FF7F3F;
}
.scientific-function:hover {
  background-color: #3689c0;
}

.scientific-operation{
  background-color: #F94892;
}

#equal-sign {
  background-color: #119cf9;
}
#equal-sign:hover {
  background-color: #3689c0;
}

#delete {
  background-image: url("../assets/delete.png");
  background-size: cover;
  background-color: #4cd6bf;
  background-position: center;
}

</style>

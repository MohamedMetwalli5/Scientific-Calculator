<template>
<div class="animate">
    <svg stroke="#6f5afd">
        <path d="M 59.27 41.17 h 0 a 1 1 0 0 0 -0.25 -0.79 a 0.91 0.91 0 0 0 -1.02 -0.38 h -2 a 1 1 0 0 0 -0.9 0.8 c -1 3.68 -2.73 6.08 -5 6.76 c -1.31 0.4 -3.4 0.4 -5.89 -1.83 l -0.13 -0.12 c -0.76 -0.82 -1.29 -2.45 -1.61 -5.16 c -0.56 -4.85 -0.43 -13.17 0.34 -26.54 c 0.06 -1 0.11 -1.87 0.14 -2.48 l 0.09 -1.85 l 9.34 -0.22 A 4.47 4.47 0 0 0 54 0.5 l -33.72 0.78 C 6.4 1.6 3.49 6.73 0.54 17.55 a 1.2 1.2 0 0 0 0.46 1.45 a 1.18 1.18 0 0 0 1 -0.61 c 3.37 -6.07 5.56 -7.88 13.55 -8.14 l 2.2 -0.07 l -0.14 2.19 c -0.61 9.88 -1.53 18.43 -6.17 27.23 a 48.72 48.72 0 0 1 -3.35 5.49 C 6.16 49 5.33 52.42 6.48 54.85 A 5.89 5.89 0 0 0 11.54 58 a 7.25 7.25 0 0 0 6.66 -3.11 c 0.83 -1.2 1.75 -3.46 2.62 -7.54 C 22.18 41 23.42 30.21 24 12 l 0.07 -1.89 L 36.5 9.84 L 36.34 12 c -0.75 10.57 -1.52 21.8 -1.89 32.62 a 14.29 14.29 0 0 0 0.26 3 a 11.53 11.53 0 0 0 10.56 9.55 C 50.81 57.56 57.8 53.58 59.27 41.17 Z"/>
    </svg>
</div>

</template>

<script>
export default {
  name: 'PI',
  data: function(){
    return {
    };
  },
}
</script>

<style scoped>
    .animate{
        height: 50vh;
        width: 50vw;
    }
    svg{
        position: relative;
        top: 35%;
        left: 95%;
        stroke-width: 3px;
        stroke-dasharray: 0;
        stroke-dashoffset: 10;
        animation: dash 5s infinite both;
    }
    
    @keyframes dash{
        to{
            stroke-dashoffset: 2;
            stroke-dasharray: 200;
        }
    }

</style>

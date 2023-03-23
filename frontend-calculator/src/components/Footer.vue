<template>
    <div id="container">
        <div id="contact">
            <p>Email : {{ mail }}</p>
        </div>
    </div>
</template>


<script>
export default {
  name: 'Footer',
  data: function(){
    return {
        mail:"mohamedmetwalli5@gmail.com",
    };
  },
}
</script>
    
<style scoped>
    #container{
      padding:10px;
      margin-top:10px;
      width:100%;
      color:white;
      background-color:#0e0255;
      display:flex;
      flex-direction:column;
      align-items:center;
      position: fixed;
      bottom: 0;
    }
    
</style>
    
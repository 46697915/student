<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->
    <router-view/>

  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style scope>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  align:"center";
  padding: 0px;
  margin:-8px;
}
</style>

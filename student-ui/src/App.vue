<template>
  <div id="app">
    <!--<img alt="Vue logo" src="./assets/logo.png">-->
    <index></index>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import index from './components/index.vue'

export default {
  name: 'app',
  components: {
//    HelloWorld
    index
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

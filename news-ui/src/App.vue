<template>
  <div class="content">
    <router-view/>
  </div>
</template>

<script lang="ts">
import {Vue} from 'vue-class-component';
import {NButton} from 'naive-ui'
import NewsList from "@/components/NewsList.vue";
import NewsDetail from "@/components/NewsDetail.vue";

export default class App extends Vue {
}


</script>

<style>
a {
  text-decoration: none;
}

#app {
  margin: 10px;
}
</style>

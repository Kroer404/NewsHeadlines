<template>
  <!--<n-button>n-button</n-button>-->
  <news-list></news-list>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';
import {NButton} from 'naive-ui'
import NewsList from "@/components/NewsList.vue";

@Options({
  components: {
    NewsList,
    NButton,
  },
})
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

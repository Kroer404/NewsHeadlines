<script lang="ts">
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent} from 'vue'
import {Vue} from "vue-class-component";
import NewsEdit from "@/page/News/NewsEdit.vue";

export default defineComponent({
  name:"UserIndex",
  components: {
    NewsEdit,
    HeadBar,
  },
})

</script>

<template>
  <head-bar></head-bar>
  <news-edit></news-edit>
</template>

<style scoped>

</style>
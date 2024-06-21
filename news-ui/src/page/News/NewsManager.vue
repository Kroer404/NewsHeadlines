<script lang="ts">
import {Editor, Toolbar} from '@wangeditor/editor-for-vue'
import NewsCreate from "@/components/News/NewsCreate.vue";
import NewsChoose from "@/components/News/NewsChoose.vue";


export default {
  components: {NewsChoose, NewsCreate},


}
</script>

<template>
  <news-create></news-create>
  <news-choose></news-choose>
</template>

<style scoped>

</style>
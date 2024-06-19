<script lang="ts">
import {defineComponent} from "vue";
import {News} from "@/news";
import axios from "axios";

export default defineComponent({
  data() {
    return {
      newsListUrl: "/api/news",
      newsData: [] as News[],
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    getData() {
      axios
          .get<News[]>(this.newsListUrl)
          .then((response) => {
            this.newsData = response.data;
            console.log("获取到的新闻列表是：", this.newsData)
          })
          .catch((err) => console.log(err));
    },
  },
});
</script>

<template>
  <div class="side-bar-background">
    <a-list bordered size="small">
      <template>
        <a-list-item v-for="item in newsData" :key="item.title">
          <template v-if="item.title"> {{ item.title }}</template>

        </a-list-item>
      </template>
      <template #header>
        <div>热点追踪</div>
      </template>
      <template #footer>
        <div></div>
      </template>
    </a-list>
  </div>

</template>

<style scoped>

</style>
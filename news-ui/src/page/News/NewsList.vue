<script lang="ts">
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent} from 'vue'
import axios from "axios";
import {News} from "@/news";
import SideBar from "@/components/Public/SideBar.vue";


export default defineComponent({
  components: {
    SideBar,
    HeadBar,
  },
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
          })
          .catch((err) => console.log(err));
    },
  },
});
</script>

<template>
  <head-bar></head-bar>
  <div class="news-list-page-background">
    <div class="news-list-page">
      <div class="sidebar">
        <side-bar></side-bar>
      </div>
      <div class="news-list">
        <a-list item-layout="horizontal">
          <a-list-item v-for="item in newsData" :key="item.title">
            <a-list-item-meta description="这里是小标题">
              <template #title>
                <router-link :to="'/news/'+item.newsId">{{ item.title }}</router-link>
              </template>
              <template #avatar>
                <a-avatar src="/img/logo.png"/>
              </template>
            </a-list-item-meta>
          </a-list-item>
        </a-list>
      </div>
    </div>
  </div>

</template>

<style scoped>
.news-list-page {
  display: flex;
  width: 80%;
  margin: auto;
}

.sidebar {
  flex: 0 0 20%;
}

.news-list {
  flex: 0 0 66.67%;
}
</style>
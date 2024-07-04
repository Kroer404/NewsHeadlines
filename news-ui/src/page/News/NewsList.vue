<script lang="ts">
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent} from 'vue'
import axios from "axios";
import {News} from "@/news";
import SideBar from "@/components/Public/SideBar.vue";
import ButtomBar from "@/components/Public/ButtomBar.vue";


export default defineComponent({
  components: {
    ButtomBar,
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
    <h3 class="title-text">热点新闻</h3>
    <a-divider style="height: 1px; background-color: black" />
    <div class="news-list-page">
      <div class="sidebar">
        <side-bar></side-bar>
      </div>
      <div class="news-list">

        <a-list item-layout="horizontal">
          <div class="carousel">
            <a-carousel autoplay>
              <div>
                <router-link to="/news/35">
                  <img src="/img/1.jpg">
                  <h3>ttttt</h3>
                </router-link>
              </div>
              <div>
                <router-link to="/news/36">
                  <img src="/img/2.jpg">
                  <h3>ttttt</h3>
                </router-link>
              </div>
              <div>
                <router-link to="/news/37">
                  <img src="/img/3.jpg">
                  <h3>ttttt</h3>
                </router-link>
              </div>
              <div>
                <router-link to="/news/38">
                  <img src="/img/4.jpg">
                  <h3>ttttt</h3>
                </router-link>
              </div>
            </a-carousel>
          </div>
          <a-list-item v-for="item in newsData" :key="item.title">
            <a-list-item-meta>
              <template #title>
                <router-link :to="'/news/'+item.newsId">{{ item.title }}</router-link>
              </template>
              <template #avatar>
                <a-avatar src="/img/logo.png"/>
              </template>
              <template #description>
                {{ item.creation }}
              </template>
            </a-list-item-meta>
          </a-list-item>
        </a-list>
      </div>
    </div>
  </div>
  <buttom-bar></buttom-bar>
</template>

<style scoped>
.news-list-page {
  display: flex;
  width: 80%;
  margin: auto;
}

.news-list-page-background {


}

.sidebar {
  flex: 0 0 20%;
}

.news-list {
  flex: 0 0 66.67%;
}

/* For demo */
:deep(.slick-slide) {
  text-align: center;
  height: 300px;
  line-height: 100px;
  background: #364d79;
  overflow: hidden;
}

:deep(.slick-slide h3) {
  color: #fff;
}

.carousel {
  width: 600px;
  margin-left: 20px;
}

.title-text{
  text-align: left;
  margin-top: -10px;
  margin-bottom: 20px;
  margin-left: 20px;
  font-size: 30px;
  font-weight: bold;
  color: black;
}


</style>
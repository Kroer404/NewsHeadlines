<script lang="ts">
import {defineComponent} from 'vue'
import axios from "axios";
import {News} from "@/news";


export default defineComponent({
  components: {},
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

    // 删除新闻事件
    deleteNews(newsId: string) {
      // 打包请求
      let options = {
        url: `/api/news/${newsId}`,
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }

      // 发送请求到后端接口
      axios(options).then((res: any) => {
        console.log("删除的新闻是：", newsId)
        console.log(options)
        console.log(res);
        this.getData();
      })
    },
    editNews(newsId: string) {
      this.$router.push({name: 'NewsEdit', params: {newsId: newsId}});
    }
  },
});
</script>

<template>
  <div class="news-list-page-background">
    <div class="news-list-page">
      <div class="news-list">
        <a-list item-layout="horizontal">
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
            <a-button danger @click="deleteNews(item.newsId)">删除</a-button>
            <div style="width: 10px"></div>
            <a-button type="primary" @click="editNews(item.newsId)">编辑</a-button>
          </a-list-item>
        </a-list>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
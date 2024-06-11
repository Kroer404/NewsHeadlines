<script lang="ts">
import {Options, Vue} from "vue-class-component"
import {NList, NListItem} from 'naive-ui'
import axios from "axios";

import {News} from "@/news";

@Options({
  components: {
    NList,
    NListItem,
  },
})

export default class NewsList extends Vue {
  private newsListUrl: string = "/api/news";
  private newsData: News[] = [];


  mounted() {
    this.getData();

  }

  getData() {
    axios
        .get<News[]>(this.newsListUrl)
        .then((response) => {
          this.newsData = response.data;
        })
        .catch((err) => console.log(err));
  }
}

</script>

<template>
  <n-button>
    <router-link :to="'/login'">Login</router-link>
  </n-button>
  <div>
    <router-link :to="'/admin'">试试访问权限接口</router-link>
  </div>
  <n-list>
    <!--这里可以正常获取列表，报错原因未知-->
    <n-list-item v-for="item in newsData" :key="item.title">
      <div>
        <router-link :to="'/news/'+item.newsId">{{ item.title }}</router-link>
      </div>
    </n-list-item>
  </n-list>
</template>

<style scoped>

</style>
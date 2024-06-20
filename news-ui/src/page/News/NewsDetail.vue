<script lang="ts">
import {Options, Vue} from "vue-class-component"
import {NButton, NCard} from 'naive-ui'
import {News} from "@/news";
import axios from "axios";
import MdEditor from 'md-editor-v3';
import HeadBar from "/src/components/Public/HeadBar.vue";

@Options({
  components: {
    HeadBar,
    NButton,
    NCard,
    MdEditor,
  },
})

export default class NewsDetail extends Vue {

  //初始化详情页数据
  public newsDetailResult: News = new News("", "", new Date());

  //详情页接口地址
  private newsApiUrl: string = "/api/news/";

  //初始化详情主键
  private newsId: string = ""

  mounted() {
    this.getData();
  }

  getData() {
    // 路由参数不是直接在 $router 对象上，而是在 $route 对象的 params 属性中
    this.newsId = this.$route.params.id.toString();
    console.log("获取到的id是：" + this.newsId)

    axios
        .get<News>(this.newsApiUrl + this.newsId)
        .then((response) => {
          this.newsDetailResult = response.data;
          console.log("获取到的新闻实体是：", this.newsDetailResult)
          console.log("获取到的时间是：" + this.newsDetailResult.creation)
        })
        .catch((err) => console.log(err));
  }

  goBack() {
    this.$router.go(-1)
  }
}
</script>

<template>
  <head-bar></head-bar>
  <div class="news-detail">
    <div>
      <span>{{ newsDetailResult.title }}</span>
    </div>
    <a-card :bordered="false" embedded class="content">
      <!--问题：为什么如果是私有类不能在这里访问，即使是同文件下-->
      <p>发布时间：{{ newsDetailResult.creation }}</p>
      <div v-html="newsDetailResult.content"></div>
      <!--问题：组件已成功获取内容，但未正确显示-->
    </a-card>
  </div>
</template>

<style scoped>
.content{
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
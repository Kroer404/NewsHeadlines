<script lang="ts">
import {Options, Vue} from "vue-class-component"
import {NButton, NCard} from 'naive-ui'

@Options({
  components: {
    NButton,
    NCard,
  },
})

export default class NewsDetail extends Vue {
  goBack() {
    this.$router.go(-1)
  }
}
</script>

<template>
  <div class="news-detail">
    <n-button @click="goBack()">Back</n-button>
    <n-card :bordered="false" embedded title="111">
      <p>这里写的就应该是内容，现在写的是死数据，你再想想怎么调用他咯</p>
      <img alt="" src="https://pic2.zhimg.com/v2-c58eeefdc30415e904375d70d45c5209_b.jpg"/>

    </n-card>
  </div>
</template>

<style scoped>

</style>
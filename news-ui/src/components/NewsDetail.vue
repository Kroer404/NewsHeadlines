<script lang="ts">
import {Options, Vue} from "vue-class-component"
import {NButton, NCard} from 'naive-ui'
@Options({
  components: {
    NButton,
    NCard,
  }
})
export default class NewsDetail extends Vue {
}
</script>

<template>
  <div class="news-detail">
    <n-button>Back</n-button>
    <n-card title="111" embedded :bordered="false">
      <p>2022-02-10 11:00</p>
      <p>
        内容尼尔尼尔大学覅还是的风景
      </p>
      <p>
        sdjaiodjivjida
      </p>
      <img alt="" src="https://pic2.zhimg.com/v2-c58eeefdc30415e904375d70d45c5209_b.jpg"/>

    </n-card>
  </div>
</template>

<style scoped>

</style>
<script lang="ts">
import {Options, Vue} from "vue-class-component"
import {NList, NListItem} from 'naive-ui'

@Options({
  components: {
    components: {
      NList,
      NListItem,
    }
  },
})

export default class NewsList extends Vue {
  private newsData: any[] = [
    {id: "1", title: "取消新能源车限购、提高节能率……这样做好节能降碳"},
    {id: "2", title: "秸秆经纪人、智能化新农机 今年夏收有何不同？"},
    {id: "3", title: "瑞典将仅有两架预警机援乌 本国空中警戒能力大幅削弱"},
    {id: "4", title: "444"},
    {id: "5", title: "555"},
    {id: "6", title: "666"},
    {id: "7", title: "777"},
    {id: "8", title: "888"},
  ]

}
</script>

<template>
  <n-list>
    <n-list-item v-for="item in newsData" :key="item.title">
      <div>
        <router-link :to="'/news/'+item.id">{{ item.title }}</router-link>
      </div>
    </n-list-item>
  </n-list>
</template>

<style scoped>

</style>
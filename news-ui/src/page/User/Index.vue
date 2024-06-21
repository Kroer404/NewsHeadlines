<script lang="ts">
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent} from 'vue'
import {Vue} from "vue-class-component";
import NewsEdit from "@/page/News/NewsManager.vue";
import NewsManager from "@/page/News/NewsManager.vue";
import { HomeOutlined } from '@ant-design/icons-vue';
import { ref } from 'vue';

export default defineComponent({
  name:"UserIndex",
  components: {
    NewsManager,
    HeadBar,
  },
})
const tabList = [
  {
    key: 'tab1',
    tab: 'tab1',
  },
  {
    key: 'tab2',
    tab: 'tab2',
  },
];
const contentList = {
  tab1: 'content1',
  tab2: 'content2',
};
const tabListNoTitle = [
  {
    key: 'article',
    tab: 'article',
  },
  {
    key: 'app',
    tab: 'app',
  },
  {
    key: 'project',
    tab: 'project',
  },
];
const key = ref('tab1');
const noTitleKey = ref('app');

const onTabChange = (value: string, type: string) => {
  console.log(value, type);
  if (type === 'key') {
    key.value = value;
  } else if (type === 'noTitleKey') {
    noTitleKey.value = value;
  }
};

</script>

<template>
  <head-bar></head-bar>
  <news-manager></news-manager>
  <div class="index-content">
    <a-card
        style="width: 100%"
        :tab-list="tabListNoTitle"
        :active-tab-key="noTitleKey"
        @tabChange="key => onTabChange(key, 'noTitleKey')"
    >
      <p v-if="noTitleKey === 'article'">article content</p>
      <p v-else-if="noTitleKey === 'app'">app content</p>
      <p v-else>project content</p>
    </a-card>
  </div>

</template>

<style scoped>

</style>
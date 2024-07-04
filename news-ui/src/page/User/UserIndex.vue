<script lang="ts" setup>
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent, reactive, watch, h, ref} from 'vue'
import {UserOutlined, LaptopOutlined, NotificationOutlined} from '@ant-design/icons-vue';
import UserInfo from '/src/page/User/UserInfo.vue'
import NewsCreate from "/src/components/News/NewsCreate.vue";
import NewsChoose from "@/components/News/NewsChoose.vue";

const selectedKeys1 = ref<string[]>(['2']);
const selectedKeys2 = ref<string[]>(['1']);
const openKeys = ref<string[]>(['sub1']);
const componentName = ref('UserInfo') // 默认加载的组件

const components = {
  UserInfo,
  NewsCreate,
  NewsChoose
}

// const handleMenuSelect = (key: any) => {
//   switch (key) {
//     case '1':
//       componentName.value = 'UserInfo'
//       break
//     case '2':
//       componentName.value = 'NewsCreate'
//       break
//     case '3':
//       componentName.value = 'NewsChoose'
//       break
//     default:
//       componentName.value = 'UserInfo'
//   }
//   console.log("现在的key值是",key)
//   console.log("现在应该显示的组件是", componentName.value)
// }


function toUserInfo() {
  componentName.value = 'UserInfo'
}

function toNewsCreate() {
  componentName.value = 'NewsCreate'
}

function toNewsChoose() {
  componentName.value = 'NewsChoose'
}


</script>

<template>
    <head-bar></head-bar>
  <div class="index-background">
    <div class="index-sidebar">
      <div style="width: 256px">
        <a-layout style="padding: 24px 0; background: #fff">
          <a-layout-sider style="background: #fff" width="200">
            <a-menu
                v-model:openKeys="openKeys"
                v-model:selectedKeys="selectedKeys2"
                mode="inline"
                style="height: 100%"
            >
              <a-menu-item key="1" @click="toUserInfo">
                <span>
                  <user-outlined/>
                </span>用户信息
              </a-menu-item>
              <a-sub-menu key="sub1">
                <template #title>
                <span>
                  <laptop-outlined/>
                  编辑系统
                </span>
                </template>
                <a-menu-item key="2" @click="toNewsCreate">新增新闻</a-menu-item>
                <a-menu-item key="3" @click="toNewsChoose">管理新闻</a-menu-item>
              </a-sub-menu>
            </a-menu>
          </a-layout-sider>
          <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
          </a-layout-content>
        </a-layout>
      </div>
    </div>
    <div class="index-content">
      <component :is="components[componentName]"></component>
    </div>
  </div>

</template>

<style scoped>
.index-background {
  display: flex;
  width: 80%;
  margin: auto;
}

.index-content {
  width: 66.67%;
}
</style>
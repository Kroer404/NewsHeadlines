<script lang="ts">
import '@wangeditor/editor/dist/css/style.css' // 引入 css
import {onBeforeUnmount, ref, shallowRef, onMounted} from 'vue'
import {useRouter} from 'vue-router'
import {Editor, Toolbar} from '@wangeditor/editor-for-vue'
import axios from 'axios'
import {News} from "@/news";


export default {
  components: {Editor, Toolbar},

  setup() {
    const title = ref<string>('');
    const router = useRouter()
    // 编辑器实例，必须用 shallowRef
    const editorRef = shallowRef()

    // 内容 HTML
    const valueHtml = ref('<p></p>')

    // 模拟 ajax 异步获取内容
    onMounted(() => {
      setTimeout(() => {
        valueHtml.value = '<p></p>'
      }, 1500)
    })

    const toolbarConfig = {}
    const editorConfig = {placeholder: '在这里开始编写新闻内容...'}

    // 组件销毁时，也及时销毁编辑器
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return
      editor.destroy()
    })

    const handleCreated = (editor: any) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }

    const submitContent = () => {
      console.log("title的值是：", title.value)
      const editor = editorRef.value
      let htmlContent = editor.getHtml()
      let posttitle = title.value
      if (editor == null) return

      // 获取当前时间并直接向后端提交
      let creation = new Date().toLocaleString("zh-CN", {timeZone: "Asia/Shanghai"}).slice(0, 19).replace('T', ' ');

      // 打包请求
      let options = {
        url: '/api/news/add',
        data: {
          title: posttitle,
          content: htmlContent,
          creation: creation
        },
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }

      // 发送请求到后端的/add接口
      axios(options).then((res: any) => {
        console.log("提交的标题是：", posttitle)
        console.log("提交的创建时间是：", creation)
        console.log("提交的内容是：", htmlContent)
        console.log(options)
        console.log(res);
      })


      // 重定向到编辑后的新闻
      router.push({name: 'NewsList'});

    }

    return {
      editorRef,
      valueHtml,
      mode: 'default', // 或 'simple'
      toolbarConfig,
      editorConfig,
      handleCreated,
      submitContent,
      title
    };
  },


}
</script>

<template>
  这里是编辑新闻模块
  <div class="edit-background">
    <div class="title-edit">
      <a-space direction="vertical">
        <!--a-input使用不不同于vue原本的方式绑定v-model-->
        <a-input v-model:value="title" placeholder="输入新闻标题"/>
      </a-space>
    </div>
    <div class="content-edit">
      <div style="border: 1px solid #ccc">
        <Toolbar
            :defaultConfig="toolbarConfig"
            :editor="editorRef"
            :mode="mode"
            style="border-bottom: 1px solid #ccc"
        />
        <Editor
            v-model="valueHtml"
            :defaultConfig="editorConfig"
            :mode="mode"
            style="height: 500px; overflow-y: hidden;"
            @onCreated="handleCreated"
        />
      </div>
    </div>
    <a-button type="primary" @click="submitContent">提交</a-button>
  </div>


</template>

<style scoped>

</style>
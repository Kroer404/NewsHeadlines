<script lang="ts">

</script>

<template>
  这里是编辑新闻模块
  <head-bar></head-bar>
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
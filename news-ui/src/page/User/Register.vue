<script lang="ts">
import HeadBar from "/src/components/Public/HeadBar.vue";
import {defineComponent} from 'vue'
import {Vue} from "vue-class-component";

export default defineComponent({
  name:"UserRegister",
  components: {
    HeadBar,
  },
})

</script>

<template>

  <div class="register-page">
    <head-bar></head-bar>
    <div class="register-form">
      <a-form>
        <a-form-item
            :rules="[{ required: true, message: 'Please input your username!' }]"
            label="用户名"
            name="username"
        >
          <a-input/>
        </a-form-item>

        <a-form-item
            :rules="[{ required: true, message: 'Please input your password!' }]"
            label="密码"
            name="password"
        >
          <a-input-password/>
        </a-form-item>

        <a-form-item
            :rules="[{ required: false, message: 'Please input your nickname!' }]"
            label="昵称"
            name="nickname"
        >
          <a-input/>
        </a-form-item>

        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button html-type="submit" type="primary">注册</a-button>
        </a-form-item>
      </a-form>
    </div></div>

</template>

<style scoped>
.register-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  background-color: #f2f2f2;
}

.register-form {
  width: 300px;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  justify-content: center;
}
</style>
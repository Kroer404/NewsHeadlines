<script lang="ts">
import axios from 'axios'
import {Options, Vue} from "vue-class-component";
import {NButton, NCard} from 'naive-ui'
import MdEditor from "md-editor-v3";
import HeadBar from "/src/components/Public/HeadBar.vue";

@Options({
  components: {
    HeadBar,
    NButton,
    NCard,
    MdEditor,
  },
})

export default class Login extends Vue {
  username: string = ''
  password: string = ''

  doLogin() {
    console.log("开始执行dologin")
    console.log("接收到的用户名是：", this.username)
    console.log("接收到的密码是：", this.password)
    let options = {
      url: '/api/login',
      data: {
        username: this.username,
        password: this.password,
      },
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    }
    axios(options).then((res: any) => {
      console.log(options)
      console.log(res);
    })
    return null;
  }


  goBack() {
    this.$router.go(-1)
  }
}


</script>

<template>
  <div class="login-page">
    <head-bar></head-bar>
    <div class="login-form">
      <a-form>
        <a-form-item
            :rules="[{ required: true, message: 'Please input your username!' }]"
            label="用户名"
            name="username"
        >
          <a-input v-model="username"/>
        </a-form-item>

        <a-form-item
            :rules="[{ required: true, message: 'Please input your password!' }]"
            label="密码"
            name="password"
        >
          <a-input-password v-model="password"/>
        </a-form-item>

        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button html-type="submit" type="primary" @click="doLogin">登录</a-button>
        </a-form-item>
      </a-form>
    </div>
  </div>

</template>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  background-color: #f2f2f2;
}

.login-form {
  width: 300px;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  justify-content: center;
}
</style>
<script lang="ts">
import {ref} from 'vue'
import axios from 'axios'
import {Options, Vue} from "vue-class-component";
import {NButton, NCard} from 'naive-ui'
import MdEditor from "md-editor-v3";

@Options({
  components: {
    NButton,
    NCard,
    MdEditor,
  },
})

export default class Login extends Vue {
  username :string =''
  password :string =''
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
  <div>
    <h1>Welcome</h1>
    <n-button @click="goBack()">Back</n-button>
    用户名：<input v-model="username" type="text">
    密码：<input v-model="password" type="text">
    <button @click="doLogin">登录</button>
  </div>

</template>

<style scoped>

</style>
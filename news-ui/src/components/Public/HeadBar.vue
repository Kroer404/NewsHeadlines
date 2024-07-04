<script lang="ts">

</script>

<template>
  <div class="hearbar-background">
    <div class="headbar">
      <router-link class="logo" to="/">
        <img class="logo-img" src="/img/home.png">
      </router-link>
      <router-link to="/Index">
        <img class="login-img" src="/img/user.png">
        <br>
        <span>面板</span>
      </router-link>
      <router-link class="nav-link" to="/login">
        <img class="login-img" src="/img/Login.svg">
        <br>
        <span>登录</span>
      </router-link>
      <router-link class="nav-link" to="/register">
        <img class="register-img" src="/img/register.png">
        <br>
        <span>注册</span>
      </router-link>
    </div>
  </div>
</template>

<style scoped>
.hearbar-background {
  height: 70px;
}

.headbar {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  align-items: center;
  z-index: 1000;
  background-color: white;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  height: 50px;
}

.logo {
  margin-right: auto;
  height: 30px;
  width: auto;
  margin-left: 10px;
}

.logo-img, .login-img, .register-img {
  height: 20px;
}

.login-img, .register-img {
  width: auto;
  margin-left: 5px;
  margin-right: 10px;
}

.nav-link {
  margin-left: 20px;
}

a{
  text-decoration:none;
  color:#333;
}
</style>
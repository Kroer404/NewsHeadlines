<script lang="ts" setup>

</script>

<template>
  <div class="buttombar-background">
    <div class="buttombar">
      <p>版权没有，随便翻录</p>
      <div style="width: 50px"></div>
      <router-link to="/">
        <p>首页</p>
      </router-link>
      |
      <router-link to="/">
        <p>隐私政策</p>
      </router-link>
      |
      <router-link to="/">
        <p>关于我们</p>
      </router-link>
      |
      <router-link to="/">
        <p>特别鸣谢</p>
      </router-link>
    </div>
  </div>
</template>


<style scoped>
.buttombar-background{
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.buttombar {
  width: 100%;
  display: flex;
  background-color: brown;
  height: 50px;
}


</style>
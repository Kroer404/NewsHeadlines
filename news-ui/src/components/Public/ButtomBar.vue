<script lang="ts" setup>

</script>

<template>
  <a-divider style="border-color: #7cb305" dashed />
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
  width: 100%;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.buttombar {
  display: flex;
  height: 50px;
}


</style>
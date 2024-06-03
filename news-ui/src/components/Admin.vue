<script lang="ts">
import {Vue} from 'vue-class-component'
import axios from "axios";
export default class Admin extends Vue {

  //初始化后端数据
  public adminData:string="";
  //接口地址
  private apiURL:string="http://localhost:8080/admins/hi";

  mounted(){
    this.getData();
  }

  getData(){
    axios
        .get(this.apiURL)
        .then(response => (this.adminData = response.data))
        .catch((error) => console.log(error));
  }
}
</script>

<template>
  <p>Get data from admin:{{ adminData }}</p>
</template>

<style scoped>

</style>
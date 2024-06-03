const { defineConfig } = require('@vue/cli-service')
module.exports = {
  devServer: {
    proxy: {
      '/api': {
        //后端接口地址
        target: 'http://localhost:8080',
        //允许跨域
        changeOrigin: true,
        //代理websockets
        ws: true,
        //不启用HTTPS
        secure: false,
        //重写路径
        pathRewrite: { '^/api': '' }
      }
    }
  }
}





//     defineConfig({
//   transpileDependencies: true
// })

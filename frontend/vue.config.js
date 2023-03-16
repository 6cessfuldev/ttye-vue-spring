const { defineConfig } = require('@vue/cli-service')
const path = require("path");

module.exports = defineConfig({
  transpileDependencies: true,
  // publicPath: process.env.NODE_ENV === 'production'
  //       ? '/static/vue'
  //       : 'http://localhost:8080/',
  outputDir: path.resolve(__dirname, "../src/main/webapp/WEB-INF/views/static")
})

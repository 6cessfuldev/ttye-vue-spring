const { defineConfig } = require('@vue/cli-service')
const path = require("path");
const webpack = require('webpack');

module.exports = defineConfig({
  transpileDependencies: true,
  // publicPath: process.env.NODE_ENV === 'production'
  //       ? '/static/vue'
  //       : 'http://localhost:8080/',
  outputDir: path.resolve(__dirname, "../src/main/webapp/WEB-INF/views/static"),
  configureWebpack: {
    plugins: [
      new webpack.DefinePlugin({
        'process.env': Object.fromEntries(
          Object.entries(process.env).filter(([key]) =>
            key.startsWith('VUE_APP_')
          )
        )
      })
    ]
  }
})

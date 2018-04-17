// for resolving the absolute path to our project
// necessary for webpack
const path = require('path');
const webpack = require('webpack');

module.exports = {
    // where our app "starts"
    // add the promise and fetch polyfill first
    entry: ['promise-polyfill', 'whatwg-fetch', './src/main/webapp/js/global.js'],
    // where to put the transpiled javascript
    output: {
        path: path.resolve(__dirname, 'src/main/webapp/js/'),
        filename: 'main.js'
    },
    // babel config
    module: {
        rules: [
            {
                // any file that ends with '.js'
                test: /\.js$/,
                // except those in "node_modules"
                exclude: /node_modules/,
                // transform with babel
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['env']
                    }
                }
            }
        ]
    },

    // allows us to see how the transpiled js relates to the untranspiled js
    devtool: 'source-map'
};

import Vue from 'vue';
import { Button, Select } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';

Vue.use(Button);
Vue.use(Select);

new Vue({
    el: '#app',
    render: h => h(App)
});
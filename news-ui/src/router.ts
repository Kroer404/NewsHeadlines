import {createRouter, createWebHashHistory} from 'vue-router'
import NewsList from ".//components/NewsList.vue";

const routes: Array<any> = [
    {
        path: '/',
        name: 'NewsList',
        component: NewsList,
    },
    {
        path: '/news/:id',
        name: 'NewsDetail',
        component: () =>
            import('.//components/NewsDetail.vue'),
    },
    {
        path: '/admin',
        name: 'Admin',
        component: () =>
            import('.//components/Admin.vue'),
    },
    {
        path:'/login',
        name:'Login',
        component:() =>
            import('.//components/Login.vue'),
    }
];
const router = createRouter({
    history: createWebHashHistory(),
    routes
})


export default router;
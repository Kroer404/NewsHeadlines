import {createRouter, createWebHashHistory} from 'vue-router'

const routes: Array<any> = [
    {
        path: '/',
        name: 'NewsList',
        component: () =>
            import('@/page/News/NewsList.vue'),
    },
    {
        path: '/news/:id',
        name: 'NewsDetail',
        component: () =>
            import('@/page/News/NewsDetail.vue'),
    },
    {
        path: '/news-edit',
        name: 'NewsEdit',
        component: () =>
            import('@/page/News/NewsEdit.vue'),
    },
    {
        path: '/admin',
        name: 'Admin',
        component: () =>
            import('./components/Develop/Admin.vue'),
    },
    {
        path:'/login',
        name:'Login',
        component:() =>
            import('@/page/User/Login.vue'),
    },
    {
        path:'/Index',
        name:'UserIndex',
        component:() =>
            import('@/page/User/UserIndex.vue'),
    },
    {
        path:'/register',
        name:'UserRegister',
        component:() =>
            import('@/page/User/Register.vue'),
    }
];
const router = createRouter({
    history: createWebHashHistory(),
    routes
})


export default router;
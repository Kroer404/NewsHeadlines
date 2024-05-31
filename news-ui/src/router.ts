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
];
const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;
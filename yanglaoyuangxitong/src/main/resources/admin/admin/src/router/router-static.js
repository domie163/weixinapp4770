import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import fuwuxiangmu from '@/views/modules/fuwuxiangmu/list'
    import fuwuxiangmuYuyue from '@/views/modules/fuwuxiangmuYuyue/list'
    import meishi from '@/views/modules/meishi/list'
    import news from '@/views/modules/news/list'
    import yisheng from '@/views/modules/yisheng/list'
    import yishengOrder from '@/views/modules/yishengOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryFuwuxiangmu from '@/views/modules/dictionaryFuwuxiangmu/list'
    import dictionaryFuwuxiangmuYuyueYesno from '@/views/modules/dictionaryFuwuxiangmuYuyueYesno/list'
    import dictionaryMeishi from '@/views/modules/dictionaryMeishi/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShijianduan from '@/views/modules/dictionaryShijianduan/list'
    import dictionaryYisheng from '@/views/modules/dictionaryYisheng/list'
    import dictionaryYishengOrder from '@/views/modules/dictionaryYishengOrder/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryFuwuxiangmu',
        name: '服务项目类型',
        component: dictionaryFuwuxiangmu
    }
    ,{
        path: '/dictionaryFuwuxiangmuYuyueYesno',
        name: ' ',
        component: dictionaryFuwuxiangmuYuyueYesno
    }
    ,{
        path: '/dictionaryMeishi',
        name: '餐食类型',
        component: dictionaryMeishi
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShijianduan',
        name: '挂号时间段',
        component: dictionaryShijianduan
    }
    ,{
        path: '/dictionaryYisheng',
        name: '科室',
        component: dictionaryYisheng
    }
    ,{
        path: '/dictionaryYishengOrder',
        name: '订单类型',
        component: dictionaryYishengOrder
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/fuwuxiangmu',
        name: '服务项目',
        component: fuwuxiangmu
      }
    ,{
        path: '/fuwuxiangmuYuyue',
        name: '服务项目预约',
        component: fuwuxiangmuYuyue
      }
    ,{
        path: '/meishi',
        name: '餐食目录',
        component: meishi
      }
    ,{
        path: '/news',
        name: '公告资讯',
        component: news
      }
    ,{
        path: '/yisheng',
        name: '医生',
        component: yisheng
      }
    ,{
        path: '/yishengOrder',
        name: '商品订单',
        component: yishengOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

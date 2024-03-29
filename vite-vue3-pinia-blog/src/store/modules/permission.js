// import { defineStore } from 'pinia';
// import { asyncRoutes, constantRoutes } from '/@/router';

// /**
//  * 判断是否拥有权限
//  * @param roles
//  * @param route
//  */
// function hasPermission(roles, route) {
//   if (route.meta && route.meta.roles) {
//     return roles.some(role => route.meta.roles.includes(role));
//   } else {
//     return true;
//   }
// }

// /**
//  * 递归权限路由
//  * @param routes asyncRoutes
//  * @param roles
//  */
// function filterAsyncRoutes(routes, roles) {
//   const res = [];

//   routes.forEach(route => {
//     const tmp = { ...route };
//     if (hasPermission(roles, tmp)) {
//       if (tmp.children) {
//         tmp.children = filterAsyncRoutes(tmp.children, roles);
//       }
//       res.push(tmp);
//     }
//   });

//   return res;
// }

// export const usePermissionStore = defineStore('permission',{
//   state: () => ({
//     routes: [],
//     addRoutes: []
//   }),
//   actions: {
//     // 根据角色动态加载路由
//     generateRoutes(roles) {
//       return new Promise(resolve => {
//         let accessedRoutes;
//         // 管理员全部路由
//         if (roles.includes('admin')) {
//           accessedRoutes = asyncRoutes || [];
//         } else {
//           // 非管理员根据角色获取对应路由
//           accessedRoutes = filterAsyncRoutes(asyncRoutes, roles);
//         }
//         this.SET_ROUTES(accessedRoutes);
//         resolve(accessedRoutes);
//       });
//     },
//     SET_ROUTES(routes) {
//       this.addRoutes = routes;
//       this.routes = [...constantRoutes, ...routes];
//     }
//   }
// });

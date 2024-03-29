import { defineStore } from "pinia";
import {
  getUsername,
  setUsername,
  removeUsername,
  setPassword,
  getPassword,
  removePassword,
} from "/@/utils/auth";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    visible: false,
    username: getUsername(),
    password: getPassword(),
  }),
  actions: {
    changeVisible(value) {
      this.visible = value;
    },
    setUsername(value) {
      this.username = value;
    },
    setPassword(value) {
      this.password = value;
    },

    /**
     * 记住用户名和密码
     */
    setUsernameAndPassword(params) {
      const { username, password } = params;
      this.username = username;
      this.password = password;
      setUsername(username);
      setPassword(password);
    },
    /**
     * 清除用户和密码
     */
    clearUsernameAndPassword() {
      this.username = "";
      this.password = "";
      removeUsername();
      removePassword();
    },
  },
});

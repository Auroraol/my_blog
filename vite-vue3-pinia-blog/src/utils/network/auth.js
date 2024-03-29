import Cookies from 'js-cookie'
// import { Base64 } from 'js-base64'

const AccessTokenKey = 'accessToken'
const RefreshTokenKey = 'refreshToken'
const UserAccountInfo = 'userAccountInfo'

const UsernameKey = 'username'
const PasswordKey = 'password'
const RememberKey = 'remember'

/**
 * 获取 accessToken
 */
export function getAccessToken() {
  return Cookies.get(AccessTokenKey)
}

/**
 * 设置 accessToken
 * @param {String} token
 */
export function setAccessToken(token) {
  return Cookies.set(AccessTokenKey, token)
}

/**
 * 移除 accessToken
 */
export function removeAccessToken() {
  return Cookies.remove(AccessTokenKey)
}

//
/**
 * 获取 refreshToken
 */
export function getRefreshToken() {
  return Cookies.get(RefreshTokenKey)
}

/**
 * 设置 refreshToken
 * @param {String} token
 */
export function setRefreshToken(token) {
  return Cookies.set(RefreshTokenKey, token)
}

/**
 * 移除 refreshToken
 */
export function removeRefreshToken() {
  return Cookies.remove(RefreshTokenKey)
}


//
/**
 * 获取 UserAccountInfo
 */
export function getUserAccountInfo() {
  return Cookies.get(UserAccountInfo)
}

/**
 * 设置 UserAccountInfo
 * @param {string} info
 */
export function setUserAccountInfo(info) {
  return Cookies.set(UserAccountInfo, info)
}

/**
 * 移除 UserAccountInfo
 */
export function removeUserAccountInfo() {
  return Cookies.remove(UserAccountInfo)
}




/**
 * 设置用户名
 * @param {String} username
 */
export function setUsername(username) {
  return Cookies.set(UsernameKey, Base64.encode(username), { expires: 15 })
}

/**
 * 获取用户名
 */
export function getUsername() {
  const v = Cookies.get(UsernameKey)
  return v ? Base64.decode(v) : v
}

/**
 * 移除 用户名
 */
export function removeUsername() {
  return Cookies.remove(UsernameKey)
}

/**
 * 设置密码
 * @param {String} password
 */
export function setPassword(password) {
  return Cookies.set(PasswordKey, Base64.encode(password), { expires: 15 })
}

/**
 * 获取密码
 */
export function getPassword() {
  const v = Cookies.get(PasswordKey)
  return v ? Base64.decode(v) : v
}

/**
 * 移除 密码
 */
export function removePassword() {
  return Cookies.remove(PasswordKey)
}

/**
 * 设置记住密码
 */
export function setRemember(checked) {
  return Cookies.set(RememberKey, checked, { expires: 15 })
}

/**
 * 获取记住密码
 */
export function getRemember() {
  return Cookies.get(RememberKey)
}



package com.lfj.blog.utils;

import java.util.regex.Pattern;

/**
 * 校验工具类
 *
 * @author: yaohw
 * @create: 2019-10-28 18:51
 **/
public class ValidateUtil {

	/**
	 * 验证是否手机号
	 *
	 * @param s
	 * @return boolean
	 */
	public static boolean validateMobile(Object s) {
		String str = String.valueOf(s);
		String regexp = "^([1][3,4,5,6,7,8,9]\\d{9})$";
		return Pattern.matches(regexp, str);
	}
}

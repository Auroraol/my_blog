package com.lfj.blog.common.security.details;

import com.lfj.blog.common.security.details.vo.CustomUserDetails;
import com.lfj.blog.common.security.details.vo.UserVo;
import com.lfj.blog.service.IUserService;
import com.lfj.blog.utils.ValidateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: yaohw
 * @create: 2019-10-24 16:40
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean isMobile = ValidateUtil.validateMobile(username);
		UserVo userVo;
		if (isMobile) {
			userVo = userService.selectUserVoByUsernameOtherwiseMobile(null, Long.parseLong(username));
		} else {
			userVo = userService.selectUserVoByUsernameOtherwiseMobile(username, null);
		}
		if (userVo == null) {
			throw new UsernameNotFoundException("user not found:" + username);
		}
		UserDetails userDetails = new CustomUserDetails();
		BeanUtils.copyProperties(userVo, userDetails);
		return userDetails;
	}
}

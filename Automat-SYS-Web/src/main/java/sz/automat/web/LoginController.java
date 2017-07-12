package sz.automat.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import sz.automat.core.base.AbstractController;
import sz.automat.core.base.Parameter;
import sz.automat.core.config.Resources;
import sz.automat.core.exception.LoginException;
import sz.automat.core.support.Assert;
import sz.automat.core.support.HttpCode;
import sz.automat.core.support.login.LoginHelper;
import sz.automat.core.util.SecurityUtil;
import sz.automat.model.Login;
import sz.automat.model.SysUser;
import sz.automat.provider.ISysProvider;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户登录
 * 
 * @author
 * @version 2016年5月20日 下午3:11:21
 */
@RestController
@Api(value = "登录接口", description = "登录接口")
public class LoginController extends AbstractController<ISysProvider> {

	public String getService() {
		return "sysUserService";
	}

	// 登录
	@ApiOperation(value = "用户登录")
	@PostMapping("/login")
	public Object login(@ApiParam(required = true, value = "登录帐号和密码") @RequestBody Login user, ModelMap modelMap,
			HttpServletRequest request) {
		Assert.notNull(user.getAccount(), "ACCOUNT");
		Assert.notNull(user.getPassword(), "PASSWORD");
		if (LoginHelper.login(request, user.getAccount(), SecurityUtil.encryptPassword(user.getPassword()))) {
			request.setAttribute("msg", "[" + user.getAccount() + "]登录成功.");
			return setSuccessModelMap(modelMap);
		}
		request.setAttribute("msg", "[" + user.getAccount() + "]登录失败.");
		throw new LoginException(Resources.getMessage("LOGIN_FAIL"));
	}

	// 登出
	@ApiOperation(value = "用户登出")
	@PostMapping("/logout")
	public Object logout(HttpServletRequest request, ModelMap modelMap) {
		SecurityUtils.getSubject().logout();
		return setSuccessModelMap(modelMap);
	}

	// 注册
	@ApiOperation(value = "用户注册")
	@PostMapping("/regin")
	public Object regin(HttpServletRequest request, ModelMap modelMap, @RequestBody SysUser sysUser) {
		Assert.notNull(sysUser.getAccount(), "ACCOUNT");
		Assert.notNull(sysUser.getPassword(), "PASSWORD");
		sysUser.setPassword(SecurityUtil.encryptPassword(sysUser.getPassword()));
		provider.execute(new Parameter("sysUserService", "update").setModel(sysUser));
		if (LoginHelper.login(request, sysUser.getAccount(), sysUser.getPassword())) {
			return setSuccessModelMap(modelMap);
		}
		throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"));
	}

	// 没有登录
	@RequestMapping(value = "/unauthorized", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public Object unauthorized(ModelMap modelMap) throws Exception {
		return setModelMap(modelMap, HttpCode.UNAUTHORIZED);
	}

	// 没有权限
	@RequestMapping(value = "/forbidden", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public Object forbidden(ModelMap modelMap) {
		return setModelMap(modelMap, HttpCode.FORBIDDEN);
	}
}

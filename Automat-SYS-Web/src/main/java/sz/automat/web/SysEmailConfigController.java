package sz.automat.web;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sz.automat.core.base.AbstractController;
import sz.automat.core.base.Parameter;
import sz.automat.core.util.DataUtil;
import sz.automat.core.util.SecurityUtil;
import sz.automat.model.SysEmailConfig;
import sz.automat.provider.ISysProvider;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 邮件配置管理控制类
 * 
 * @author
 * @version 2016年5月20日 下午3:13:31
 */
@RestController
@Api(value = "邮件配置管理", description = "邮件配置管理")
@RequestMapping(value = "emailConfig")
public class SysEmailConfigController extends AbstractController<ISysProvider> {

	public String getService() {
		return "sysEmailConfigService";
	}

	@ApiOperation(value = "查询邮件配置")
	@RequiresPermissions("sys.email.config.read")
	@RequestMapping(value = "/read/list", method = RequestMethod.PUT)
	public Object query(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		return super.query(modelMap, param);
	}

	@ApiOperation(value = "邮件配置详情")
	@RequiresPermissions("sys.email.config.read")
	@RequestMapping(value = "/read/detail", method = RequestMethod.PUT)
	public Object get(ModelMap modelMap, @RequestBody SysEmailConfig param) {
		return super.get(modelMap, param);
	}

	@ApiOperation(value = "修改邮件配置")
	@RequiresPermissions("sys.email.config.update")
	@RequestMapping(method = RequestMethod.POST)
	public Object update(ModelMap modelMap, @RequestBody SysEmailConfig param) {
		if (param.getId() != null) {
			Parameter parameter = new Parameter("sysEmailConfigService", "queryById").setId(param.getId());
			SysEmailConfig result = (SysEmailConfig) provider.execute(parameter).getModel();
			if (param.getSenderPassword() != null && !param.getSenderPassword().equals(result.getSenderPassword())) {
				param.setSenderPassword(SecurityUtil.encryptMd5(param.getSenderPassword()));
			}
		} else if (DataUtil.isNotEmpty(param.getSenderPassword())) {
			param.setSenderPassword(SecurityUtil.encryptMd5(param.getSenderPassword()));
		}
		return super.update(modelMap, param);
	}

	@ApiOperation(value = "删除邮件配置")
	@RequiresPermissions("sys.email.config.delete")
	@RequestMapping(method = RequestMethod.DELETE)
	public Object delete(ModelMap modelMap, @RequestBody SysEmailConfig param) {
		return super.delete(modelMap, param);
	}
}

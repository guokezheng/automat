package sz.automat;

import java.util.Map;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import sz.automat.core.util.InstanceUtil;
import sz.automat.service.SysUserService;

import com.alibaba.fastjson.JSON;

import junit.framework.TestCase;

public class SysUserTest extends TestCase {
	SysUserService sysUserService;

	@SuppressWarnings("resource")
	protected void setUp() throws Exception {
		super.setUp();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "Spring-config.xml" });
		sysUserService = context.getBean(SysUserService.class);
	}

	public void testAuery() {
		Map<String, Object> params = InstanceUtil.newHashMap();
		System.out.println(JSON.toJSONString(sysUserService.query(params)));
	}
}

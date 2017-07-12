package sz.automat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysMenu;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
	/** 获取所有权限 */
	public List<Map<String, String>> getPermissions();

	public List<Long> selectIdPage(@Param("cm") Map<String, Object> params);
}
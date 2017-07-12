package sz.automat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysRoleMenu;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
	List<Long> queryMenuIdsByRoleId(@Param("roleId") Long roleId);

	List<Map<String, Object>> queryPermissions(@Param("roleId") Long roleId);

	List<String> queryPermission(@Param("roleId") Long id);
}

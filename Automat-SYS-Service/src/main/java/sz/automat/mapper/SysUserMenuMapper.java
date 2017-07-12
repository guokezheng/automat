package sz.automat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysUserMenu;

public interface SysUserMenuMapper extends BaseMapper<SysUserMenu> {
	List<Long> queryMenuIdsByUserId(@Param("userId") Long userId);

	List<Map<String, Object>> queryPermissions(@Param("userId") Long userId);

	List<String> queryPermission(@Param("userId") Long id);
}
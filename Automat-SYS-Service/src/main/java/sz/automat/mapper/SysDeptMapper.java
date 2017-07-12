package sz.automat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysDept;

public interface SysDeptMapper extends BaseMapper<SysDept> {

	List<Long> selectIdPage(@Param("cm") SysDept sysDept);
}
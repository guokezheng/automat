package sz.automat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysDic;

public interface SysDicMapper extends BaseMapper<SysDic> {
    List<Long> selectIdPage(@Param("cm") Map<String, Object> params);
}
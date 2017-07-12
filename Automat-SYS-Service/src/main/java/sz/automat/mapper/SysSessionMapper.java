package sz.automat.mapper;

import java.util.List;

import sz.automat.core.base.BaseMapper;
import sz.automat.model.SysSession;

public interface SysSessionMapper extends BaseMapper<SysSession> {

    void deleteBySessionId(String sessionId);

    Long queryBySessionId(String sessionId);

    List<String> querySessionIdByAccount(String account);
}
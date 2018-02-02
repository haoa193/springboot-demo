package com.haoa193.springbootdemo.service;

import com.haoa193.springbootdemo.dao.UserLogMapper;
import com.haoa193.springbootdemo.entity.usr.UserLog;
import com.haoa193.springbootdemo.model.Page;
import com.haoa193.springbootdemo.model.query.UserLogQueryModel;
import com.haoa193.springbootdemo.vo.UserLogListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserLogService {
    private @Autowired
    UserLogMapper userLogMapper;

    public Page<UserLogListVo> userLogs(UserLogQueryModel queryModel) {

        Page<UserLogListVo> page = new Page<>();
        page.setPageNumber(queryModel.getPageNumber());
        page.setPageSize(queryModel.getPageSize());

        long count = userLogMapper.count(queryModel);
        page.setTotal(count);
        if (count > 0) {
            List<UserLog> userLogs = userLogMapper.findAll(queryModel);
            List<UserLogListVo> list = userLogs.stream()
                    .map(USER_LOG_USER_LOG_LIST_VO_FUNCTION)
                    .collect(Collectors.toList());
            page.setList(list);

        }
        return page;
    }
    private static final Function<UserLog, UserLogListVo> USER_LOG_USER_LOG_LIST_VO_FUNCTION
            = userLog -> {
        UserLogListVo vo = new UserLogListVo();
        vo.setId(userLog.getId());
        vo.setUserId(userLog.getUserId());
        vo.setOperatedTime(userLog.getOperatedTime());
        vo.setOperation(userLog.getOperation());
        vo.setOperatorId(userLog.getOperatorId());
        vo.setProjectId(userLog.getProjectId());
        vo.setRemark(userLog.getRemark());
        return vo;
    };
}

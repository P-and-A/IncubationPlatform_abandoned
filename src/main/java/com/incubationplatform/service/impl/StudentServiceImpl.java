package com.incubationplatform.service.impl;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.mapper.TSMapper;
import com.incubationplatform.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaochaofan
 * @date 2018/11/6 12:07
 */
@Service("iStudentService")
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private TSMapper tsMapper;
    public ServerResponse addMember(String teamId,String memberId){
        int memberNum = tsMapper.selectByTeamId(teamId);
        if (memberNum >= 5){
            return ServerResponse.createByErrorMessage("添加失败，团队人数已满");
        }
        int rowCount = tsMapper.insertMemberByTeamId(teamId, memberId);
        if (rowCount > 0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
}

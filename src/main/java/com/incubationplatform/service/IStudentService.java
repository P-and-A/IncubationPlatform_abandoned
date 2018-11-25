package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;

/**
 * @author liaochaofan
 * @date 2018/11/6 12:04
 */
public interface IStudentService {
    public ServerResponse addMember(String teamId, String memberId);
}

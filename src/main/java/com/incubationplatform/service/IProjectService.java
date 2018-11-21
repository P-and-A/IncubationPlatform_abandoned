package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;
import org.springframework.stereotype.Service;

/**
 * @author liaochaofan
 * @date 2018/11/19 13:47
 */

public interface IProjectService {
    public ServerResponse selectApprovalProjectName();

    public ServerResponse selectOutstandingProjectName();
}

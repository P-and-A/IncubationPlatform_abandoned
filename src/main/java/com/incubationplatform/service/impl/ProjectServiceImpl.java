package com.incubationplatform.service.impl;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.entity.Project;
import com.incubationplatform.mapper.ProjectMapper;
import com.incubationplatform.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaochaofan
 * @date 2018/11/19 13:48
 */
@Service("iProjectService")
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    public ServerResponse selectApprovalProjectName(){
        List<Project> projectList = projectMapper.selectApprovalProject();

        return ServerResponse.createBySuccess(getProjectNameIdGrade(projectList));
    }

    public ServerResponse selectOutstandingProjectName(){
        List<Project> projectList = projectMapper.selectOutstandingProject();

        return ServerResponse.createBySuccess(getProjectNameIdGrade(projectList));
    }
    private List<Project> getProjectNameIdGrade(List<Project> projectList){
        List<Project> returnList = new ArrayList<>();
        for (Project item:projectList){
            Project project = new Project();
            project.setId(item.getId());
            project.setProjectGrade(item.getProjectGrade());
            project.setProjectName(item.getProjectName());
            returnList.add(project);
        }
        return returnList;
    }
}

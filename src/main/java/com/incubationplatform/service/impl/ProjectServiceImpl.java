package com.incubationplatform.service.impl;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.entity.Project;
import com.incubationplatform.entity.Student;
import com.incubationplatform.mapper.ProjectMapper;
import com.incubationplatform.mapper.StudentMapper;
import com.incubationplatform.mapper.TSMapper;
import com.incubationplatform.service.IProjectService;
import com.incubationplatform.vo.ProjectDetailVo;
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
    @Autowired
    private TSMapper tsMapper;

    @Autowired
    private StudentMapper studentMapper;
    public ServerResponse selectApprovalProjectName(){
        List<Project> projectList = projectMapper.selectApprovalProject();

        return ServerResponse.createBySuccess(getProjectNameIdGrade(projectList));
    }

    public ServerResponse selectOutstandingProjectName(){
        List<Project> projectList = projectMapper.selectOutstandingProject();

        return ServerResponse.createBySuccess(getProjectNameIdGrade(projectList));
    }

    public ServerResponse selectProjectbyId(String projectId){
        Project project = projectMapper.selectProjectById(projectId);
        return ServerResponse.createBySuccess(assembleProjectDetailVo(project));
    }
    private ProjectDetailVo assembleProjectDetailVo(Project project){
        ProjectDetailVo projectDetailVo = new ProjectDetailVo();
        projectDetailVo.setProjectName(project.getProjectName());
        projectDetailVo.setStatus(project.getStatus());
        projectDetailVo.setClassification(project.getClassification());
        projectDetailVo.setCreateTime(project.getCreateTime());
        projectDetailVo.setProjectGrade(project.getProjectGrade());
        projectDetailVo.setProjectContent(project.getProjectContent());
        List<String> studentIdList = tsMapper.selectByTeamId(project.getTeamId());
        List<Student> teamMenbers = new ArrayList<>();
        for (String item : studentIdList){
            Student student = studentMapper.selectById(item);
            Student menber = new Student();
            menber.setIsMain(student.getIsMain());
            menber.setName(student.getName());
            menber.setStudentId(student.getStudentId());
            teamMenbers.add(menber);
        }
        projectDetailVo.setStudentList(teamMenbers);
        return projectDetailVo;
    }
    private List<Project> getProjectNameIdGrade(List<Project> projectList){
        List<Project> returnList = new ArrayList<>();
        for (Project item:projectList){
            Project project = new Project();
            project.setId(item.getId());
            project.setProjectGrade(item.getProjectGrade());
            project.setProjectName(item.getProjectName());
            project.setClassification(item.getClassification());
            returnList.add(project);
        }
        return returnList;
    }
}

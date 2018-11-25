package com.incubationplatform.controller;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.service.IProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liaochaofan
 * @date 2018/11/19 13:42
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * 获取立项成功的
     * @return
     */
    @ResponseBody
    @RequestMapping("/get_project_approval")
    public ServerResponse selectProjectName(){
        return iProjectService.selectApprovalProjectName();
    }

    @ResponseBody
    @RequestMapping("/get_project_outstanding")
    public ServerResponse selectOutstandingProjectName(){
        return iProjectService.selectOutstandingProjectName();
    }

    @ResponseBody
    @RequestMapping("/{projectId}")
    public ServerResponse findProjectByIdInPublic(@PathVariable String projectId){
        return iProjectService.selectProjectbyId(projectId);
    }
//    @ResponseBody
//    @RequestMapping("/a")
//    public String a(){
//        return "register.html";
//    }


}

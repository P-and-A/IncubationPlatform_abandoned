package com.incubationplatform.controller;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liaochaofan
 * @date 2018/11/6 10:43
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "/team/{teamId}/add_member/{memberId}",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addMember(@PathVariable String teamId, @PathVariable String memberId){
        return iStudentService.addMember(teamId, memberId);
    }


}

package com.incubationplatform.mapper;

import com.incubationplatform.entity.Project;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liaochaofan
 * @date 2018/11/19 13:53
 */
public interface ProjectMapper {
    @Select("select * from project where status = '1'")//1表示成功立项的项目
    public List<Project> selectApprovalProject();

    @Select("select * from project where status = '22'")//22表示优秀的结项项目
    public List<Project> selectOutstandingProject();
}

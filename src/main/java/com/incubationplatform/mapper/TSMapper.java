package com.incubationplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liaochaofan
 * @date 2018/11/6 12:39
 */
public interface TSMapper {
    @Insert("insert into team_student (teamId,studentId) values(#{teamId},#{studentId})")
    int insertMemberByTeamId(@Param("teamId") Long teamId,@Param("studentId") Long studentId);

    @Select("select * from team_student where teamId=#{teamId}")
    int selectByTeamId(Long teamId);
}

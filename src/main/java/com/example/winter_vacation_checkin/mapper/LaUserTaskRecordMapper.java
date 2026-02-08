package com.example.winter_vacation_checkin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.winter_vacation_checkin.domain.LaUserTaskRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.UserTaskListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 徐扬
* @description 针对表【la_user_task_record】的数据库操作Mapper
* @createDate 2026-02-04 16:16:44
* @Entity generator.domain.LaUserTaskRecord
*/
public interface LaUserTaskRecordMapper extends BaseMapper<LaUserTaskRecord> {

    IPage<ActivityDetailVo> UserTasklist(Page<UserTaskListVo> page);

    List<LaUserTaskRecord> getByUserIdandActivityId(@Param("userId") Long userId, @Param("activityId") Long activityId);

    Long taskCount(@Param("userId") Long userId, @Param("activityId") Long activityId);

    Long totalTaskCount(@Param("activityId") Long activityId);
}





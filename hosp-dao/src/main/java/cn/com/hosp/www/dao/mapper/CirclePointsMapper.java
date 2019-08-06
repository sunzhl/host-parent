package cn.com.hosp.www.dao.mapper;

import cn.com.hosp.www.dao.entry.CirclePoints;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CirclePointsMapper extends BaseMapper<CirclePoints> {


    @Insert("<script>insert into circle_points(circle_id, space_id, space_name) values" +
            " <foreach collection='circlePoints' item='item' separator=',' >" +
            " (#{item.circleId},#{item.spaceId}, #{item.spaceName}) " +
            " </foreach> </script>")
    int saveBatch(@Param("circlePoints") List<CirclePoints> circlePoints);


    @Delete("<script> delete from circle_points where id in " +
            " <foreach item='item' collection='ids' open='(' separator=',' close=')'> " +
            "  #{item}" +
            " </foreach></script>")
    int deleteBath(@Param("ids") List<Long> ids);

}

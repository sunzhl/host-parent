package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.Structures;
import cn.com.hosp.www.sys.vo.ReturnCode;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName StructureService
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午7:23
 * @Version 1.0
 */

public interface StructureService {

    ReturnCode save(@NotNull Structures structures);

    Structures selectOneById(@Param("id") @NotNull Long id);

    List<Structures> selectAll();

    List<Structures> selectAllByParam(@NotNull Structures structures);

}

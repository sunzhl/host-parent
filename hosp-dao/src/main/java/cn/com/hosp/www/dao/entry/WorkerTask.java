package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName WorkerTask
 * @Description TODO
 * @Author tome
 * @Date 19-7-5 上午11:28
 * @Version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerTask implements Serializable {

    private Long id;

    private Long workerId;

    private String currentPosition;

    private LocalDateTime lastLoginTime;

    private LocalDateTime scanTime;

    private Integer totalCount;

    private Integer todayCount;

    private Integer selfCount;

    private Integer todaySelfCount;


    private static final long serialVersionUID = 1L;
}

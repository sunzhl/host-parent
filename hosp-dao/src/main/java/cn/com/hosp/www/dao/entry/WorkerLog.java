package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerLog implements Serializable {
    private Long id;

    private String logNumber;

    private Long workerId;

    private String workerName;

    private Short logType;

    private LocalDateTime logTime;

    private  Long taskId;

    private String position;

    private static final long serialVersionUID = 1L;

}
package cn.com.hosp.www.sys.vo;


import cn.com.hosp.www.dao.entry.WorkerInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerInfoVo implements Serializable {


    private int totalSize;

    private int onLineSize;

    private List<WorkerInfo> onlineList;

    private List<WorkerInfo> offlineList;

}

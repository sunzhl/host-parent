package cn.com.hosp.www.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CircleSettingDto implements Serializable {

     private Long id;
     private Long workerId;
     private String workerName;
     private Long proId;
     private String proName;
     private Integer finishCount;
     private Integer finishTime;
     private String spaces;
     private static final long serialVersionUID = 1L;


}

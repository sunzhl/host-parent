package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkTools implements Serializable {


    private Long id;

    private String toolCode;

    private String toolName;

    private Long proId;

    private String proName;

    private static final long serialVersionUID = 1L;


}
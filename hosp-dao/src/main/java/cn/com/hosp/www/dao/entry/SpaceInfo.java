package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpaceInfo implements Serializable {
    private Long id;

    private String spaceCode;

    private String spaceName;

    private String floor;

    private String wonGroup;

    private Long roleId;

    private String roleName;

    private Long proId;

    private String proName;

    private Long structId;

    private String structName;

    private Short jobType;

    private Long endTypeId;

    private String endTypeName;

    private Short batchJobStart;

    private String remark;

    private static final long serialVersionUID = 1L;
}
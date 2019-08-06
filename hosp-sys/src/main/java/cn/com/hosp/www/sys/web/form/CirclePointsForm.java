package cn.com.hosp.www.sys.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CirclePointsForm implements Serializable {
    private Long id;
    private Long circleId;
    private Long spaceId ;
    private String spaceName;
    private String type; // add, del

    private static final long serialVersionUID = 1L;

}

package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CirclePoints implements Serializable {

    private Long id           ;
    private Long circleId    ;
    private Long spaceId     ;
    private String spaceName   ;
    private Short disabled     ;
    private Short selected     ;

    public CirclePoints(Long circleId, Long spaceId, String spaceName) {
        this.circleId = circleId;
        this.spaceId = spaceId;
        this.spaceName = spaceName;
    }

    private static final long serialVersionUID = 1L;

}

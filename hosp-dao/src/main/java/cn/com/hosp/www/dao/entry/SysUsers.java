package cn.com.hosp.www.dao.entry;


import cn.com.hosp.www.dao.mapper.base.annotation.Primary;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysUsers implements Serializable {

    @Primary
    private Long id;

    private String mobile;

    private String username;

    private String password;

    private Short userType;

    private Short state;

    private static final long serialVersionUID = 1L;



}
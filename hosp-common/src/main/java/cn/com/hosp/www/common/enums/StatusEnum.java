package cn.com.hosp.www.common.enums;

/**
 * @ClassName StatusEnum
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:20
 * @Version 1.0
 */

public enum StatusEnum implements ValueEnum {
    /**
     * 禁用状态
     */
    DISABLE(0),

    /**
     * 启用状态
     */
    ENABLE(1);

    /**
     * 状态值
     */
    private Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }


    @Override
    public Integer getValue() {
        return this.value;
    }
}
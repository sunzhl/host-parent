package cn.com.hosp.www.sys.service.base;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.sys.web.form.PageForm;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:16
 * @Version 1.0
 */

public interface BaseService<E> {

    /**
     * 保存实体
     * @param e
     * @return
     */
    E save(E e);

    /**
     * 根据id更新实体
     * @param e
     * @return
     */
    E updateById(E e);

    /**
     * 删除指定id的实体
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 根据条件删除
     * @param e
     * @return
     */
    Boolean deleteByCondition(E e);

    /**
     * 根据条件统计实体数
     * @param e
     * @return
     */
    Long countByCondition(E e);


    /**
     * 获取所有数据
     * @param orderBy  排序条件
     * @return
     */
    List<E> listAll(String orderBy);

    List<E> listAll();

    /**
     * 根据实体条件查询实体列表
     * @param e
     * @return
     */
    List<E> listByCondition(E e);

    Page<E> listByCondition(E e, PageForm pageForm);

    E getById(Long id);

    /**
     * 根据条件获取单个对象
     * @param e
     * @return
     */
    E getByCondition(E e);

}

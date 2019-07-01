package cn.com.hosp.www.dao.mapper.base;

import cn.com.hosp.www.common.utils.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName BaseMapper
 * @Description TODO
 * @Author tome
 * @Date 19-6-28 下午9:02
 * @Version 1.0
 */

public interface BaseMapper<Entity> {

    @InsertProvider(type = InsertSqlProvider.class, method = "sql")
    @Options(useGeneratedKeys = true)
    Integer insert(Entity entity);

//    @InsertProvider(type = BatchInsertSqlProvider.class, method = "sql")
//    @Options(useGeneratedKeys = true)
//    Integer batchInsert(List<Entity> entities);

    /**
     * 根据主键id更新实体，若实体field为null，则对应数据库的字段也更新为null
     * @param entity
     * @return
     */
    @UpdateProvider(type = UpdateSqlProvider.class, method = "sql")
    Integer updateByPrimaryKey(Entity entity);

    /**
     * 根据主键id更新实体，若实体field为null，则对应数据库的字段不更新
     * @param entity
     * @return
     */
    @UpdateProvider(type = UpdateSelectiveSqlProvider.class, method = "sql")
    Integer updateByPrimaryKeySelective(Entity entity);

    @DeleteProvider(type = DeleteSqlProvider.class, method = "sql")
    Integer deleteByPrimaryKey(Long id);

    @DeleteProvider(type = DeleteByCriteriaSqlProvider.class, method = "sql")
    Integer deleteByCriteria(Entity criteria);

    @SelectProvider(type = SelectOneSqlProvider.class, method = "sql")
    Entity selectByPrimaryKey(Long id);

    @SelectProvider(type = SelectAllSqlProvider.class, method = "sql")
    List<Entity> selectAll(String orderBy);

    @SelectProvider(type = SelectByCriteriaSqlProvider.class, method = "sql")
    List<Entity> selectByCriteria(Entity criteria);

    /**
     * 根据条件查询单个数据
     *
     * @param criteria
     * @return
     */
    @SelectProvider(type = SelectByCriteriaSqlProvider.class, method = "sql")
    Entity selectOneByCriteria(Entity criteria);

    @SelectProvider(type = CountSqlProvider.class, method = "sql")
    Long count();

    @SelectProvider(type = CountByCriteriaSqlProvider.class, method = "sql")
    Long countByCriteria(Entity criteria);


    /**
     * 插入操作
     */
    class InsertSqlProvider extends SqlProviderSupport {
        public String sql(Object entity, ProviderContext context) {
            TableInfo table = tableInfo(entity, context);
            return new SQL()
                    .INSERT_INTO(table.getTableName())
                    .INTO_COLUMNS(table.getColumns())
                    .INTO_VALUES(Stream.of(table.getFields()).map(this::bindParameter).toArray(String[]::new))
                    .toString();
        }
    }

    /**
     * 批量插入
     */
    class BatchInsertSqlProvider extends SqlProviderSupport {
        public String sql(Object entities, ProviderContext context) {
            TableInfo table = tableInfo(context);

            int size = ((List)((Map)entities).get("list")).size();
            String value = "(" + String.join(",", Stream.of(table.getFields()).map(this::bindParameter).toArray(String[]::new)) + ")";
            String[] values = new String[size];
            Arrays.fill(values, value);

            SQL sql = new SQL()
                    .INSERT_INTO(table.getTableName())
                    .INTO_COLUMNS(table.getColumns());
            StringBuilder sqlBuilder =  new StringBuilder(sql.toString());
            sqlBuilder.append(" VALUES ");
            sqlBuilder.append(String.join(",", values));
            return sqlBuilder.toString();
        }
    }

    /**
     * 更新操作
     */
    class UpdateSqlProvider extends SqlProviderSupport {
        public String sql(ProviderContext context) {
            TableInfo table = tableInfo(context);

            return new SQL()
                    .UPDATE(table.getTableName())
                    .SET(Stream.of(table.getFields())
                            .filter(field -> !table.getPrimaryKeyColumn().equals(columnName(field))) //过滤掉主键
                            .map(field -> columnName(field) + " = " + bindParameter(field)).toArray(String[]::new))
                    .WHERE(table.getPrimaryKeyColumn() + " = #{id, jdbcType=BIGINT}")
                    .toString();
        }
    }

    /**
     * 更新值不为空的数据
     */
    class UpdateSelectiveSqlProvider extends SqlProviderSupport {
        public String sql(Object entity, ProviderContext context) {
            TableInfo table = tableInfo(context);
            return new SQL()
                    .UPDATE(table.getTableName())
                    .SET(Stream.of(table.getFields())
                            .filter(field -> value(entity, field) != null && !table.getPrimaryKeyColumn().equals(columnName(field)))
                            .map(field -> columnName(field) + " = " + bindParameter(field)).toArray(String[]::new))
                    .WHERE(table.getPrimaryKeyColumn() + " = #{id, jdbcType=BIGINT}")
                    .toString();
        }
    }

    /**
     * 根据主键删除
     */
    class DeleteSqlProvider extends SqlProviderSupport {
        public String sql(ProviderContext context) {
            TableInfo table = tableInfo(context);

            return new SQL()
                    .DELETE_FROM(table.getTableName())
                    .WHERE(table.getPrimaryKeyColumn() + " = #{id, jdbcType=BIGINT}")
                    .toString();
        }
    }

    class DeleteByCriteriaSqlProvider extends SqlProviderSupport {
        public String sql(Object criteria, ProviderContext context) {
            TableInfo table = tableInfo(context);

            return new SQL()
                    .DELETE_FROM(table.getTableName())
                    .WHERE(Stream.of(table.getFields())
                            .filter(field -> value(criteria, field) != null)
                            .map(field -> columnName(field) + " = " + bindParameter(field))
                            .toArray(String[]::new))
                    .toString();
        }
    }

    /**
     * 根据主键查询一条数据
     */
    class SelectOneSqlProvider extends SqlProviderSupport {
        public String sql(ProviderContext context) {
            TableInfo table = tableInfo(context);

            return new SQL()
                    .SELECT(table.getSelectColumns())
                    .FROM(table.getTableName())
                    .WHERE(table.getPrimaryKeyColumn() + " = #{id, jdbcType=BIGINT}")
                    .toString();
        }
    }

    class SelectAllSqlProvider extends SqlProviderSupport {
        public String sql(String orderBy, ProviderContext context) {
            TableInfo table = tableInfo(context);
            SQL sql = new SQL()
                    .SELECT(table.getSelectColumns())
                    .FROM(table.getTableName());
            if (StringUtils.isEmpty(orderBy)) {
                orderBy = table.getPrimaryKeyColumn() + " DESC";
            }
            return sql.ORDER_BY(orderBy).toString();
        }
    }

    class SelectByCriteriaSqlProvider extends SqlProviderSupport {
        public String sql(Object criteria, ProviderContext context) {
            TableInfo table = tableInfo(context);
            return new SQL()
                    .SELECT(table.getSelectColumns())
                    .FROM(table.getTableName())
                    .WHERE(Stream.of(table.getFields())
                            .filter(field -> value(criteria, field) != null)
                            .map(field -> columnName(field) + " = " + bindParameter(field))
                            .toArray(String[]::new)).ORDER_BY(table.getPrimaryKeyColumn() + " DESC").toString();
        }
    }

    class CountByCriteriaSqlProvider extends SqlProviderSupport {
        public String sql(Object criteria, ProviderContext context) {
            TableInfo table = tableInfo(context);
            return new SQL()
                    .SELECT("COUNT(*)")
                    .FROM(table.getTableName())
                    .WHERE(Stream.of(table.getFields())
                            .filter(field -> value(criteria, field) != null)
                            .map(field -> columnName(field) + " = " + bindParameter(field)).toArray(String[]::new))
                    .toString();
        }
    }

    class CountSqlProvider extends SqlProviderSupport {
        public String sql(Object criteria, ProviderContext context) {
            TableInfo table = tableInfo(context);
            return new SQL()
                    .SELECT("COUNT(*)")
                    .FROM(table.getTableName())
                    .toString();
        }
    }

}

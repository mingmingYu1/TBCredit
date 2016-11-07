package com.yodata.core.dao;

import com.yodata.core.domain.Page;
import com.yodata.core.mybatis.MyBatisPojo;
import com.yodata.core.mybatis.MybatisTemplate;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

/**
 * 封装的 mytatis通用dao泛型基类
 * Created by jiangnan on 15-8-17.
 */
public interface SimpleMybatisDao<T extends MyBatisPojo,PK extends Serializable> {
    /**
     * 新增对象.
     */
    @InsertProvider(type = MybatisTemplate.class ,method = "insert")
    long insert(final T entity) ;

    /**
     * 保存修改的对象.
     */
    @UpdateProvider(type = MybatisTemplate.class,method = "update")
    long update(final T entity);

    /**
     * 删除对象.
     *
     * @param entity 对象必须是session中的对象
     */
    @DeleteProvider(type = MybatisTemplate.class,method = "deleteByPrimaryKey")
    long deleteByPrimaryKey(final T entity);

    /**
     * 按id获取对象.
     */
    @SelectProvider(type = MybatisTemplate.class,method = "select")
    @ResultMap(value = "BaseResultMap")
    T select(final T entity);
    /**
     * 按id获取list对象.
     */
    @SelectProvider(type = MybatisTemplate.class,method = "selectList")
    @ResultMap(value = "BaseResultMap")
    List<T> selectList(final T entity);

    /**
     * 查询分页list 查询使用 参数a=#{a}
     * 用于分页查询list
     * @param entity
     * @return
     */
    @SelectProvider(type = MybatisTemplate.class,method = "selectPage")
    @ResultMap(value = "BaseResultMap")
    List<T> selectPage(@Param("page") final Page page,@Param("entity") final T entity);
    /**
     * 查询count 查询使用 参数a=#{a}
     * 用于分页查询count
     * @param entity
     * @return
     */
    @SelectProvider(type = MybatisTemplate.class,method = "selectCount")
    long selectCount(@Param("entity") final T entity);


//    T get
//
//    /**
//      * 获取全部对象,支持排序.
//      */
//    @SelectProvider(type = MybatisTemplate.class,method = "getAllSort")
//    List<T> getAllBySort(String orderBy, boolean isAsc);
//
//    /**
//     * 获取全部对象.
//     */
//    List<T> getAll();
//
//    /**
//     * 按属性查找对象列表,匹配方式为相等.
//     */
//    List<T> findBy(final String propertyName, final Object value);
//
//    /**
//     * 查询page分页结果
//     * @param hql
//     * @param page
//     * @param args
//     * @return
//     */
//    Page<T> pageQueryData(String hql,Page page,Object ... args);
//
//    /**
//     * 按属性查找唯一对象,匹配方式为相等.
//     */
//    public T findUniqueBy(final String propertyName, final Object value) {
//        org.springframework.util.Assert.hasText(propertyName, "propertyName不能为空");
//        Criterion criterion = Restrictions.eq(propertyName, value);
//        return (T) this.createCriteria(criterion).uniqueResult();
//    }
//
//    /**
//     * 功能: 根据HQL查询条目总数
//     *
//     * @param hql
//     * @param values
//     * @return int 创建时间:2011-5-10 18:09:47
//     */
//    public int findCount(final String hql, final Object... values) {
//        return Integer.parseInt(createQuery(hql, values).uniqueResult().toString());
//    }
//
//    /**
//     * 按id列表获取对象.
//     */
//    public List<T> findByIds(List<PK> ids) {
//        return find(Restrictions.in(getIdName(), ids));
//    }
//
//    /**
//     * 按HQL查询对象列表.
//     *
//     * @param values 数量可变的参数,按顺序绑定.
//     */
//    public <X> List<X> find(final String hql, final Object... values) {
//        return createQuery(hql, values).list();
//    }
//
//    /**
//     * 按HQL查询对象列表.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public <X> List<X> find(final String hql, final Map<String, ?> values) {
//        return createQuery(hql, values).list();
//    }
//
//    /**
//     * 按HQL查询唯一对象.
//     *
//     * @param values 数量可变的参数,按顺序绑定.
//     */
//    public <X> X findUnique(final String hql, final Object... values) {
//        return (X) createQuery(hql, values).uniqueResult();
//    }
//
//    /**
//     * 按HQL查询唯一对象.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public <X> X findUnique(final String hql, final Map<String, ?> values) {
//        return (X) createQuery(hql, values).uniqueResult();
//    }
//
//    /**
//     * 执行HQL进行批量修改/删除操作.
//     */
//    public int batchExecute(final String hql, final Object... values) {
//        return createQuery(hql, values).executeUpdate();
//    }
//
//    /**
//     * 执行HQL进行批量修改/删除操作.
//     *
//     * @return 更新记录数.
//     */
//    public int batchExecute(final String hql, final Map<String, ?> values) {
//        return createQuery(hql, values).executeUpdate();
//    }
//
//    /**
//     * 执行HQL进行批量修改/删除操作.
//     */
//    public int batchExecute(final String hql, final Map<String, ?> map, final Map<String, ?> likeMap) {
//        return getQuery(hql, map, likeMap, null).executeUpdate();
//    }
//
//    /**
//     * 根据查询HQL与参数列表创建Query对象.
//     * <p/>
//     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
//     *
//     * @param values 数量可变的参数,按顺序绑定.
//     */
//    public Query createQuery(final String queryString, final Object... values) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        Query query = getSession().createQuery(queryString);
//        if (values != null) {
//            for (int i = 0; i < values.length; i++) {
//                query.setParameter(i, values[i]);
//            }
//        }
//        return query;
//    }
//
//    /**
//     * 根据查询HQL与参数列表创建Query对象.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public Query createQuery(final String queryString,
//                             final Map<String, ?> values) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        Query query = getSession().createQuery(queryString);
//        if (values != null) {
//            query.setProperties(values);
//        }
//        return query;
//    }
//
//    /**
//     * 根据查询HQL与参数列表创建Query对象.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public Query getQuery(final String queryString,
//                          final Map<String, ?> values, final Map<String, ?> isLike,
//                          String orderByName) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//        // 一般查询
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//
//                sql.append(" = ");
//                sql.append(":");
//                sql.append(key);
//
//            }
//
//        }
//        // 模糊查询
//        for (Map.Entry<String, ?> entry : isLike.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//
//                sql.append(" like ");
//                sql.append(":");
//                sql.append(key);
//
//            }
//
//        }
//        if (StringUtils.isNotBlank(orderByName)) {
//            sql.append(" ORDER BY t." + orderByName);
//        }
//        Query query = getSession().createQuery(sql.toString());
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//
//                query.setParameter(key, value);
//            }
//        }
//        for (Map.Entry<String, ?> entry : isLike.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                query.setParameter(key, "%" + value + "%");
//            }
//        }
//        return query;
//    }
//
//    /**
//     * 根据查询HQL与参数列表创建Query对象.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public Query getQuery(final String queryString,
//                          final Map<String, ?> values, String orderByName) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//
//                sql.append("=");
//                sql.append(":");
//                sql.append(key);
//
//            }
//
//        }
//        if (StringUtils.isBlank(orderByName)) {
//            sql.append(" ORDER BY t." + orderByName);
//        }
//        Query query = getSession().createQuery(sql.toString());
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                query.setParameter(key, value);
//            }
//        }
//
//        return query;
//    }
//
//    /**
//     * 根据查询HQL与参数列表创建Query对象.
//     *
//     * @param values 命名参数,按名称绑定.
//     */
//    public Query getSqlQuery(final String queryString,
//                             final Map<String, ?> values) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//                sql.append("=");
//                sql.append(":");
//                sql.append(key);
//
//            }
//
//        }
//        Query query = getSession().createSQLQuery(sql.toString());
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                query.setParameter(key, value);
//            }
//        }
//
//        return query;
//    }
//
//    /**
//     * 按Criteria查询对象列表.
//     *
//     * @param criterions 数量可变的Criterion.
//     */
//    public List<T> find(final Criterion... criterions) {
//        return this.createCriteria(criterions).list();
//    }
//
//    /**
//     * 按Criteria查询唯一对象.
//     *
//     * @param criterions 数量可变的Criterion.
//     */
//    public T findUnique(final Criterion... criterions) {
//        return (T) this.createCriteria(criterions).uniqueResult();
//    }
//
//    /**
//     * 根据Criterion条件创建Criteria.
//     * <p/>
//     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
//     *
//     * @param criterions 数量可变的Criterion.
//     */
//    public Criteria createCriteria(final Criterion... criterions) {
//        Criteria criteria = getSession().createCriteria(entityClass);
//        for (Criterion tempCriterion : criterions) {
//            criteria.add(tempCriterion);
//        }
//        return criteria;
//    }
//
//    /**
//     * 初始化对象. 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
//     * 只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性. 如需初始化关联属性,可实现新的函数,执行:
//     * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
//     * Hibernate.initialize
//     * (user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
//     */
//    public void initEntity(T entity) {
//        Hibernate.initialize(entity);
//    }
//
//    /**
//     * @see #initEntity(Object)
//     */
//    public void initEntity(List<T> entityList) {
//        for (T entity : entityList) {
//            Hibernate.initialize(entity);
//        }
//    }
//
//    /**
//     * Flush当前Session.
//     */
//    public void flush() {
//        getSession().flush();
//    }
//
//    /**
//     * 为Query添加distinct transformer.
//     */
//    public Query distinct(Query query) {
//        query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
//        return query;
//    }
//
//    /**
//     * 为Criteria添加distinct transformer.
//     */
//    public Criteria distinct(Criteria criteria) {
//        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
//        return criteria;
//    }
//
//    /**
//     * 取得对象的主键名.
//     */
//    public String getIdName() {
//        ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
//        return meta.getIdentifierPropertyName();
//    }
//
//    /**
//     * 取得对象的主键名.
//     */
//    public String getIdName(Class entityClass) {
//        ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
//        return meta.getIdentifierPropertyName();
//    }
//
//    /**
//     * 执行原生的sql语句修改操作
//     *
//     * @param sqlStr
//     * @return
//     */
//    public int executeUpdateSQL(String sqlStr) {
//        int count = getSession().createSQLQuery(sqlStr).executeUpdate();
//        flush();
//        return count;
//    }
//
//    /**
//     * 用原始的SQL进行查询
//     * @param queryString 查询的SQL
//     * @param values 查询的所有的属性值
//     * @param isLike 所有模糊查询的属性的Key--Value
//     * @return
//     */
//    public Query getSqlQuery(final String queryString,final Map<String, ?> values, final Map<String, ?> isLike) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//
//        // 一般查询
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//
//                sql.append(" =");
//                sql.append(":");
//                sql.append(key);
//
//            }
//
//        }
//        // 模糊查询
//        if (!isLike.isEmpty() && isLike != null) {
//            boolean is = false;
//            for (Map.Entry<String, ?> entry : isLike.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                if (value != null && StringUtils.isNotBlank(value.toString())) {
//                    if (is) {
//                        sql.append(" Or ");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append(":");
//                        sql.append(key);
//                    } else {
//                        sql.append(" And ");
//                        sql.append("(");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append(":");
//                        sql.append(key);
//                        is = true;
//                    }
//                }
//            }
//            sql.append(")");
//        }
//        Query query = getSession().createSQLQuery(sql.toString());
//        for (Map.Entry<String, ?> entry : values.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//
//                query.setParameter(key, value);
//            }
//        }
//        for (Map.Entry<String, ?> entry : isLike.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//
//                query.setParameter(key, "%" + value + "%");
//            }
//        }
//
//        return query;
//    }
//
//    /**
//     * 获取执行原始sql的query
//     *
//     * @param sql
//     * @return
//     */
//    public Query getSQLQuery(String sql) {
//        return getSession().createSQLQuery(sql);
//    }
//
//    public Query getSQLQuery(String sql,Object ... args){
//        Query query=getSession().createSQLQuery(sql);
//        if (args!=null&&args.length>0){
//            for (int i=0;i<args.length;i++){
//                query.setParameter(i+1,args[i]);
//            }
//        }
//        return query;
//    }
//    public Query getHqlQuery(final String queryString, final Map<String, ?> map, final Map<String, ?> likeMap,String orderBy) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//        // 一般查询
//        for (Map.Entry<String, ?> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                if (value.equals("null")) {
//                    sql.append(" And ");
//                    sql.append("t." + key);
//                    sql.append(" is null ");
//                } else {
//                    sql.append(" And ");
//                    sql.append("t." + key);
//                    sql.append(" =" + value);
//                }
//            }
//        }
//        if (!likeMap.isEmpty()) {
//            boolean is = false;
//            for (Map.Entry<String, ?> entry : likeMap.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                if (value != null && StringUtils.isNotBlank(value.toString())) {
//                    if (is) {
//                        sql.append(" Or ");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append("'%" + value + "%'");
//                    } else {
//                        sql.append(" And ");
//                        sql.append("(");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append("'%" + value + "%'");
//                        is = true;
//                    }
//                }
//            }
//            sql.append(")");
//        }
//        if (null != orderBy && (!orderBy.isEmpty())) {
//            sql.append(" order by t." + orderBy + " desc");
//        }
//        Query query = getSession().createQuery(sql.toString());
//        return query;
//    }
//
//    public Query getHqlQuery(final String queryString, final Map<String, ?> map, final Map<String, ?> orLikeMap, final Map<String, ?> andLikeMap, String orderBy) {
//        org.springframework.util.Assert.hasText(queryString, "queryString不能为空");
//        StringBuffer sql = new StringBuffer(queryString);
//        // 一般查询
//        for (Map.Entry<String, ?> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//                sql.append(" =" + value);
//            }
//        }
//        for (Map.Entry<String, ?> entry : andLikeMap.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (value != null && StringUtils.isNotBlank(value.toString())) {
//                sql.append(" And ");
//                sql.append("t." + key);
//                sql.append(" like ");
//                sql.append("'%" + value + "%'");
//            }
//        }
//        if (!orLikeMap.isEmpty()) {
//            boolean is = false;
//            for (Map.Entry<String, ?> entry : orLikeMap.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                if (value != null && StringUtils.isNotBlank(value.toString())) {
//                    if (is) {
//                        sql.append(" Or ");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append("'%" + value + "%'");
//                    } else {
//                        sql.append(" And ");
//                        sql.append("(");
//                        sql.append("t." + key);
//                        sql.append(" like ");
//                        sql.append("'%" + value + "%'");
//                        is = true;
//                    }
//                }
//            }
//            sql.append(") ");
//        }
//        if (null != orderBy && (!orderBy.isEmpty())) {
//            sql.append(" order by t." + orderBy + " desc");
//        }
//        Query query = getSession().createQuery(sql.toString());
//        return query;
//    }
//
//    public Query pageQuery(Query query,Page page){
////        if (threadLocal.get().get("page")==null)throw new NullPointerException("查询的Page参数为空");
////        Page page= (Page) threadLocal.get().get("page");
//        query.setFirstResult(page.getCurrent()*page.getCountPerPage()-page.getCountPerPage());
//        query.setMaxResults(page.getCountPerPage());
//        return query;
//    }
//
//    public Page<T> pageQueryData(String hql,Page page,Object ... args){
//        Query query=createQuery(hql, args);
//        query.setFirstResult(page.getCurrent()*page.getCountPerPage()-page.getCountPerPage());
//        query.setMaxResults(page.getCountPerPage());
//        page.setDate(query.list());
//        return page;
//    }
}

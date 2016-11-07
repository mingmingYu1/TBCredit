package com.yodata.core.util;

/**
 * Created by zheng.liu@baifendian on 2015-07-09.
 */

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 反射工具类.
 *
 * 提供访问私有变量,获取泛型类型Class, 提取集合中元素的属性, 转换字符串到对象等Util函数.
 *
 */
public class ReflectionUtils
{
    private static final Log logger = LogFactory.getLog(ReflectionUtils.class);

    static
    {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setUseLocaleFormat(true);
        dateConverter.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
        ConvertUtils.register(dateConverter, Date.class);
    }

    /**
     * 调用Getter方法.
     */
    public static Object invokeGetterMethod(Object target, String propertyName)
    {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(target, getterMethodName, new Class[] {}, new Object[] {});
    }

    /**
     * 调用Setter方法.使用value的Class来查找Setter方法.
     */
    public static void invokeSetterMethod(Object target, String propertyName, Object value)
    {
        invokeSetterMethod(target, propertyName, value, null);
    }

    /**
     * 调用Setter方法.
     *
     * @param propertyType
     *            用于查找Setter方法,为空时使用value的Class替代.
     */
    public static void invokeSetterMethod(Object target, String propertyName, Object value, Class<?> propertyType)
    {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(target, setterMethodName, new Class[] { type }, new Object[] { value });
    }

    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     */
    public static Object getFieldValue(final Object object, final String fieldName)
    {
        Field field = getDeclaredField(object, fieldName);

        if (field == null)
        {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        }

        makeAccessible(field);

        Object result = null;
        try
        {
            result = field.get(object);
        }
        catch (IllegalAccessException exception)
        {
            logger.error(exception.getMessage());
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     */
    public static void setFieldValue(final Object object, final String fieldName, final Object value)
    {
        Field field = getDeclaredField(object, fieldName);

        if (field == null)
        {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        }

        makeAccessible(field);

        try
        {
            field.set(object, value);
        }
        catch (IllegalAccessException exception)
        {
            logger.error(exception.getMessage());
        }
    }

    /**
     * 直接调用对象方法, 无视private/protected修饰符.
     */
    public static Object invokeMethod(final Object object, final String methodName, final Class<?>[] parameterTypes, final Object[] parameters)
    {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (method == null)
        {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        }

        method.setAccessible(true);

        try
        {
            return method.invoke(object, parameters);
        }
        catch (Exception exception)
        {
            throw convertReflectionExceptionToUnchecked(exception);
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField.
     *
     * 如向上转型到Object仍无法找到, 返回null.
     */
    protected static Field getDeclaredField(final Object object, final String fieldName)
    {
        org.springframework.util.Assert.notNull(object, "object不能为空");
        org.springframework.util.Assert.hasText(fieldName, "fieldName");
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass())
        {
            try
            {
                return superClass.getDeclaredField(fieldName);
            }
            catch (NoSuchFieldException exception)
            {
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 强行设置Field可访问.
     */
    protected static void makeAccessible(final Field field)
    {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()))
        {
            field.setAccessible(true);
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredMethod.
     *
     * 如向上转型到Object仍无法找到, 返回null.
     */
    protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes)
    {
        org.springframework.util.Assert.notNull(object, "object不能为空");

        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass())
        {
            try
            {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            }
            catch (NoSuchMethodException exception)
            {
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. eg. public UserDao
     * extends HibernateDao<User>
     *
     * @param clazz
     *            The class to introspect
     * @return the first generic declaration, or Object.class if cannot be
     *         determined
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperClassGenricType(final Class clazz)
    {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     *
     * 如public UserDao extends HibernateDao<User,Long>
     *
     * @param clazz
     *            clazz The class to introspect
     * @param index
     *            the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     *         determined
     */
    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenricType(final Class clazz, final int index)
    {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType))
        {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0)
        {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class))
        {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成List.
     * @param collection 来源集合.
     * @param propertyName 要提取的属性名.
     */
    @SuppressWarnings("unchecked")
    public static List convertElementPropertyToList(final Collection collection, final String propertyName)
    {
        List list = new ArrayList();

        try
        {
            for (Object obj : collection)
            {
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        }
        catch (Exception exception)
        {
            throw convertReflectionExceptionToUnchecked(exception);
        }

        return list;
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串.
     *
     * @param collection
     *            来源集合.
     * @param propertyName
     *            要提取的属性名.
     * @param separator
     *            分隔符.
     */
    @SuppressWarnings("unchecked")
    public static String convertElementPropertyToString(final Collection collection, final String propertyName, final String separator)
    {
        List list = convertElementPropertyToList(collection, propertyName);
        return StringUtils.join(list, separator);
    }

    /**
     * 转换字符串到相应类型.
     *
     * @param value
     *            待转换的字符串
     * @param toType
     *            转换目标类型
     */
    public static Object convertStringToObject(String value, Class<?> toType)
    {
        try
        {
            return ConvertUtils.convert(value, toType);
        }
        catch (Exception exception)
        {
            throw convertReflectionExceptionToUnchecked(exception);
        }
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception exception)
    {
        if (exception instanceof IllegalAccessException || exception instanceof IllegalArgumentException || exception instanceof NoSuchMethodException)
        {
            return new IllegalArgumentException("Reflection Exception.", exception);
        }
        else if (exception instanceof InvocationTargetException)
        {
            return new RuntimeException("Reflection Exception.", ((InvocationTargetException) exception).getTargetException());
        }
        else if (exception instanceof RuntimeException)
        {
            return (RuntimeException) exception;
        }
        return new RuntimeException("Unexpected Checked Exception.", exception);
    }
    /**
     * 将source对象的属性合并到target属性上
     * 属性相同用source的覆盖target的属性
     * @param source
     * @param target
     */
    public static void copyPriperties(Object source, Object target) {
        String fileName, str, getName, setName;
        List<Field> fields = new ArrayList<Field>();
        Method getMethod = null;
        Method setMethod = null;
        try {
            Class<?> c1 = source.getClass();
            Class<?> c2 = target.getClass();
            Field[] fs1 = c1.getDeclaredFields();
            Field[] fs2 = c2.getDeclaredFields();
            // 两个类属性比较剔除不相同的属性，只留下相同的属性
            for (int i = 0; i < fs2.length; i++) {
                for (int j = 0; j < fs1.length; j++) {
                    if (fs1[j].getName().equals(fs2[i].getName())) {
                        fields.add(fs1[j]);
                        break;
                    }
                }
            }
            if (null != fields && fields.size() > 0) {
                for (int i = 0; i < fields.size(); i++) {
                    // 获取属性名称
                    Field f = (Field) fields.get(i);
                    fileName = f.getName();
                    // 属性名第一个字母大写
                    str = fileName.substring(0, 1).toUpperCase();
                    // 拼凑getXXX和setXXX方法名
                    getName = "get" + str + fileName.substring(1);
                    setName = "set" + str + fileName.substring(1);
                    // 获取get、set方法
                    getMethod = c1.getMethod(getName, new Class[] {});
                    setMethod = c2.getMethod(setName,
                            new Class[] { f.getType() });
                    // 获取属性值
                    Object o = getMethod.invoke(source, new Object[] {});
                    if (null != o) {
                        setMethod.invoke(target, new Object[] { o });
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

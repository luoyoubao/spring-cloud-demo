package org.xunmeng.dao;

import java.util.List;

public interface IBaseDao<E> {
    public abstract int update(String paramString, Object paramObject);

    public abstract int save(String paramString, Object paramObject);

    public abstract int deleteById(String paramString, Object paramObject);

    public abstract E getById(String paramString, Object paramObject);

    public abstract Object selectOne(String paramString);

    public abstract Object selectOne(String paramString, Object paramObject);

    public abstract List<E> selectList(String paramString);

    public abstract List<E> selectList(String paramString, Object paramObject);
}
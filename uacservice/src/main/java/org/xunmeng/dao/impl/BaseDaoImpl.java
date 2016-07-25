package org.xunmeng.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xunmeng.dao.IBaseDao;

@Repository(value = "baseDao")
public class BaseDaoImpl<E> implements IBaseDao<E> {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int update(String paramString, Object paramObject) {
        return sqlSessionTemplate.update(paramString, paramObject);
    }

    @Override
    public int save(String paramString, Object paramObject) {
        return sqlSessionTemplate.insert(paramString, paramObject);
    }

    @Override
    public int deleteById(String paramString, Object paramObject) {
        return sqlSessionTemplate.delete(paramString, paramObject);
    }

    @Override
    public E getById(String paramString, Object paramObject) {
        return sqlSessionTemplate.selectOne(paramString, paramObject);
    }

    @Override
    public Object selectOne(String paramString) {
        return sqlSessionTemplate.selectOne(paramString);
    }

    @Override
    public Object selectOne(String paramString, Object paramObject) {
        return sqlSessionTemplate.selectOne(paramString, paramObject);
    }

    @Override
    public List<E> selectList(String paramString) {
        return sqlSessionTemplate.selectList(paramString);
    }

    @Override
    public List<E> selectList(String paramString, Object paramObject) {
        return sqlSessionTemplate.selectList(paramString, paramObject);
    }
}
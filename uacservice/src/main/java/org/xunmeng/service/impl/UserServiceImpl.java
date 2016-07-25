package org.xunmeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xunmeng.dao.IBaseDao;
import org.xunmeng.model.Product;
import org.xunmeng.model.User;
import org.xunmeng.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IBaseDao baseDao;

    @Override
    public void display() {
        System.out.println("=======display========");
    }

    @Override
    @Transactional
    public void saveUser(User user, Product product) {
        baseDao.save("saveUser", user);
        baseDao.save("saveProduct", product);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        baseDao.save("saveUser", user);
    }
}
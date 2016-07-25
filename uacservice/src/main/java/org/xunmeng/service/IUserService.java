package org.xunmeng.service;

import org.xunmeng.model.Product;
import org.xunmeng.model.User;

public interface IUserService {
    void display();

    public void saveUser(User user, Product product);

    public void saveUser(User user);
}
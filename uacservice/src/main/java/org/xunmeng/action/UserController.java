package org.xunmeng.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xunmeng.model.User;
import org.xunmeng.service.IUserService;
import org.xunmeng.util.JsonUtil;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    public String add(@RequestBody User user) {
        if (null == user.getName() || "".equals(user.getName())) {
            return "error";
        }

        System.err.println("========>" + JsonUtil.beanToString(user));
        // userService.saveUser(user);
        return "success";
    }

    @RequestMapping("/user/{name}")
    public String save(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);

        System.err.println("==================name:" + name);

        // System.out.println("hello,world");
        //
        // Product product = new Product();
        // product.setName("ipad");
        //
        // userService.saveUser(user, product);
        // System.out.println("save user success.");
        return "luoyoub";
    }
}
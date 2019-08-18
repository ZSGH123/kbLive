package com.kblive.usersystem.web.controller.user;
                                                                
import javax.annotation.Resource;

import com.kblive.usersystem.model.user.KbliveUser;
import com.kblive.usersystem.services.user.IUserService;
import com.kblive.usersystem.services.user.KbliveUserService;
import com.kblive.usersystem.web.api.base.BaseController;
import com.kblive.usersystem.web.api.response.WebResponse;
import com.kblive.usersystem.web.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  KbliveUser Controller
 * @author zhong qiang
 * @since 2019-07-13
 */
@Controller
@RequestMapping(value="kbliveUser")
public class KbliveUserController extends BaseController {

    @Resource
    KbliveUserService kbliveUserService;

    @Qualifier("userService2")
    @Autowired
    IUserService userService;

    @Autowired
    IUserService userService1;

    @Autowired
    List<IUserService> list;

    @Autowired
    @Qualifier("car")
    Car car;

    @RequestMapping(value = "check")
    @ResponseBody
    public WebResponse check() {
        WebResponse webResponse = new WebResponse();
        webResponse.setData(kbliveUserService.test());
        return webResponse;
    }

    /**
     * 保存
     * RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的),Content-Type一定是：application/json，否则报415错误
     */
    @RequestMapping(value="saveKbliveUser")
    @ResponseBody
    public WebResponse saveKbliveUser(@RequestParam(value = "userName", required = true) String name, @RequestParam String sex, @RequestBody(required = false) KbliveUser kbliveUser) throws Exception {
        WebResponse webResponse = new WebResponse();
        KbliveUser kbliveUserS = getKbliveUser();
        System.out.println(name);
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("name", name);
        resMap.put("sex", sex);
        resMap.put("kbliveUser", kbliveUser);
        webResponse.setData(resMap);
        return webResponse;
    }

    @RequestMapping(value = "testKbliveUser")
    @ResponseBody
    public WebResponse testKbliveUser(@RequestParam(value = "userName", required = true) String name, @RequestParam(required = false) KbliveUser kbliveUser) throws Exception {
        WebResponse webResponse = new WebResponse();
        System.out.println(name);
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("name", name);
        resMap.put("kbliveUser", kbliveUser);
        webResponse.setData(resMap);
        return webResponse;
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public WebResponse test(@RequestParam(value = "userName", required = true) String name, @RequestParam String sex) throws Exception {
        WebResponse webResponse = new WebResponse();
        System.out.println(name);
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("name", name);
        resMap.put("sex", sex);
        webResponse.setData(resMap);
        return webResponse;
    }
    @RequestMapping(value = "tologin") //③处理方法对应的URL，相对于②处的URL
    public String toLogin(Model model) {
        System.out.println("去登陆页面"+model);
        return "/login"; //④返回逻辑视图名
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping(value="getKbliveUserList")
    @ResponseBody
    public WebResponse getKbliveUserList () throws Exception {
        WebResponse webResponse = new WebResponse();
        //TODO 接下来尽情的实现你的业务逻辑。

        return webResponse;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value="delKbliveUser")
    @ResponseBody
    public WebResponse delKbliveUser () throws Exception {
        WebResponse webResponse = new WebResponse();
        //TODO 接下来尽情的实现你的业务逻辑。

        return webResponse;
    }

}

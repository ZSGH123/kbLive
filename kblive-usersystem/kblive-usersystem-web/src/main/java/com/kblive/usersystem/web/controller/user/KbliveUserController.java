package com.kblive.usersystem.web.controller.user;
                                                                
import javax.annotation.Resource;

import com.kblive.usersystem.model.user.KbliveUser;
import com.kblive.usersystem.services.user.KbliveUserService;
import com.kblive.usersystem.web.api.base.BaseController;
import com.kblive.usersystem.web.api.response.WebResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 保存
     */
    @RequestMapping(value="saveKbliveUser")
    @ResponseBody
    public WebResponse saveKbliveUser () throws Exception {
        WebResponse webResponse = new WebResponse();
        KbliveUser kbliveUser=getKbliveUser();

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

package com.nari.jjsd.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangbo on 2018/12/9.
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "user/login";
    }
}

package com.nari.jjsd.permission.controller.user;

import com.nari.jjsd.permission.controller.BaseController;
import com.nari.jjsd.core.shiro.token.manger.TokenManager;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.permission.service.UserService;
import com.nari.jjsd.util.commom.LoggerUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yangbo on 2018/12/6.
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("u")
public class UserLoginController  extends BaseController {
    @Autowired
    private UserService userService;


    /**
     * 登录跳转
     *
     * @return
     */

    @RequestMapping(value={"/login"} , method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    /**
     * 登录
     * @param user 实体类
     * @param remeberMe 是否记住我
     * @param request
     * @return
     */
    @RequestMapping(value = "submitLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object submitLogin(User user, Boolean remeberMe, HttpServletRequest request) {
        try {
            // user =userService.login(user.getEmail(),user.getPswd());

           User loginInfo = TokenManager.login(user, remeberMe);

            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
            //获取登录之前的地址
//            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//            String url = null;
//            if (savedRequest != null) {
//                url = savedRequest.getRequestUrl();
//            }
//            LoggerUtils.fmtDebug(getClass(), "获取登录之前的URL:[%s]", url);
            //如果登录之前没有地址，那么跳转到首页
//            if (StringUtils.isBlank(url)) {
//                url = "/"+request.getContextPath() + "user/index";
//            }
//            resultMap.put("back_url", url);
        } catch (DisabledAccountException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "账户已经禁用");
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "账户或密码错误");
        }

        return resultMap;
    }


    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method =RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> logout(){
        try {
            TokenManager.logout();
            resultMap.put("status", 200);
        } catch (Exception e) {
            resultMap.put("status", 500);
            logger.error("errorMessage:" + e.getMessage());
            LoggerUtils.fmtError(getClass(), e, "退出出现错误，%s。", e.getMessage());
        }
        return resultMap;
    }



}

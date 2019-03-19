package com.nari.jjsd.business.controller.sysem.team;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Team;
import com.nari.jjsd.business.model.Uteam;
import com.nari.jjsd.business.service.UteamService;
import com.nari.jjsd.business.service.TeamService;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.ConstUtil;
import com.nari.jjsd.util.commom.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangbo on 2019/3/13.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private UteamService uteamService;

    /**
     * 跳转到岗位管理
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("system/team/index");
        return modelAndView;
    }

    /**
     * 查询岗位管理List
     *
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getTeamPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamPage(Integer page, Integer limit, Team team) throws Exception {
        EntityWrapper<Team> entityWrapper = new EntityWrapper<>();
        if (team.getTName() != null && team.getTName() != "") {
            entityWrapper.like("T_NAME", team.getTName());
        }
        teamService.selectPage(new Page<>(page, limit));
        Page<Team> rolePage = teamService.selectPage(new Page<>(page, limit), entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }

    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getad", method = RequestMethod.GET)
    public ModelAndView getad(Integer page, Integer limit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("extrawork/workovertime/add");
        //查询角色信息如果前台传值为空
        return modelAndView;
    }

    /**
     * 用户添加更新方法
     *
     * @param team
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Team team) {
// 组员列表
        String uids = team.getTeamsid();
        if (StringUtil.isEmpty(uids)) {
            //  return j;
        }
        teamService.insert(team);

        List<Team> list = new ArrayList<Team>();
        String[] uArr = uids.split(",");
        for (int i = 0; i < uArr.length; i++) {

            if (team.getTLeadId() != null && team.getTLeadId().equals(uArr[i])) {
                continue;
            }
            Uteam uteam = new Uteam();
            uteam.setuId(uArr[i]);
            uteam.settId(team.getTId());
            uteamService.insert(uteam);
        }
        Uteam leduteam = new Uteam();
        leduteam.setuId(team.getTLeadId());
        leduteam.settId(team.getTId());
        leduteam.setLeadFlag(ConstUtil.Y_FLAG);
        int count = uteamService.insertUteam(leduteam);

        return count > 0 ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }


    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getupdate", method = RequestMethod.GET)
    public ModelAndView getupdate(Integer page, Integer limit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("system/team/update");
        //查询角色信息如果前台传值为空
        return modelAndView;
    }

    /**
     * 岗位删除
     * @param id
     * @return
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id){

        boolean b = teamService.deleteById(id);
        return b? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE):APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }



    @RequestMapping(value = "selectUser", method = RequestMethod.GET)
    public ModelAndView selectUser(Integer page, Integer limit, String type) throws Exception {
        ModelAndView modelAndView = new ModelAndView("system/user/selectUser");
        modelAndView.addObject("type", type);
        //查询角色信息如果前台传值为空
        return modelAndView;
    }

}

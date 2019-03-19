package com.nari.jjsd.business.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.service.TypeService;
import com.nari.jjsd.business.service.ProjectService;
import com.nari.jjsd.permission.controller.BaseController;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.permission.model.Permission;
import com.nari.jjsd.permission.service.PermissionService;
import com.nari.jjsd.permission.service.RoleService;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.ExcelExportSXXSSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yb
 * @since 2018-12-17
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private TypeService typeService;


    /**
     * 跳转到工程资料
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("business/project/index");
        List<TSType> type= typeService.findType("4028b8815707ab5101570863aea50006");
        List<TSType> schedule= typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type",type);
        modelAndView.addObject("schedule",schedule);
        return modelAndView;
    }


    @RequestMapping(value = "getProjectPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getProjectPage(Integer page, Integer limit ,Project project) {
        project = project != null ? project : new Project();
        EntityWrapper<Project> entityWrapper = new EntityWrapper<>();
        if(project.getPjName()!=null&&project.getPjName()!=""){
            entityWrapper.like("PJ_NAME", project.getPjName());
        }
        if(project.getCurPsId()!=null&&project.getCurPsId()!=""){
            entityWrapper.eq("CUR_PS_ID",project.getCurPsId());
        }
        if(project.getPjStatus()!=null&&project.getPjStatus()!=""){
            entityWrapper.eq("PJ_STATUS",project.getPjStatus());
        }
        if(project.getStartTime()!=null){
            entityWrapper.ge("START_TIME",project.getStartTime());
        }
        if(project.getEndTime()!=null){
          // entityWrapper.ge("END_TIME",project.getEndTime());
        }



        Page<Project> rolePage =projectService.selectPage(new Page<>(page, limit), entityWrapper);

      //  Page<Project> rolePage =projectService.selectProjecPage(page,limit,entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;

    }


    /**
     * 跳转到角色编辑页面
     *
     * @param id 角色id
     * @return
     */
    @RequestMapping(value = "goUpdate", method = RequestMethod.GET)
    public ModelAndView goUpdate(String id) {
        ModelAndView modelAndView = new ModelAndView("business/project/update");
        //查询角色信息
        Project role=projectService.selectById(id);
        modelAndView.addObject("role", role);
        List<TSType> type= typeService.findType("4028b8815707ab5101570863aea50006");
        List<TSType> schedule= typeService.findType("4028b8815707ab510157086967910010");
        List<Permission> permissions = permissionService.selectList(null);
        modelAndView.addObject("permissions",permissions);
        modelAndView.addObject("type",type);
        modelAndView.addObject("schedule",schedule);

        return modelAndView;
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Project project) {
        int count = projectService.updaateById(project);
        return count > 0 ? APPUtil.resultMapType(APPUtil.UPDATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.UPDATE_ERROR_TYPE);
    }

    /**
     * 跳转到添加工程资料
     *
     * @return
     */
    @RequestMapping(value = "goAdd", method = RequestMethod.GET)
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView("business/project/add");
        List<Permission> permissions = permissionService.selectList(null);
        modelAndView.addObject("permissions",permissions);
        List<TSType> type= typeService.findType("4028b8815707ab5101570863aea50006");
        List<TSType> schedule= typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type",type);
        modelAndView.addObject("schedule",schedule);
        return modelAndView;
    }

    /**
     * 角色添加方法
     *
     * @param project

     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Project project) {
        int count = projectService.insertProject(project);
        return count > 0 ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }

    /**
     * 角色删除
     * @param id
     * @return
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id){
        boolean b = projectService.deleteById(id);
        return b? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE):APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Object checkdelete(Project project,String  ids){
        String a[] = ids.split(",");
        try{
            for (int i = 0; i < a.length; i++) {
                String id = a[i];
                projectService.deleteById(id);
              //  map.put("code", 1);
            }
        }catch (Exception e) {
            e.printStackTrace();
          //  map.put("code", -1);
        }
           return  APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE);
    }





    /**
     * 查询
     */

    @RequestMapping(value = "queryproject",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryproject(
            @RequestParam(value="name") String pjname,
            @RequestParam(value="pj_status") String pjstatus,
            @RequestParam(value="cur_PsId") String curPsId,
            @RequestParam(value="start_time") String starttime,
            Integer page, Integer limit){
        EntityWrapper<Project> entityWrapper = new EntityWrapper<>();
        entityWrapper.like("PJ_NAME", pjname);
        entityWrapper.eq("PJ_STATUS",pjstatus);
        entityWrapper.ge("START_TIME",starttime);

        Project project=new Project();
        project.setPjName(pjname);
        project.setCurPsId(curPsId);
        project.setPjStatus(pjstatus);
       Page<Project> rolePage =projectService.selectProjecPage(page,limit,project);


       // Page<Project> rolePage =projectService.selectPage(new Page<>(page, limit), entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }


    /**
     * 批量删除
     */
    @RequestMapping(value = "queryproject1",method = RequestMethod.POST)
    @ResponseBody
    public Object export( String pjstatus, String pjname,Integer page, Integer limit)throws Exception{
        // 调用封装类执行导出
        // 导出文件存放的路径，并且是虚拟目录指向的路径
        // String filePath = "d:/upload/linshi/";
        //改为从系统参数配置表获取参数值
        String filePath = "d:/upload/linshi/";
                //systemConfigService.findBasicinfoById("00301").getValue();
        // 导出文件的前缀
        String filePrefix = "ypxx";
        // -1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
        int flushRows = 10;

        // 定义导出数据的title
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("工程名称");
        fieldNames.add("工程状态");
        //指导导出数据的title
        // 告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
        List<String> fieldCodes = new ArrayList<String>();
        fieldCodes.add("pjName");// 药品流水号
        fieldCodes.add("pjStatus");// 通用名


        // 上边的代码可以优化为，将title和title对应的 pojo的属性，使用map存储
        // ....

        // 注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应

        // 开始导出，执行一些workbook及sheet等对象的初始创建
        ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
        // 导出的数据通过service取出
      EntityWrapper<Project> entityWrapper = new EntityWrapper<>();
       entityWrapper.like("PJ_NAME", pjname);
       entityWrapper.eq("PJ_STATUS",pjstatus);
     //   entityWrapper.ge("START_TIME",starttime);
   //    projectService.selectPage(new Page<>(page, limit));
   //    projectService.selectList(entityWrapper);
    List<Project> list=   projectService.selectList(null);

    //    List<Project> menuList = projectService.selectList(new EntityWrapper<Project>().like("PJ_NAME", pjname).eq("PJ_STATUS",pjstatus));



        //执行导出
        excelExportSXXSSF.writeDatasByObject(list);
      //  List<YpxxCustom> list = ypxxService.findYpxxList(ypxxQueryVo);
        // 输出文件，返回下载文件的http地址，已经包括虚拟目录
        String webpath = excelExportSXXSSF.exportFile();

        System.out.println(webpath);

        return null;
     //   return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
     //           Config.MESSAGE, 313, new Object[] {
     //                   list.size(),
     //                   //下载地址
     //                   webpath
    //            }));
    }



}


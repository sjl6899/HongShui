package club.hongshui.controller;

import club.hongshui.domain.Site;
import club.hongshui.service.SiteService;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import club.hongshui.util.ResponseUtil;
import club.hongshui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private Site site;
    @Autowired
    private SiteService siteService;
    //删除
    @GetMapping("delete")
    public ResponseUtil delete(@RequestParam("id") String id){
        int delete=siteService.delete(id);
        if (delete==1) return ResponseUtil.bulidSuccess("success",true,"成功！");
        return ResponseUtil.bulidError("error");
    }

    @PostMapping("/add.do")
    public Result add(@RequestBody Site site){

        try{
            siteService.addsite(site);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, "新增失败！");
        }
        return  new Result(true, "新增成功！");
    }
    //修改
    @RequestMapping("/update")
    public Result edit(@RequestBody Site site){
        try{
            siteService.setting(site);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, "编辑失败！");
        }
        return  new Result(true, "编辑成功！");
    }
    //查询
    @GetMapping("select")
    public ResponseUtil select(){
        return ResponseUtil.bulidSuccess(siteService.vselect(),true,"成功！");
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = siteService.pageQuery(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            Site site = siteService.findById(id);
            return  new Result(true, "查询成功！",site);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false,"查询失败！" );
        }
    }
}

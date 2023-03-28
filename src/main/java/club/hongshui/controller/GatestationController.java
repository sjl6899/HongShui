package club.hongshui.controller;

import club.hongshui.domain.Gatestation;
import club.hongshui.domain.Site;
import club.hongshui.service.GatestationService;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import club.hongshui.util.ResponseUtil;
import club.hongshui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//雨量站
@RequestMapping("/gatestation")
public class GatestationController {

    @Autowired
    private GatestationService gatestationService;
    //删除
    @GetMapping("delete")
    public ResponseUtil delete(@RequestParam("id") String id){
        int delete=gatestationService.delete(id);
        if (delete==1) return ResponseUtil.bulidSuccess("success",true,"成功！");
        return ResponseUtil.bulidError("error");
    }
    //添加
    @PostMapping("/add")
    public Result add(@RequestBody Gatestation gatestation){

        try{
            gatestationService.addgate(gatestation);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, "新增失败！");
        }
        return  new Result(true, "新增成功！");
    }
    //修改
    @RequestMapping("/update")
    public Result edit(@RequestBody Gatestation gatestation){
        try{
            gatestationService.setting(gatestation);
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
        return ResponseUtil.bulidSuccess(gatestationService.vselect(),true,"成功！");
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = gatestationService.pageQuery(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            Gatestation gatestation = gatestationService.findById(id);
            return  new Result(true, "查询成功！",gatestation);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false,"查询失败！" );
        }
    }
}

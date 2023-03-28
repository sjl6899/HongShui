package club.hongshui.controller;

import club.hongshui.domain.Gatestation;
import club.hongshui.domain.Site;
import club.hongshui.service.GatestationService;
import club.hongshui.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//雨量站
@RequestMapping("/gatestation")
public class GatestationController {
    @Autowired
    private Gatestation gatestation;
    @Autowired
    private GatestationService gatestationService;
    //删除
    @GetMapping("delete")
    public ResponseUtil delete(@RequestParam("gatestationname") String gatestationname){
        int delete=gatestationService.delete(gatestationname);
        if (delete==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //添加
    @GetMapping("add")
    public ResponseUtil add(String gatestationname,String longitude,String latitude,String maxcapacity){
        gatestation.setGatestationname(gatestationname);
        gatestation.setLatitude(latitude);
        gatestation.setLongitude(longitude);
        gatestation.setMaxcapacity(maxcapacity);
        int add=gatestationService.addgate(gatestation);
        if (add==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //修改
    @GetMapping("update")
    public ResponseUtil update(String gatestationname,String longitude,String latitude,String maxcapacity){
        gatestation.setGatestationname(gatestationname);
        gatestation.setLatitude(latitude);
        gatestation.setLongitude(longitude);
        gatestation.setMaxcapacity(maxcapacity);
        int setting=gatestationService.setting(gatestation);
        if (setting==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //查询
    @GetMapping("select")
    public ResponseUtil select(){
        return ResponseUtil.bulidSuccess(gatestationService.vselect());

    }
}

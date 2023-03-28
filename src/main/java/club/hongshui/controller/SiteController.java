package club.hongshui.controller;

import club.hongshui.domain.Site;
import club.hongshui.service.SiteService;
import club.hongshui.util.ResponseUtil;
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
    public ResponseUtil delete(@RequestParam("rainsitename") String rainsitename){
        int delete=siteService.delete(rainsitename);
        if (delete==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //添加
    @GetMapping("add")
    public ResponseUtil add(String rainsitename,String longitude,String latitude){
        Site site=new Site();
        site.setRainsitename(rainsitename);
        site.setLatitude(latitude);
        site.setLongitude(longitude);
        int add=siteService.addsite(site);
        if (add==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //修改
    @GetMapping("update")
    public ResponseUtil update(String rainsitename,String longitude,String latitude){
        Site site=new Site();
        site.setRainsitename(rainsitename);
        site.setLatitude(latitude);
        site.setLongitude(longitude);
        int setting=siteService.setting(site);
        if (setting==1) return ResponseUtil.bulidSuccess("success");
        return ResponseUtil.bulidError("error");
    }
    //查询
    @GetMapping("select")
    public ResponseUtil select(){
        return ResponseUtil.bulidSuccess(siteService.vselect());
    }
}

package club.hongshui.controller;

import club.hongshui.domain.Data;
import club.hongshui.mapper.DataMapper;
import club.hongshui.service.DataService;
import club.hongshui.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
//查询24h数据
@RequestMapping("/data")
public class DataController {
    @Autowired
    private Data data;
    @Autowired
    private DataService dataService;
    //八桥
    @GetMapping("bqselect")
    public ResponseUtil bqselect(){
        return ResponseUtil.bulidSuccess(dataService.bqselect());
    }
    //赤羊
    @GetMapping("cyselect")
    public ResponseUtil cyselect(){
        return ResponseUtil.bulidSuccess(dataService.cyselect());
    }
    //北山
    @GetMapping("bsselect")
    public ResponseUtil bscyselect(){
        return ResponseUtil.bulidSuccess(dataService.bsselect());
    }
    //双丰
    @GetMapping("sfselect")
    public ResponseUtil sfselect(){
        return ResponseUtil.bulidSuccess(dataService.sfselect());
    }
    //盘龙
    @GetMapping("plselect")
    public ResponseUtil plselect(){
        return ResponseUtil.bulidSuccess(dataService.plselect());
    }
    //中山
    @GetMapping("zsselect")
    public ResponseUtil zsselect(){
        return ResponseUtil.bulidSuccess(dataService.zsselect());
    }
    //马鞍山
    @GetMapping("masselect")
    public ResponseUtil masselect(){ return ResponseUtil.bulidSuccess(dataService.masselect()); }
    //仙源
    @GetMapping("xyselect")
    public ResponseUtil xyselect(){
        return ResponseUtil.bulidSuccess(dataService.xyselect());
    }
    //白象
    @GetMapping("bxselect")
    public ResponseUtil bxselect(){
        return ResponseUtil.bulidSuccess(dataService.bxselect());
    }
    //缙云
    @GetMapping("jyselect")
    public ResponseUtil jyselect(){
        return ResponseUtil.bulidSuccess(dataService.jyselect());
    }
    //壶镇
    @GetMapping("hzselect")
    public ResponseUtil hzselect(){
        return ResponseUtil.bulidSuccess(dataService.hzselect());
    }
    //东方
    @GetMapping("dfselect")
    public ResponseUtil dfselect(){
        return ResponseUtil.bulidSuccess(dataService.dfselect());
    }
    //仙都
    @GetMapping("xdselect")
    public ResponseUtil xdselect(){
        return ResponseUtil.bulidSuccess(dataService.xdselect());
    }
}

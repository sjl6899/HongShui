package club.hongshui.controller;

import club.hongshui.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
//洪汛模拟计数
@RequestMapping("/calculation")
public class CalculationController {
    @Autowired
    private DataService dataService;
    //2019年模拟
    @GetMapping("calculation2019")
    public double[] calculation2019(){
        double x1,x2,x3;
        x1=dataService.Thzselectseven();
        x2=dataService.Tdfselectseven();
        x3=dataService.Txdselectseven();
        double result[]={x1,x2,x3};
        return result;
    }
    //2020年模拟
    @GetMapping("calculation2020")
    public double[] calculation2020(){
        double x1,x2,x3;
        x1=dataService.Thzselectsixt();
        x2=dataService.Tdfselectsixt();
        x3=dataService.Txdselectsixt();
        double result[]={x1,x2,x3};
        return result;
    }
    //2021年 6月21
    @GetMapping("calculation2021")
    public double[] calculation2021(){
        double x1,x2,x3;
        x1=dataService.Thzselectsix();
        x2=dataService.Tdfselectsix();
        x3=dataService.Txdselectsix();
        double result[]={x1,x2,x3};
        return result;
    }
}

package club.hongshui.controller;

import club.hongshui.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
//洪汛模拟计数
@RequestMapping("/calculation")
public class CalculationController {
    @Autowired
    private DataService dataService;
    //2019年模拟 7.16
    @GetMapping("calculation2019")
    public double calculation2019(double max,double x1,double x2,double x3){
        double x11,x22,x33,fin;
        x11=dataService.Thzselectseven()-x1;
        x22=dataService.Tdfselectseven()-x2;
        x33=dataService.Txdselectseven()-x3;
        fin=13.65+0.844*x11+0.387*x22+0.069*x33+0.0002*x11*x11+0.00004*x11*x22-0.0004*x11*x33+0.0003*x22*x22-0.0007*x22*x33+0.0005*x33*x33;
        return 535.57-max+fin;
    }
    //2020年 6月19
    @GetMapping("calculation2020")
    public double calculation2020(double max,double x1,double x2,double x3){
        double x11,x22,x33,fin;
        x11=dataService.Thzselectsixt()-x1;
        x22=dataService.Tdfselectsixt()-x2;
        x33=dataService.Txdselectsixt()-x3;
        fin=13.65+0.844*x11+0.387*x22+0.069*x33+0.0002*x11*x11+0.00004*x11*x22-0.0004*x11*x33+0.0003*x22*x22-0.0007*x22*x33+0.0005*x33*x33;
        return 259.48-max+fin;
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

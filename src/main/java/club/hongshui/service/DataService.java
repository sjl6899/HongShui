package club.hongshui.service;

import club.hongshui.domain.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataService {
    List<String> bqselect();
    List<String> cyselect();
    List<String> bsselect();
    List<String> sfselect();
    List<String> plselect();
    List<String> zsselect();
    List<String> masselect();
    List<String> xyselect();
    List<String> bxselect();
    List<String> jyselect();
    List<String> hzselect();
    List<String> dfselect();
    List<String> xdselect();
    double Txdselectseven();
    double Tdfselectseven();
    double Thzselectseven();
    double Txdselectsix();
    double Tdfselectsix();
    double Thzselectsix();
    double Txdselectsixt();
    double Tdfselectsixt();
    double Thzselectsixt();
}

package club.hongshui.mapper;

import club.hongshui.domain.Data;
import club.hongshui.domain.Site;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {
    @Select("SELECT baqiao FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> bqselect();
    @Select("SELECT chiyang FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> cyselect();
    @Select("SELECT beishan FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> bsselect();
    @Select("SELECT shuangfeng FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> sfselect();
    @Select("SELECT panlong FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> plselect();
    @Select("SELECT zhongshan FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> zsselect();
    @Select("SELECT maanshan FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> masselect();
    @Select("SELECT xianyuan FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> xyselect();
    @Select("SELECT baixiang FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> bxselect();
    @Select("SELECT jiyunhedao FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> jyselect();
    @Select("SELECT huzhenhedao FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> hzselect();
    @Select("SELECT dongfanghedao FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> dfselect();
    @Select("SELECT xianduhedao FROM data WHERE year=2021 AND month=7 AND (day=30 OR day=29 AND time >8 )")
    List<String> xdselect();
    @Select("SELECT xianduhedao FROM data WHERE year=2019 AND month=7 AND day=16 AND time=20")
    double Txdselectseven();
    @Select("SELECT dongfanghedao FROM data WHERE year=2019 AND month=7 AND day=16 AND time=20")
    double Tdfselectseven();
    @Select("SELECT huzhenhedao FROM data WHERE year=2019 AND month=7 AND day=16 AND time=20")
    double Thzselectseven();
    @Select("SELECT xianduhedao FROM data WHERE year=2021 AND month=6 AND day=19 AND time=15")
    double Txdselectsix();
    @Select("SELECT dongfanghedao FROM data WHERE year=2021 AND month=6 AND day=19 AND time=15")
    double Tdfselectsix();
    @Select("SELECT huzhenhedao FROM data WHERE year=2021 AND month=6 AND day=19 AND time=15")
    double Thzselectsix();
    @Select("SELECT xianduhedao FROM data WHERE year=2020 AND month=6 AND day=21 AND time=22")
    double Txdselectsixt();
    @Select("SELECT dongfanghedao FROM data WHERE year=2020 AND month=6 AND day=21 AND time=22")
    double Tdfselectsixt();
    @Select("SELECT huzhenhedao FROM data WHERE year=2020 AND month=6 AND day=21 AND time=22")
    double Thzselectsixt();
}

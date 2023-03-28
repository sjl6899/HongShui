package club.hongshui.mapper;

import club.hongshui.domain.Gatestation;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GatestationMapper {
    @Delete("DELETE FROM gatestation WHERE id = #{id}")
    int delete(String gatestationname);
    @Insert("INSERT INTO `gatestation`(id,gatestationname,longitude,latitude,maxcapacity) VALUES(#{gatestation.id},#{gatestation.gatestationname},#{gatestation.longitude},#{gatestation.latitude},#{gatestation.maxcapacity})")
    int addgate(@Param("gatestation") Gatestation gatestation);
    @Update("update gatestation set id=#{gatestation.id},gatestationname=#{gatestation.gatestationname},longitude=#{gatestation.longitude},latitude=#{gatestation.latitude},maxcapacity=#{gatestation.maxcapacity} where gatestationname=#{gatestation.gatestationname}")
    int setting(@Param("gatestation") Gatestation gatestation);
    @Select("SELECT * FROM gatestation")
    Page<Gatestation> vselect();
    @Select("SELECT * FROM gatestation WHERE id = #{id}")
    Gatestation findById(Integer id);
}

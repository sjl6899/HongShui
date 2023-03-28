package club.hongshui.mapper;

import club.hongshui.domain.Gatestation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GatestationMapper {
    @Delete("DELETE FROM gatestation WHERE gatestationname = #{gatestationname}")
    int delete(String gatestationname);
    @Insert("INSERT INTO `gatestation`(gatestationname,longitude,latitude,maxcapacity) VALUES(#{gatestation.gatestationname},#{gatestation.longitude},#{gatestation.latitude},#{gatestation.maxcapacity})")
    int addgate(@Param("gatestation") Gatestation gatestation);
    @Update("update gatestation set gatestationname=#{gatestation.gatestationname},longitude=#{gatestation.longitude},latitude=#{gatestation.latitude},maxcapacity=#{gatestation.maxcapacity} where gatestationname=#{gatestation.gatestationname}")
    int setting(@Param("gatestation") Gatestation gatestation);
    @Select("SELECT * FROM gatestation")
    List<Gatestation> vselect();
}

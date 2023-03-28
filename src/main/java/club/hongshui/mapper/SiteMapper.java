package club.hongshui.mapper;

import club.hongshui.domain.Site;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SiteMapper {
    @Delete("DELETE FROM site WHERE rainsitename = #{rainsitename}")
    int delete(String rainsitename);
    @Insert("INSERT INTO `site`(rainsitename,longitude,latitude) VALUES(#{site.rainsitename},#{site.longitude},#{site.latitude})")
    int addsite(@Param("site")Site site);
    @Update("update site set rainsitename=#{site.rainsitename},longitude=#{site.longitude},latitude=#{site.latitude} where rainsitename=#{site.rainsitename}")
    int setting(@Param("site") Site site);
    @Select("SELECT * FROM site")
    List<Site> vselect();
}

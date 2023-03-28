package club.hongshui.mapper;

import club.hongshui.domain.Site;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SiteMapper {
    @Delete("DELETE FROM site WHERE id = #{id}")
    int delete(String rainsitename);
    @Insert("INSERT INTO `site`(id,rainsitename,longitude,latitude) VALUES(#{site.id},#{site.rainsitename},#{site.longitude},#{site.latitude})")
    int addsite(@Param("site")Site site);
    @Update("update site set id=#{site.id},rainsitename=#{site.rainsitename},longitude=#{site.longitude},latitude=#{site.latitude} where id=#{site.id}")
    int setting(@Param("site") Site site);
    @Select("SELECT * FROM site")
    Page<Site> vselect();
    @Select("SELECT * FROM site WHERE id = #{id}")
    Site findById(Integer id);
}

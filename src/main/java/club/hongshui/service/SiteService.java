package club.hongshui.service;

import club.hongshui.domain.Site;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SiteService {
    int delete(String rainsitename);
    int addsite(@Param("site") Site site);
    int setting(@Param("site") Site site);
    List<Site> vselect();
}

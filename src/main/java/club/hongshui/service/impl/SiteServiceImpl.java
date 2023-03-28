package club.hongshui.service.impl;

import club.hongshui.domain.Site;
import club.hongshui.mapper.SiteMapper;
import club.hongshui.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteMapper siteMapper;
    @Override
    public int delete(String rainsitename) {
        int i=siteMapper.delete(rainsitename);
        return i;
    }

    @Override
    public int addsite(Site site) {
        return siteMapper.addsite(site);
    }

    @Override
    public int setting(Site site) {
        return siteMapper.setting(site);
    }

    @Override
    public List<Site> vselect() {
        return siteMapper.vselect();
    }
}

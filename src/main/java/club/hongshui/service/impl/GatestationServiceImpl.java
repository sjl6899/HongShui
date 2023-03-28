package club.hongshui.service.impl;

import club.hongshui.domain.Gatestation;
import club.hongshui.mapper.GatestationMapper;
import club.hongshui.service.GatestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatestationServiceImpl implements GatestationService {
    @Autowired
    private GatestationMapper gatestationMapper;
    @Override
    public int delete(String gatestationname) {
        return gatestationMapper.delete(gatestationname);
    }

    @Override
    public int addgate(Gatestation gatestation) {
        return gatestationMapper.addgate(gatestation);
    }

    @Override
    public int setting(Gatestation gatestation) {
        return gatestationMapper.setting(gatestation);
    }

    @Override
    public List<Gatestation> vselect() {
        return gatestationMapper.vselect();
    }
}

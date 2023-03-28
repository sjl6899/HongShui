package club.hongshui.service;

import club.hongshui.domain.Gatestation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GatestationService {
    int delete(String gatestationname);
    int addgate(@Param("gatestation") Gatestation gatestation);
    int setting(@Param("gatestation") Gatestation gatestation);
    List<Gatestation> vselect();
}

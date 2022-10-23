package dev.JonKramme.ipuniinfo.service;

import com.google.common.net.InetAddresses;
import dev.JonKramme.ipuniinfo.model.IpInfoDTO;
import dev.JonKramme.ipuniinfo.model.IpInfoDatabaseDTO;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpInfoService {

    private final IpInfoRepository repository;

    public IpInfoService(IpInfoRepository repository) {
        this.repository = repository;
    }

    private IpInfoDatabaseDTO saveIpInfo(IpInfoDTO entity) throws Exception{
        return repository.save(new IpInfoDatabaseDTO(entity));
    }

    private boolean validate(String ipv4Address) {
        // IPv4 Validation using Guava
        return InetAddresses.isInetAddress(ipv4Address);
    }

    public IpInfoDTO request(String ipv4Address) throws Exception  {
        if (!validate(ipv4Address)) {
            throw new IllegalArgumentException("Invalid IPv4 Address");
        }

        String url = "https://ipinfo.io/" + ipv4Address + "/geo";

        RestTemplate restTemplate = new RestTemplate();
        IpInfoDTO IpInfoEntity = restTemplate.getForObject(url, IpInfoDTO.class);

        saveIpInfo(IpInfoEntity);

        return IpInfoEntity;
    }
}

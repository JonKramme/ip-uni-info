package dev.JonKramme.ipuniinfo.service;

import com.google.common.net.InetAddresses;
import dev.JonKramme.ipuniinfo.model.IpInfo;
import dev.JonKramme.ipuniinfo.repository.IpInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpInfoService {

    private final IpInfoRepository repository;

    public IpInfoService(IpInfoRepository repository) {
        this.repository = repository;
    }

    private IpInfo saveIpInfo(IpInfo entity){
        return repository.save(entity);
    }


    private boolean validate(String ipv4Address) {
        // IPv4 Validation using Guava
        return InetAddresses.isInetAddress(ipv4Address);
    }
    public IpInfo request(String ipv4Address) {
        if (!validate(ipv4Address)) {
            throw new IllegalArgumentException("Invalid IPv4 Address");
        } else {
            String url = "https://ipinfo.io/" + ipv4Address + "/geo";
            RestTemplate restTemplate = new RestTemplate();

            IpInfo entity = restTemplate.getForObject(url, IpInfo.class);
            //TODO: DB Audit Insert
            saveIpInfo(entity);
            //TODO: return Data;
            return entity;
        }
    }
}

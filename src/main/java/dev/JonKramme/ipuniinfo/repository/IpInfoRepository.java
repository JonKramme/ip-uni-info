package dev.JonKramme.ipuniinfo.repository;

import dev.JonKramme.ipuniinfo.model.IpInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpInfoRepository extends CrudRepository<IpInfo,Long> {
}

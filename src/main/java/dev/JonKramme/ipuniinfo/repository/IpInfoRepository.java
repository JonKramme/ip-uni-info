package dev.JonKramme.ipuniinfo.repository;

import dev.JonKramme.ipuniinfo.model.IpInfoDTO;
import dev.JonKramme.ipuniinfo.model.IpInfoDatabaseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpInfoRepository extends MongoRepository<IpInfoDatabaseDTO,String> {
}

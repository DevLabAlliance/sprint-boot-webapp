package com.luxoft.mapetrenko.sboot.service;

import com.luxoft.mapetrenko.sboot.entity.Data;
import com.luxoft.mapetrenko.sboot.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    @Qualifier("dataRepository")
    private DataRepository dataRepository;

    @Override
    public boolean persist(String problem) {
        Data data = new Data(UUID.randomUUID(), problem);

        try {
            dataRepository.persist(data);
            return true;
        } catch (Exception e) {
            LOG.error("Cant save data: " + e.getMessage(), e);
            return false;
        }


    }

    @Override
    public Set<String> getRandomData() {
        return dataRepository.getRandomData();
    }
}

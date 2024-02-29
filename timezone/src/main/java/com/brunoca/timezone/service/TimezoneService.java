package com.brunoca.timezone.service;

import com.brunoca.timezone.domain.MyZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimezoneService {
    @Autowired
    private ZoneRepository zoneRepository;
    private static final Logger log = LoggerFactory.getLogger(TimezoneService.class);

    public List<MyZone> getMyZones() {
        List<MyZone> myZones = zoneRepository.findAll();
        myZones.forEach(z -> log.info(z.toString()));
        return myZones;
    }

}

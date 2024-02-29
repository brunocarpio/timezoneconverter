package com.brunoca.timezone.service;

import com.brunoca.timezone.domain.MyZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<MyZone, Long> {
}

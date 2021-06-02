package admin.service;

import admin.dao.domain.Corporation;

import java.util.List;

public interface CorporationService {
    Corporation findById(Long id);
    List<Corporation> findAll();
    List<String> getAllCorporationName();
}

package admin.service;

import admin.dao.domain.Corporation;
import admin.dao.repo.CorporationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CorporationServiceImpl implements CorporationService{

    private CorporationRepository corporationRepository;

    @Autowired
    public void setCorporationRepository(CorporationRepository corporationRepository){
        this.corporationRepository = corporationRepository;
    }
    @Override
    public Corporation findById(Long id) {
        return corporationRepository.getById(id);
    }

    @Override
    public List<Corporation> findAll() {
        return corporationRepository.findAll();
    }

    @Override
    public List<String> getAllCorporationName() {
        return corporationRepository.getAllCorporationName();
    }
}

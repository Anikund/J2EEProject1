package admin.dao.repo;

import admin.dao.domain.Corporation;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CorporationRepository extends CrudRepository<Corporation, Long> {
    List<Corporation> findAll();

    /**
     * Get all corporation names
     * @return ArrayList<String>
     */
    default ArrayList<String> getAllCorporationName(){
        ArrayList results = new ArrayList();
        List<Corporation> all = this.findAll();
        for(Corporation c : all){
            String name = c.getName();
            if(!results.contains(name)){
                results.add(name);
            }
        }
        return results;
    }

    Corporation getById(Long id);



}

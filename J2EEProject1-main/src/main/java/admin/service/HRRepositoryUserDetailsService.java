package admin.service;

import admin.dao.domain.HR;
import admin.dao.repo.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HRRepositoryUserDetailsService implements UserDetailsService {

    private HRRepository hrRepository;
    @Autowired
    public HRRepositoryUserDetailsService(HRRepository hrRepository){
        this.hrRepository = hrRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        HR hr = hrRepository.findByUsername(s);
        if(hr != null){
            return hr;
        }else{
            throw new UsernameNotFoundException("Username" + s + " not found!");
        }
    }
}

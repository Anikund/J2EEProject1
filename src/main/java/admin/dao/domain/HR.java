package admin.dao.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
public class HR implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    private String company;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(username.equals("admin")){
            return Arrays.asList(new SimpleGrantedAuthority("Admin_USER"), new SimpleGrantedAuthority("HR_USER"));
        }
        return Arrays.asList(new SimpleGrantedAuthority("HR_USER"));
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }


}

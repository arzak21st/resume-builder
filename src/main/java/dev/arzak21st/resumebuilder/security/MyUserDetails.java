
package dev.arzak21st.resumebuilder.security;

import dev.arzak21st.resumebuilder.models.User;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // The User authority is of type String, but the UserDetails authority is of type Collection of GrantedAuthority
        // So we need to somehow convert our String authority into a GrantedAuthority authority
        String userAuthority = user.getAuthority();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userAuthority); // Takes in an authority of type String

        // Then we return this GrantedAuthority as a Collection (e.g. List)
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}

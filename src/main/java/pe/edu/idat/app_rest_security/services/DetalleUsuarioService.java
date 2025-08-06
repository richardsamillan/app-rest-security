package pe.edu.idat.app_rest_security.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_rest_security.model.Usuario;
import pe.edu.idat.app_rest_security.repository.UsuarioRepository;

import java.util.List;

@Service
public class DetalleUsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public DetalleUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findById(username)
                .orElse(null);
        if(usuario == null){
            throw  new UsernameNotFoundException(
                    "Usuario no encontrado");
        }
        return new User(usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(),
                true,
                true,
                true,
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }

}

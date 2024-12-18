package ifrn.pi.vendasperfumes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ifrn.pi.vendasperfumes.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

		Usuario findByEmail(String email);
		
	}


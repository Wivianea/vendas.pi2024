package ifrn.pi.vendasperfumes.models;

import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Papel implements GrantedAuthority {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String nome;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return nome;
		}
		public void setName(String nome) {
			this.nome = nome;
		}
   
		public String getAuthority() {
			// TODO Auto-generated method stub
			return this.nome;
		}
	}
	
	


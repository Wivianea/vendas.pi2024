package ifrn.pi.vendasperfumes.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;



	@Entity
	public class Pedido {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne
		private Usuario cliente;
		
		@ManyToMany
		private List<Item> itens;
		private Double valortotal;
		private LocalDate data;
		private LocalTime horario;
		private String endereco;
		
		public LocalTime getHorario() {
			return horario;
		}

		public void setHorario(LocalTime horario) {
			this.horario = horario;
		}
		
		public void pegarHorario() {
			this.horario = LocalTime.now();
		}

		public List<Item> getItens() {
			return itens;
		}

		public void setItens(List<Item> itens) {
			this.itens = itens;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Usuario getCliente() {
			return cliente;
		}

		public void setCliente(Usuario cliente) {
			this.cliente = cliente;
		}

		public Double getValortotal() {
			return valortotal;
		}

		public void setValortotal(Double valortotal) {
			this.valortotal = valortotal;
		}
		
		public void calcularValor(List<Item> itens) {
			
			for(Item item : itens) {
				this.valortotal = valortotal + item.getPreco();
			}
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}
		
		public void pegarData() {
			this.data = LocalDate.now();
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		@Override
		public String toString() {
			return "Pedido [id=" + id + ", cliente=" + cliente + ", itens=" + itens + ", valortotal=" + valortotal
					+ ", data=" + data + ", endereco=" + endereco + "]";
		}
		
	}

	



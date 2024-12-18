package ifrn.pi.vendasperfumes.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ifrn.pi.vendasperfumes.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findByStatus(boolean status);
	List<Item> findBySelecionado(boolean selecionado);
}
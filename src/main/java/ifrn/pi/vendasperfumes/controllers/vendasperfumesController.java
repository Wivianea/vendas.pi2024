package ifrn.pi.vendasperfumes.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ifrn.pi.vendasperfumes.models.Item;
import ifrn.pi.vendasperfumes.models.Pedido;
import ifrn.pi.vendasperfumes.repositories.ItemRepository;
import ifrn.pi.vendasperfumes.repositories.PedidoRepository;
import ifrn.pi.vendasperfumes.repositories.UsuarioRepository;

@Controller
@RequestMapping("/vendasperfumes")
public class vendasperfumesController {
	
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private ItemRepository ir;
	
	@Autowired
	private PedidoRepository pr;
	
	
	
	@GetMapping("/vendasperfumes/home")
	public ModelAndView form() {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/home");
		List<Item> itens = ir.findAll();
		md.addObject(itens);
		
		return md;
	}
	
	@GetMapping("/vendasperfumes/addItem")
	public ModelAndView form(Item item) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/itensAdd");
		List<Item> itens = ir.findAll();
		md.addObject("itens", itens);
		
		return md;
	}

	
	@GetMapping("/vendasperfumes/pedido")
	@PreAuthorize("hasRole('CLIENTE')")
	public ModelAndView pedido(Item pedido) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/pedido");
		List<Pedido> pedidos = pr.findAll();
		md.addObject("pedidos", pedidos);
		
		return md;
	}


	@GetMapping("/vendasperfumes/cadastro")
	@PreAuthorize("hasRole('CLIENTE')")
	public ModelAndView cadastro(Item cadastro) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/cadastro");
		List<Cadastro> cadastro = pr.findAll();
		md.addObject("cadastro", cadastro);
		
		return md;
	}
	
	@GetMapping("/vendasperfumes/cadastroespecial")
	@PreAuthorize("hasRole('CLIENTE')")
	public ModelAndView cadastroespecial(Item cadastro) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("vendasperfumes/cadastroespecial");
		List<Cadastroespecial> cadastroespecial = pr.findAll();
		md.addObject("cadastroespecial", cadastroespecial);
		
		return md;
	}
	
	@GetMapping("/vendasperfumes/listadepedidos")
	public ModelAndView form(Listadepedidos listadepedidos) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/listadepedidos");
		List<Item> itens = ir.findAll();
		md.addObject("listadepedidos", listadepedidos);
		
		return md;
	}
	
	@GetMapping("/vendasperfumes/login")
	public ModelAndView form(Login login) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/login");
		List<Item> itens = ir.findAll();
		md.addObject("login", login);
		
		return md;
	}
	
	@GetMapping("/vendasperfumes/menu")
	public ModelAndView form(Menu menu) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("/vendasperfumes/menu");
		List<Item> itens = ir.findAll();
		md.addObject("menu", menu);
		
		return md;
	}
	
	@Validated
	 public ModelAndView admin(@Valid Client admin, BindingResult result) {
          ModelAndView mv = new ModelAndView("login");

         String hashSenha = PasswordUtil.encoder(admin.getSenha());
        admin.setSenha(hashSenha);
       mv.addObject("admin", admin);

	 	if (result.hasErrors()) {
	 		return admin(admin);
	 	}
		
			ur.save(admin);
	 		System.out.println("admin Salvo!");
		

	 	return mv;
	
	
	
}
}


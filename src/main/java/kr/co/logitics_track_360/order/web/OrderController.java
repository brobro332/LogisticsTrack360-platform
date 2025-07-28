package kr.co.logitics_track_360.order.web;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.logitics_track_360.order.dto.ItemResponseDto;
import kr.co.logitics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderResponseDto;
import kr.co.logitics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryResponseDto;
import kr.co.logitics_track_360.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@GetMapping("/create.do")
	public String renderOrderCreatePage(Model model) {
	    return "order/create";
	}
	
	@GetMapping("/list.do")
	public String renderOrderListPage(Authentication authentication, @ModelAttribute OrderSearchRequestDto dto, Model model) {
		String userId = authentication.getName();
		for (GrantedAuthority authority : authentication.getAuthorities()) {
	        if ("ADMIN".equals(authority.getAuthority())) {
	        	userId = null;
	            break;
	        }
	    }
		
	    List<OrderResponseDto> orderList = service.selectOrderList(userId, dto);
		model.addAttribute("orderList", orderList);
	    
		return "order/list";
	}
	
	@GetMapping("/details.do")
	public String renderOrderDetailPage(@RequestParam String orderId, Model model) {
	    OrderResponseDto order = service.selectOrder(orderId);
	    List<ItemResponseDto> itemList = service.selectItemList(orderId);
	    List<OrderStatusHistoryResponseDto> historyList = service.selectStatusHistoryList(orderId);

	    model.addAttribute("order", order);
	    model.addAttribute("itemList", itemList);
	    model.addAttribute("historyList", historyList);

	    return "order/details";
	}
	
	@PostMapping("/create.do")
	public String createOrder(Authentication authentication, @ModelAttribute OrderCreateRequestDto dto) {
		String userId = authentication.getName();
		
		service.create(userId, dto);
	    return "redirect:/order/list.do";
	}
	
	@PostMapping("/status.do")
	public String updateOrderStatus(Authentication authentication, @ModelAttribute OrderStatusHistoryCreateRequestDto dto) {
		String userId = authentication.getName();
		
		service.updateOrderStatus(userId, dto);
	    return "redirect:/order/details.do?orderId=" + dto.getOrderId();
	}
}

package kr.co.logitics_track_360.order.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
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
	    return "order/form";
	}
	
	@GetMapping("/list.do")
	public String renderOrderListPage(@ModelAttribute OrderSearchRequestDto dto, Model model) {
	    List<OrderResponseDto> orderList = service.selectOrderList(dto);
		model.addAttribute("orderList", orderList);
	    return "order/list";
	}
	
	@GetMapping("/detail.do")
	public String renderOrderDetailPage(@RequestParam String orderId, Model model) {
	    OrderResponseDto order = service.selectOrder(orderId);
	    List<ItemResponseDto> items = service.selectItemList(orderId);
	    List<OrderStatusHistoryResponseDto> history = service.selectStatusHistoryList(orderId);

	    model.addAttribute("order", order);
	    model.addAttribute("items", items);
	    model.addAttribute("history", history);

	    return "order/detail";
	}
	
	@PostMapping("/create.do")
	public String createOrder(@ModelAttribute OrderCreateRequestDto dto) {
		service.create(dto);
	    return "redirect:/order/list.do";
	}
	
	@PatchMapping("/status.do")
	public String updateOrderStatus(@ModelAttribute OrderStatusHistoryCreateRequestDto dto) {
	    service.updateOrderStatus(dto);
	    return "redirect:/order/detail.do?orderId=" + dto.getOrderId();
	}
}

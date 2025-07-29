package kr.co.logitics_track_360.shipment.web;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.logitics_track_360.order.dto.OrderResponseDto;
import kr.co.logitics_track_360.order.service.OrderService;
import kr.co.logitics_track_360.shipment.dto.ShipmentCreateRequestDto;
import kr.co.logitics_track_360.shipment.dto.ShipmentResponseDto;
import kr.co.logitics_track_360.shipment.dto.ShipmentUpdateRequestDto;
import kr.co.logitics_track_360.shipment.service.ShipmentService;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
	private final ShipmentService service;
	private final OrderService orderService;
	
	public ShipmentController(ShipmentService service, OrderService orderService) {
		this.service = service;
		this.orderService = orderService;
	}
	
	@GetMapping("/create.do")
	public String renderCreatePage(@RequestParam(required = false) String orderId, Model model) {
	    model.addAttribute("orderId", orderId);
	    
	    return "shipment/create";
	}
	
	@GetMapping("/list.do")
    public String renderShipmentListPage(Model model) {
		List<OrderResponseDto> orderList = orderService.selectOrderListForDispatch();
        List<ShipmentResponseDto> shipmentList = service.selectShipmentList();
        
        model.addAttribute("orderList", orderList);
        model.addAttribute("shipmentList", shipmentList);
        
        return "shipment/list";
    }
	
	@GetMapping("/details.do")
    public String renderDetailsPage(@RequestParam Long shipmentId, Model model) {
        ShipmentResponseDto shipment = service.selectShipment(shipmentId);
        model.addAttribute("shipment", shipment);
        
        return "shipment/details";
    }
	
	@GetMapping("/update.do")
    public String renderUpdatePage(@RequestParam Long shipmentId, Model model) {
        ShipmentResponseDto shipment = service.selectShipment(shipmentId);
        model.addAttribute("shipment", shipment);
        
        return "shipment/update";
    }
    
    @PostMapping("/create.do")
    public String create(Authentication authentication, @ModelAttribute ShipmentCreateRequestDto dto) {
    	String userId = authentication.getName();
    	dto.setUpdatedBy(userId);
        service.create(dto);
        
        return "redirect:/shipment/list.do";
    }

    @PostMapping("/update.do")
    public String update(Authentication authentication, @ModelAttribute ShipmentUpdateRequestDto dto) {
    	String userId = authentication.getName();
    	dto.setUpdatedBy(userId);
        service.update(dto);
        
        return "redirect:/shipment/list.do";
    }
}

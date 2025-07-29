package kr.co.logistics_track_360.dispatch.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.logistics_track_360.dispatch.dto.DispatchCreateRequestDto;
import kr.co.logistics_track_360.dispatch.dto.DispatchResponseDto;
import kr.co.logistics_track_360.dispatch.service.DispatchService;
import kr.co.logistics_track_360.order.dto.OrderResponseDto;
import kr.co.logistics_track_360.order.service.OrderService;

@Controller
@RequestMapping("/dispatch")
public class DispatchController {
    private final DispatchService service;
    private final OrderService orderService;
    
    public DispatchController(DispatchService service, OrderService orderService) {
    	this.service = service;
    	this.orderService = orderService;
    }
    
    @GetMapping("/list.do")
    public String renderDispatchListPage(Model model) {
    	List<OrderResponseDto> orderList = orderService.selectOrderListForDispatch();
        List<DispatchResponseDto> dispatchList = service.select();

        model.addAttribute("orderList", orderList);
        model.addAttribute("dispatchList", dispatchList);

        return "dispatch/list";
    }

    @PostMapping("/create.do")
    public String create(
            Authentication authentication,
            @RequestParam(value = "selectedOrderIds", required = false) Long[] selectedOrderIds,
            @RequestParam(value = "warehouseNames", required = false) String[] warehouseNames) {

        String userId = authentication.getName();

        List<DispatchCreateRequestDto> dtoList = new ArrayList<>();

        for (int i = 0; i < selectedOrderIds.length; i++) {
            DispatchCreateRequestDto dto = new DispatchCreateRequestDto();
            dto.setOrderId(selectedOrderIds[i]);
            dto.setDispatcher(userId);
            dto.setWarehouseName((warehouseNames != null && warehouseNames.length > i) ? warehouseNames[i] : "기본창고");
            dto.setDispatchDate(LocalDate.now());
            dto.setSourceType("MANUAL");
            dto.setUpdatedBy(userId);

            dtoList.add(dto);
        }

        service.create(dtoList);

        return "redirect:/dispatch/list.do";
    }
}

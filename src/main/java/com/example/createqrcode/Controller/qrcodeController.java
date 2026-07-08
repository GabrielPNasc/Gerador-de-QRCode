package com.example.createqrcode.Controller;

import com.example.createqrcode.Service.qrcodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class qrcodeController {

    private final qrcodeService qrcodeService;

    public qrcodeController(qrcodeService qrcodeService) {
        this.qrcodeService = qrcodeService;
    }

    @GetMapping("/qrcode")
    public String home(){
            return "redirect:/qrcodescreen.html";
    }

    @ResponseBody
    @PostMapping("/qrcodecreation")
    public String link(@RequestBody String link) throws Exception {
        qrcodeService.criarqrCode(link);


            return "/qrcode.png";
    }
}

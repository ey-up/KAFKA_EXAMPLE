package com.kartaca.okur.controller;


import com.kartaca.okur.service.KartacaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Kartaca")
public class KartacaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KartacaController.class);

    private final KartacaService kartacaService;

    public KartacaController(KartacaService kartacaService) {
        this.kartacaService = kartacaService;
    }

    @GetMapping
    public String getInfo (){
        var info = kartacaService.getInfo();
        LOGGER.info(info);
        return info;
    }

    @PostMapping
    public String postInfo (){
        var info = kartacaService.postInfo();
        LOGGER.info(info);
        return info;
    }

    @PutMapping
    public String putInfo (){
        var info = kartacaService.putInfo();
        LOGGER.info(info);
        return info;
    }

    @DeleteMapping
    public String deleteInfo (){
        var info = kartacaService.deleteInfo();
        LOGGER.info(info);
        return info;
    }

}

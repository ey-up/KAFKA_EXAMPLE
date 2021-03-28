package com.kartaca.okur.service;

import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class KartacaService {

    public String getInfo() {
        var responseTime = randomWait();
        return "GET,"+responseTime+","+ System.currentTimeMillis();
    }

    public String putInfo() {
        var responseTime = randomWait();
        return "PUT,"+responseTime+","+ System.currentTimeMillis();
    }

    public String postInfo() {
        var responseTime = randomWait();
        return "POST,"+responseTime+","+ System.currentTimeMillis();
    }

    public String deleteInfo() {
        var responseTime = randomWait();
        return "DELETE,"+responseTime+","+ System.currentTimeMillis();
    }

    public int randomWait() {
        var responseTime = new Random().nextInt(3001);
        try {
            Thread.sleep(responseTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseTime;
    }
}

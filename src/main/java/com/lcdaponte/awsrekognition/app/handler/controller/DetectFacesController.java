package com.lcdaponte.awsrekognition.app.handler.controller;

import com.lcdaponte.awsrekognition.app.handler.response.FaceDetailsResponse;
import com.lcdaponte.awsrekognition.domain.usecase.DetectFaceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectFacesController {

    @Autowired
    private DetectFaceUseCase detectFaceUseCase;

    @RequestMapping(value = "/detect", method = RequestMethod.GET)
    public FaceDetailsResponse detectFaces(@RequestParam("imagePath") String imagePath){

        return detectFaceUseCase.detectFacesImage(imagePath);

    }
}

package com.lcdaponte.awsrekognition.domain.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcdaponte.awsrekognition.app.handler.response.AgeRange;
import com.lcdaponte.awsrekognition.app.handler.response.FaceDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class DetectFaceUseCase {

    @Autowired
    private RekognitionClient rekClient;

    public FaceDetailsResponse detectFacesImage(String sourceImage ) {
        ObjectMapper objectMapper = new ObjectMapper();
        String imagePath = "ADD YOUR IMAGE PATH HERE" + sourceImage;
        try {
            InputStream sourceStream = new FileInputStream(imagePath);
            SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

            // Create an Image object for the source image.
            Image souImage = Image.builder()
                    .bytes(sourceBytes)
                    .build();

            DetectFacesRequest facesRequest = DetectFacesRequest.builder()
                    .attributes(Attribute.ALL)
                    .image(souImage)
                    .build();

            DetectFacesResponse facesResponse = rekClient.detectFaces(facesRequest);
            List<FaceDetail> faceDetails = facesResponse.faceDetails();

            Optional<FaceDetail> optionalFaceDetail = faceDetails.stream().findAny();

            if(optionalFaceDetail.isPresent())
                return faceDetailsToResponse(optionalFaceDetail.get());

        } catch (RekognitionException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new FaceDetailsResponse();
    }


    private FaceDetailsResponse faceDetailsToResponse(FaceDetail details){
        FaceDetailsResponse faceDetailsResponse = new FaceDetailsResponse();

        faceDetailsResponse.setAgeRange(new AgeRange(details.ageRange().low(), details.ageRange().high()));
        faceDetailsResponse.setSmile(details.smile().value());
        faceDetailsResponse.setSunglasses(details.sunglasses().value());
        faceDetailsResponse.setBeard(details.beard().value());
        faceDetailsResponse.setGender(details.gender().value().name());
        faceDetailsResponse.setBrightness(details.quality().brightness().doubleValue());


        return faceDetailsResponse;
    }
}

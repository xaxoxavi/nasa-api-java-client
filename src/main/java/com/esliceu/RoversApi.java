package com.esliceu;

import com.esliceu.model.Photos;
import com.esliceu.model.RoverName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Component
public class RoversApi {

    @Autowired
    public RoversApi(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }

    private RestTemplate restTemplate;

    @Value("${nasa.api.rovers.url}")
    private String urlBase;

    @Value("${nasa.api.key}")
    private String apiKey;



    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }


    public Photos getPhotos(RoverName roverName, Integer sol){
        String url = MessageFormat.format(urlBase,roverName.toString().toLowerCase(),sol,apiKey);

        return restTemplate.getForObject(url, Photos.class);

    }
}

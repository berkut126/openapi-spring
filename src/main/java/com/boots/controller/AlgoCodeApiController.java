package com.boots.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import com.boots.entity.CodeFile;
import com.boots.service.CodeFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.bESTHACK2020Web.base-path:}")
public class AlgoCodeApiController implements AlgoCodeApi {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CodeFileService fileService;

    private final NativeWebRequest request;

    @Autowired
    public AlgoCodeApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<List<String>> algoCodeLoginGet(@ApiParam(value = "user login",required=true) @PathVariable("login") String login) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String[] a = (String[]) fileService.userFiles(login).stream().map(CodeFile::getUuid).toArray();
                    try {
                        ApiUtil.setExampleResponse(request, "application/json", mapper.writeValueAsString(a));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> algoCodePost(@Valid MultipartFile fileName) {
        try{
            String uuid = fileService.saveFile(new String(fileName.getBytes(), StandardCharsets.UTF_8));
            ApiUtil.setExampleResponse(request, "text/plain", uuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> algoCodeUUIDCodeGet(String UUID) {
        String text = fileService.getFile(UUID);
        if(text == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ApiUtil.setExampleResponse(request, "text/plain", text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> algoCodeUUIDDelete(String UUID) {
        if(fileService.deleteFile(UUID)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> algoCodeUUIDStatusGet(String UUID) {
        String text = fileService.getStatus(UUID);
        if(text == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ApiUtil.setExampleResponse(request, "text/plain", text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}

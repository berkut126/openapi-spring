package com.boots.controller;

import com.boots.entity.CodeFile;
import com.boots.repository.UserRepository;
import com.boots.service.CodeFileService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class CodeController {

    @Autowired
    CodeFileService codeFileService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/code")
    public String codeList(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Set<CodeFile> files = userRepository.findByUsername(currentUserName).getFiles();
        model.addAttribute("codeFiles", files);
        model.addAttribute("codeFile", files.toArray()[0]);
        model.addAttribute("username", currentUserName);

        return "code";
    }

    @PostMapping(path = "/code")
    public String codeCheck(@ApiParam(value = "uuid", required = true) @PathVariable("uuid") String uuid, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Set<CodeFile> files = userRepository.findByUsername(currentUserName).getFiles();
        model.addAttribute("codeFiles", files);
        model.addAttribute("codeFile", codeFileService.getFile(uuid));
        model.addAttribute("username", currentUserName);
        return "code";
    }

}

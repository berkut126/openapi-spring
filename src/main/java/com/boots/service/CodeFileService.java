package com.boots.service;

import com.boots.entity.CodeFile;
import com.boots.entity.User;
import com.boots.repository.CodeFileRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

@Service
public class CodeFileService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CodeFileRepository fileRepository;

    public String getFile(String Uuid){
        CodeFile file = fileRepository.findByUuid(Uuid);
        if(file != null){
            return file.getText();
        }
        else return null;
    }

    public Set<CodeFile> userFiles(String user){
        User u = userRepository.findByUsername(user);
        if(u != null)
            return u.getFiles();
        else return java.util.Set.of(new CodeFile());
    }

    public String saveFile(String content) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            CodeFile file = new CodeFile();
            file.setText(content);
            file.setUuid(UUID.fromString(content).toString());
            file.setUsers(userRepository.findByUsername(currentUserName));
            file.setComments("");
            processFile(file);
            fileRepository.save(file);
            return file.getUuid();
        }
        else return "Oops";

    }

    private void processFile(CodeFile content) {

        String[] names = content.getText().split(" ");
        int a = 0;
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals("class")){
                a = i + 1;
                break;
            }
        }
        try{
            File file = new File(names[a]+".java");
            Files.writeString(Paths.get(file.toURI()), content.getText(), StandardOpenOption.CREATE);
            System.out.println(file.getAbsolutePath());
            Process process = Runtime.getRuntime()
                    .exec("javac " + file.getAbsolutePath());
            if(process.exitValue() != 0){
                content.setStatus("FAILED");
                content.setComments(new String(process.getErrorStream().readAllBytes(), Charset.defaultCharset()));
            }
            process = Runtime.getRuntime().exec("java -Djava.security.manager " +
                    "-Djava.security.policy=D:\\MyApp.policy " + file.getAbsolutePath()
                    .substring(0, file.getAbsolutePath().length() - 7)+".class");
            if(process.exitValue() != 0){
                content.setComments(new String(process.getErrorStream().readAllBytes(), Charset.defaultCharset()));
                content.setStatus("FAILED");

            }
            File file1 = new File("Main.java");
            Files.writeString(Paths.get(file.toURI()), "class Main(){public static void main(String... args)" +
                    "{new "+names[a]+"().receiveTick(“RUBHGD,100.1”);}}", StandardOpenOption.CREATE_NEW);
            if(process.exitValue() == 0){
                content.setStatus("TESTED");
                content.setComments(new String(process.getInputStream().readAllBytes(), Charset.defaultCharset()));
            }
            content.setStatus("COMPILED");
            content.setComments(new String(process.getErrorStream().readAllBytes(), Charset.defaultCharset()));
            if(!file1.delete()){
                throw new RuntimeException("Cannot remove file!");
            }
            if(!file.delete()){
                throw new RuntimeException("Cannot remove file!");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean deleteFile(String uuid) {
        if (fileRepository.findByUuid(uuid) != null) {
            fileRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    public String getStatus(String Uuid) {
        CodeFile file = fileRepository.findByUuid(Uuid);
        if(file != null){
            return file.getStatus();
        }
        else return null;
    }
}

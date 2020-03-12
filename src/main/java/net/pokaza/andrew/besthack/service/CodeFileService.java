package net.pokaza.andrew.besthack.service;

import net.pokaza.andrew.besthack.model.CodeFile;
import net.pokaza.andrew.besthack.model.User;
import net.pokaza.andrew.besthack.repo.CodeFileRepository;
import net.pokaza.andrew.besthack.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
            fileRepository.save(file);
            return file.getUuid();
        }
        else return "Oops";

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
}

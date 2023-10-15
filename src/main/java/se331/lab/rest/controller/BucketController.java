package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.util.CloudStorageHelper;

import jakarta.servlet.ServletException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")
                                         MultipartFile file) throws IOException, ServletException {
        return
                ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"uploadimage-b2465.appspot.com"));
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image" )
                                                     MultipartFile file) throws IOException, ServletException{
        return
                ResponseEntity.ok((this.cloudStorageHelper.getStorageFileDto(file,"uploadimage-b2465.appspot.com")));
    }
}

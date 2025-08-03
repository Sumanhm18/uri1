package url.shortner.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import url.shortner.entity.Urlentity;
import url.shortner.repository.UrlRepository;

import url.shortner.service.BrowswersLogin;
import url.shortner.service.Service;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/url")
@Tag(name="RedirectUrl")

public class RedirectController {

    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private BrowswersLogin  browswersLogin;
    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortCode,HttpServletRequest request) {
        Urlentity entity = urlRepository.findByShortUrl(shortCode);

        if (entity == null || entity.getExpireDate().isBefore(LocalDate.now())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Short URL not found or expired");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(entity.getLongUrl()));
        String remoteAddr = request.getRemoteAddr();

        String header = request.getHeader("user-agent");
        browswersLogin.setLoginDetails(remoteAddr,header);


        return new ResponseEntity<>(headers, HttpStatus.FOUND);





    }
}
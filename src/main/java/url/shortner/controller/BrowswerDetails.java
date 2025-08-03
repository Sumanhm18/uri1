package url.shortner.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import url.shortner.service.BrowswersLogin;

@RestController
@RequestMapping("/browswer")
@Tag(name="LoginDetails")
public class BrowswerDetails {
    @Autowired
    BrowswersLogin browswersLogin;


    @GetMapping
    public ResponseEntity<?> getbrowswerdetails() {

        return new ResponseEntity<>(browswersLogin.getLoginDetails(), HttpStatus.OK);
    }
}

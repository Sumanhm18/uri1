package url.shortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import url.shortner.entity.Urlentity;
import url.shortner.repository.UrlRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UrlRepository urlRepository;

    public void save(Urlentity urlentity) {
        urlentity.setDate(LocalDate.now());
        urlentity.setExpireDate(LocalDate.now().plusDays(7));
        urlRepository.save(urlentity);

    }


}

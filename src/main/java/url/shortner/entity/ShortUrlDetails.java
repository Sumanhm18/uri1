package url.shortner.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import url.shortner.repository.UrlRepository;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter

@Component
public class ShortUrlDetails {
    @Autowired
    UrlRepository urlRepository;
    @Autowired
    Urlentity urlentity;
    LocalDate date;
    String shorturl;
    String originalurl;



    public LocalDate getdate(String url){
        Urlentity byShortUrl = urlRepository.findByShortUrl(url);
       return byShortUrl.getDate();

    }
public String getlongurl(String url){
    Urlentity byShortUrl = urlRepository.findByShortUrl(url);

    return byShortUrl.getLongUrl();

}


}

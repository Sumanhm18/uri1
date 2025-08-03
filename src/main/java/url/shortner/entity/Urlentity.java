package url.shortner.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Document(collection ="urlEntries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Urlentity {
    private String longUrl;
    private LocalDate date;
    private String shortUrl;
    private LocalDate expireDate;
    private int accescount=0;

}

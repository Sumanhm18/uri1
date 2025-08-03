package url.shortner.repository;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import url.shortner.entity.Urlentity;
@Service
public interface UrlRepository extends MongoRepository<Urlentity, ObjectId> {
    public  Urlentity findByLongUrl(String url);
    public  Urlentity findByShortUrl(String url);



}

package domain.repository;

import domain.model.dbo.BlogEntryDbo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BlogEntryDboRepository extends MongoRepository<BlogEntryDbo, Long> {

    BlogEntryDbo findFirstByDomain(String domain);

    BlogEntryDbo findByDomainAndDisplayAds(String domain, boolean displayAds);

    //Supports native JSON query string
    /*@Query("{domain:'?0'}")
    BlogEntryDbo findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<BlogEntryDbo> findCustomByRegExDomain(String domain);*/

}

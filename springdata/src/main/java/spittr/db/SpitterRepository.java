package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spittr.domain.Spitter;

import java.util.List;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {

    Spitter findByUsername(String username);

    List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

    @Query("select s from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();
}

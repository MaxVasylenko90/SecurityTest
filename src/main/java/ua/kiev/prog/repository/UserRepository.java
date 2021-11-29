package ua.kiev.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kiev.prog.entity.CustomUser;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
    @Query("SELECT u FROM CustomUser u where u.login = :login")
    CustomUser findByLogin(@Param("login") String login);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM CustomUser u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);

    // CustomUser findByEmailAndAddress(String email, String address);
}

package dev.arshad.Splitwise.Repository;

import dev.arshad.Splitwise.Model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}

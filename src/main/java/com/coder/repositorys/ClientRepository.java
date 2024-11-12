package com.coder.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coder.models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}

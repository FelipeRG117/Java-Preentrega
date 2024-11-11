package com.coder.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}

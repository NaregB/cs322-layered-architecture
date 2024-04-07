package dev.danvega.account.io.am.repository;

import dev.danvega.account.io.am.dto.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {

}

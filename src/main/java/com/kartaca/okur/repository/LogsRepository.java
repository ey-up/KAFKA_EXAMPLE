package com.kartaca.okur.repository;

import com.kartaca.okur.modal.Log;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends CouchbaseRepository<Log,String> {

}

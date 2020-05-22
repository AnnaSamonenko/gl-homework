package homework1.service;

import homework1.entities.User;
import homework1.repository.Repository;

import java.util.List;

public class Service {

    Repository repository;

    public List<User> findAll(String roleTitle){
        repository = new Repository();
        return repository.findUsersByRole(roleTitle);
    }

}

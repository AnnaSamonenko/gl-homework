package homework1;

import homework1.entities.User;
import homework1.service.Service;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Service service = new Service();
        List<User> users = service.findAll("Admin");
        users.stream().forEach(u -> System.out.println(u));
    }
}


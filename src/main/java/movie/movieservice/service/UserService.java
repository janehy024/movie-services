package movie.movieservice.service;

import movie.movieservice.domain.User;
import movie.movieservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User 생성
    public Long createUser(String name, Integer age, String city, String street, String zipCode) {
        User newUser = new User(name, age, city, street, zipCode);
        return userRepository.save(newUser);
    }

    // User 정보 수정
    public void editUserName(Long userId, String editName){
        result.setName(editName);
        result.setEditTime(LocalDateTime.now());
    }




}

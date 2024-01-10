package movie.service;

import movie.domain.User;
import movie.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        userRepository.update(userId, editName);
    }

    // User 삭제
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}

package com.todoback.todo.servicesImpl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.dto.UserDto;
import com.todoback.todo.repositories.UserRepo;
import com.todoback.todo.services.UserService;
import com.todoback.todo.validators.UserValidator;


@Service

public class UserServiceImpl implements UserService {
	
    private static final Logger log = Logger.getLogger(TodoServiceImpl.class.getName());

	
	@Autowired
	private UserRepo userRepo; 

	public UserServiceImpl(@Autowired UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDto save(UserDto userDto) {
		// TODO Auto-generated method stub
		List<String> errors = UserValidator.validateUser(userDto);
		if(!errors.isEmpty()) {
			log.info("User is not valid ");
			return null;			
		}
        return UserDto.fromEntity(userRepo.save(UserDto.toEntity(userDto)));
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if (id==null) {
			log.info("User id cannot be null");
			return;
		}
		userRepo.deleteById(id);
	}

	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
	}

	@Override
	public UserDto findById(Long id) {
		// TODO Auto-generated method stub
		if (id==null) {
			log.info("User id cannot be null");
			return null;
		}
		return userRepo.findById(id)
                .map(UserDto::fromEntity)
                .orElseGet(() -> {
                    log.info("No user found with ID ");
                    return null;
                });
	}

	@Override
	public UserDto login(UserDto userDto) {
        List<String> errors = UserValidator.validateUserCredentials(userDto.getEmail(), userDto.getPassword());
        
        if (!errors.isEmpty()) {
            log.info("User credentials are not valid for user");
            return null;
        }
		return userRepo.findUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword())
				.map(UserDto::fromEntity)
				.orElseGet(()->{
					log.info("No user found with Email and provided password");
                    return null;
				});
	}

}

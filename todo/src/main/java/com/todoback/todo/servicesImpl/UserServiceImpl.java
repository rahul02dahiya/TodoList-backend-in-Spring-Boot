package com.todoback.todo.servicesImpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.model.User;
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
	public User save(User user) {
		// TODO Auto-generated method stub
		List<String> errors = UserValidator.validateUser(user);
		if(!errors.isEmpty()) {
			log.info("User is not valid ");
			return null;			
		}
        return userRepo.save(user);
		
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
	public User findById(Long id) {
		// TODO Auto-generated method stub
		if (id==null) {
			log.info("User id cannot be null");
			return null;
		}
		return userRepo.findById(id)
                .orElseGet(() -> {
                    log.info("No user found with ID ");
                    return null;
                });
	}

	@Override
	public User login(User user) {
        List<String> errors = UserValidator.validateUserCredentials(user.getEmail(), user.getPassword());
        
        if (!errors.isEmpty()) {
            log.info("User credentials are not valid for user");
            return null;
        }
		return userRepo.findUserByEmailAndPassword(user.getEmail(), user.getPassword())
				.orElseGet(()->{
					log.info("No user found with Email and provided password");
                    return null;
				});
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}

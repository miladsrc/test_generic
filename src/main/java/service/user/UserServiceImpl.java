package service.user;

import base.repository.BaseRepository;
import base.service.BaseServiceImpl;
import model.User;
import repository.user.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<Integer, User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}

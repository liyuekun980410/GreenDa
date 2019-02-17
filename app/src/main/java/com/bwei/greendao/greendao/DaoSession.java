package com.bwei.greendao.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bwei.greendao.entity.UserEntity;
import com.bwei.greendao.entity.PersonEntity;

import com.bwei.greendao.greendao.UserEntityDao;
import com.bwei.greendao.greendao.PersonEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userEntityDaoConfig;
    private final DaoConfig personEntityDaoConfig;

    private final UserEntityDao userEntityDao;
    private final PersonEntityDao personEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userEntityDaoConfig = daoConfigMap.get(UserEntityDao.class).clone();
        userEntityDaoConfig.initIdentityScope(type);

        personEntityDaoConfig = daoConfigMap.get(PersonEntityDao.class).clone();
        personEntityDaoConfig.initIdentityScope(type);

        userEntityDao = new UserEntityDao(userEntityDaoConfig, this);
        personEntityDao = new PersonEntityDao(personEntityDaoConfig, this);

        registerDao(UserEntity.class, userEntityDao);
        registerDao(PersonEntity.class, personEntityDao);
    }
    
    public void clear() {
        userEntityDaoConfig.clearIdentityScope();
        personEntityDaoConfig.clearIdentityScope();
    }

    public UserEntityDao getUserEntityDao() {
        return userEntityDao;
    }

    public PersonEntityDao getPersonEntityDao() {
        return personEntityDao;
    }

}

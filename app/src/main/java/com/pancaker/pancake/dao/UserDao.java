package com.pancaker.pancake.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pancaker.pancake.domain.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, String> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property UserId = new Property(0, String.class, "userId", true, "USER_ID");
        public final static Property UserName = new Property(1, String.class, "userName", false, "user_name");
        public final static Property Password = new Property(2, String.class, "password", false, "password");
        public final static Property UserPhone = new Property(3, String.class, "userPhone", false, "user_phone");
        public final static Property UserType = new Property(4, long.class, "userType", false, "userType");
        public final static Property Locked = new Property(5, long.class, "locked", false, "locked");
        public final static Property Credit = new Property(6, long.class, "credit", false, "credit");
        public final static Property LastVisit = new Property(7, java.util.Date.class, "lastVisit", false, "last_visit");
        public final static Property LastIp = new Property(8, String.class, "lastIp", false, "last_ip");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"USER_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: userId
                "\"user_name\" TEXT," + // 1: userName
                "\"password\" TEXT," + // 2: password
                "\"user_phone\" TEXT," + // 3: userPhone
                "\"userType\" INTEGER NOT NULL ," + // 4: userType
                "\"locked\" INTEGER NOT NULL ," + // 5: locked
                "\"credit\" INTEGER NOT NULL ," + // 6: credit
                "\"last_visit\" INTEGER," + // 7: lastVisit
                "\"last_ip\" TEXT);"); // 8: lastIp
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(2, userName);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        String userPhone = entity.getUserPhone();
        if (userPhone != null) {
            stmt.bindString(4, userPhone);
        }
        stmt.bindLong(5, entity.getUserType());
        stmt.bindLong(6, entity.getLocked());
        stmt.bindLong(7, entity.getCredit());
 
        java.util.Date lastVisit = entity.getLastVisit();
        if (lastVisit != null) {
            stmt.bindLong(8, lastVisit.getTime());
        }
 
        String lastIp = entity.getLastIp();
        if (lastIp != null) {
            stmt.bindString(9, lastIp);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(2, userName);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        String userPhone = entity.getUserPhone();
        if (userPhone != null) {
            stmt.bindString(4, userPhone);
        }
        stmt.bindLong(5, entity.getUserType());
        stmt.bindLong(6, entity.getLocked());
        stmt.bindLong(7, entity.getCredit());
 
        java.util.Date lastVisit = entity.getLastVisit();
        if (lastVisit != null) {
            stmt.bindLong(8, lastVisit.getTime());
        }
 
        String lastIp = entity.getLastIp();
        if (lastIp != null) {
            stmt.bindString(9, lastIp);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // password
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userPhone
            cursor.getLong(offset + 4), // userType
            cursor.getLong(offset + 5), // locked
            cursor.getLong(offset + 6), // credit
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // lastVisit
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // lastIp
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUserName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPassword(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserType(cursor.getLong(offset + 4));
        entity.setLocked(cursor.getLong(offset + 5));
        entity.setCredit(cursor.getLong(offset + 6));
        entity.setLastVisit(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setLastIp(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final String updateKeyAfterInsert(User entity, long rowId) {
        return entity.getUserId();
    }
    
    @Override
    public String getKey(User entity) {
        if(entity != null) {
            return entity.getUserId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getUserId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
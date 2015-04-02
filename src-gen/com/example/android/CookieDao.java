package com.example.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.android.Cookie;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COOKIE.
*/
public class CookieDao extends AbstractDao<Cookie, Long> {

    public static final String TABLENAME = "COOKIE";

    /**
     * Properties of entity Cookie.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Key = new Property(1, String.class, "key", false, "KEY");
        public final static Property Value = new Property(2, String.class, "value", false, "VALUE");
        public final static Property Domain = new Property(3, String.class, "domain", false, "DOMAIN");
        public final static Property Path = new Property(4, String.class, "path", false, "PATH");
        public final static Property Expires = new Property(5, java.util.Date.class, "expires", false, "EXPIRES");
    };


    public CookieDao(DaoConfig config) {
        super(config);
    }
    
    public CookieDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COOKIE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'KEY' TEXT NOT NULL ," + // 1: key
                "'VALUE' TEXT," + // 2: value
                "'DOMAIN' TEXT," + // 3: domain
                "'PATH' TEXT," + // 4: path
                "'EXPIRES' INTEGER);"); // 5: expires
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COOKIE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Cookie entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getKey());
 
        String value = entity.getValue();
        if (value != null) {
            stmt.bindString(3, value);
        }
 
        String domain = entity.getDomain();
        if (domain != null) {
            stmt.bindString(4, domain);
        }
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(5, path);
        }
 
        java.util.Date expires = entity.getExpires();
        if (expires != null) {
            stmt.bindLong(6, expires.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Cookie readEntity(Cursor cursor, int offset) {
        Cookie entity = new Cookie( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // key
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // value
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // domain
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // path
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)) // expires
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Cookie entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setKey(cursor.getString(offset + 1));
        entity.setValue(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDomain(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPath(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setExpires(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Cookie entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Cookie entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

package vivek.wo.easygreendao;

import android.content.Context;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

import java.util.List;

import vivek.wo.easygreendao.entity.DaoMaster;
import vivek.wo.easygreendao.entity.DaoSession;

/**
 * Created by VIVEK-WO on 2018/3/29.
 */

public class TaskLocalDataSource implements IDataSourceOperation {
    private static final String DATABASE_NAME = "local.db";//数据库名称
    DaoSession mDaoSession;

    public TaskLocalDataSource(Context context) {
        DaoMaster daoMaster = new DaoMaster(new DatabaseOpenHelper(context).getWritableDb());
        mDaoSession = daoMaster.newSession(IdentityScopeType.None);
    }

    public <T> T getDao(Class<? extends Object> entityClass) {
        return (T) mDaoSession.getDao(entityClass);
    }

    @Override
    public void insert(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertInTx(listObject);
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insert(object);
        }
    }

    @Override
    public void insertOrUpdate(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertOrReplaceInTx(listObject);
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertOrReplace(object);
        }
    }

    @Override
    public void update(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).updateInTx(listObject);
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).update(object);
        }
    }

    @Override
    public void delete(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).deleteInTx(listObject);
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).delete(object);
        }
    }

    @Override
    public void deleteByKey(Class<?> cls, String key) {
        ((AbstractDao<Object, String>) getDao(cls)).deleteByKey(key);
    }

    @Override
    public void deleteAll(Class<?> cls) {
        ((AbstractDao<Object, String>) getDao(cls)).deleteAll();
    }

    @Override
    public <T> T quaryByKey(Class<T> cls, String key) {
        return ((AbstractDao<T, String>) getDao(cls)).load(key);
    }

    @Override
    public <T> List<T> quary(Class<T> cls, String where, String... selectionArg) {
        return ((AbstractDao<T, String>) getDao(cls)).queryRaw(where, selectionArg);
    }

    @Override
    public <T> List<T> quaryAll(Class<T> cls) {
        return ((AbstractDao<T, String>) getDao(cls)).loadAll();
    }

    static class DatabaseOpenHelper extends DaoMaster.OpenHelper {

        public DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME);
        }
    }
}

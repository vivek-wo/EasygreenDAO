package vivek.wo.easygreendao;

import java.util.List;

/**
 * Created by VIVEK-WO on 2018/3/29.
 */

public interface IDataSourceOperation {

    void insert(Object object);

    void insertOrUpdate(Object object);

    void update(Object object);

    void delete(Object object);

    void deleteByKey(Class<? extends Object> classType, String id);

    void deleteAll(Class<? extends Object> classType);

    <T> T quaryByKey(Class<T> classType, String id);

    <T> List<T> quary(Class<T> classType, String where, String... selectionArg);

    <T> List<T> quaryAll(Class<T> classType);
}

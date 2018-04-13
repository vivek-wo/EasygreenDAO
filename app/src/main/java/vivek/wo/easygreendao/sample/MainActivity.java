package vivek.wo.easygreendao.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import vivek.wo.easygreendao.R;
import vivek.wo.easygreendao.TaskLocalDataSource;
import vivek.wo.easygreendao.entity.User;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TaskLocalDataSource mTaskLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTaskLocalDataSource = new TaskLocalDataSource(getApplicationContext());

        //清空
        mTaskLocalDataSource.deleteAll(User.class);

        User user = createUser("张三");
        User user0 = createUser("李四");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user0);
        //插入
        mTaskLocalDataSource.insert(list);

        //查找
        List<User> userList = mTaskLocalDataSource.quaryAll(User.class);
        Log.d(TAG, "-local--> db insert quaryAll : " + userList.toString());

        User user1 = userList.get(0);
        user1.setBirthDay("1999-02-01");
        user1.setHouseAdress("广东省珠海市");

        //更新
        mTaskLocalDataSource.update(user1);

        //查找
        List<User> userList1 = mTaskLocalDataSource.quaryAll(User.class);
        Log.d(TAG, "-local--> db update quaryAll : " + userList1.toString());

    }

    User createUser(String name) {
        return new User(UUID.randomUUID().toString(), 0, name, 0,
                "汉", "1989-02-26", "", "");
    }
}

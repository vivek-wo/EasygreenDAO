# EasygreenDAO
基于greenDAO的上层调用封装。

### greenDAO的集成
greenDAO的集成和说明参考https://github.com/greenrobot/greenDAO。

### 封装
greenDAO默认生成DaoMaster、DaoSession和各个数据表Dao操作对象，各个数据表的数据操作接口都在Dao对象中。

封装简化了数据表的数据操作，无需关注具体的数据表Dao操作对象，实现外层接口的统一调用。

例如：

1、有User对象和数据表、Card对象和数据表，生成UserDao和CardDao两个数据库操作对象。

User对象插入操作：

`getDaoSession().getUserDao().insert(user);`

Card对象插入操作：

`getDaoSession().getCardDao().insert(card);`

2、新建统一数据表操作接口类 ，封装统一的插入接口：

`void insert(Object object);`

不管是User对象插入还是Card对象插入都统一调用接口:

`insert(user)`或者`insert(card)`，无需关注是UserDao和是CardDao操作对象。

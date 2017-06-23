如果没有设置主键ID自增长 (autoincrement = true)
在第二次及以后重开应用的情况下会报 android.database.sqlite.SQLiteConstraintException: PRIMARY KEY must be unique

解决办法就是：
设置主键id自增(autoincrement = true)
然后在插入表的时候就不能再传入id属性！！！！

*******************************************************
Dao对象其他API的介绍

*增加单个数据

getUserDao().insert(shop);

getUserDao().insertOrReplace(shop);

*增加多个数据

getUserDao().insertInTx(shopList);

getUserDao().insertOrReplaceInTx(shopList);

*查询全部

List< Shop> list = getUserDao().loadAll();

List< Shop> list = getUserDao().queryBuilder().list();

*查询附加单个条件

.where()

.whereOr()

*查询附加多个条件

.where(, , ,)

.whereOr(, , ,)

查询附加排序

.orderDesc()

.orderAsc()

查询限制当页个数

.limit()

查询总个数

.count()

修改单个数据

getUserDao().update(shop);

修改多个数据

getUserDao().updateInTx(shopList);

删除单个数据

getTABUserDao().delete(user);

删除多个数据

getUserDao().deleteInTx(userList);

删除数据ByKey

getTABUserDao().deleteByKey();
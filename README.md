如果没有设置主键ID自增长 (autoincrement = true)
在第二次及以后重开应用的情况下会报 android.database.sqlite.SQLiteConstraintException: PRIMARY KEY must be unique

解决办法就是：
设置主键id自增(autoincrement = true)
然后在插入表的时候就不能再传入id属性！！！！

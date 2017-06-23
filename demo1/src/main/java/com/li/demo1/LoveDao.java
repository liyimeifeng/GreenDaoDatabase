package com.li.demo1;

import java.util.List;

/**
 * Created by Lee on 2017/6/23 0023.
 */

public class LoveDao {

    /**
     * 添加数据，如果有则覆盖
     * @param shop
     */
    public static  void insertLove(Shop shop){
        BaseApplication.getDaoInstance().getShopDao().insertOrReplace(shop);
    }

    public static void deleteLove(Long id){
        BaseApplication.getDaoInstance().getShopDao().deleteByKey(id);
    }

    public static void updateLove(Shop shop){
        BaseApplication.getDaoInstance().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type = TYPE_LOVE的数据
     * @return
     */
    public static List<Shop> queryLove(){
        return BaseApplication.getDaoInstance().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }

    public static List<Shop> queryAll(){
        return BaseApplication.getDaoInstance().getShopDao().loadAll();
    }

}

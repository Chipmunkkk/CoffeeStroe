package com.example.chipmunk.coffeestore.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.chipmunk.coffeestore.Entity.Shop;
import com.example.chipmunk.coffeestore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreList extends AppCompatActivity {

    ListView View_storelist;
    List<Map<String,Object>> storeList;
    SimpleAdapter simpleAdapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, Menu.NONE, "删除");
        menu.add(0, 1, Menu.NONE, "联系店铺");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo1 = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        simpleAdapter.notifyDataSetChanged();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String ActivityTitle = "店铺列表";
        setTitle(ActivityTitle);
        setContentView(R.layout.layout_store);

        View_storelist = (ListView) findViewById(R.id.LayoutStoreList);
        Shop shop = new Shop();
        shop.setShop_id("1");
        shop.setShop_name("漫猫咖啡店");
        shop.setShop_address("中山区五名街002号");
        shop.setTel("0411-83404444");
        shop.setImg_id(R.drawable.img_home1);
        shop.setImg_name("aidohasdh");
        HashMap<String,Object> store_1 = new HashMap<>();
        store_1.put("storePic",R.drawable.img_home1);
        store_1.put("storeName","左岸咖啡店");
        store_1.put("storeAddress","星海广场001号");
        store_1.put("storeTelphone","0411-83404848");

        HashMap<String,Object> store_2 = new HashMap<>();
        store_2.put("storePic",R.drawable.img_home1);
        store_2.put("storeName","漫猫咖啡店");
        store_2.put("storeAddress","中山区五名街002号");
        store_2.put("storeTelphone","0411-83404444");

        HashMap<String,Object> store_3 = new HashMap<>();
        store_3.put("storePic",R.drawable.img_home1);
        store_3.put("storeName","星巴克咖啡店");
        store_3.put("storeAddress","甘井子区数码路北段18-25号");
        store_3.put("storeTelphone","0411-88147265");

        HashMap<String,Object> store_4 = new HashMap<>();
        store_4.put("storePic",R.drawable.img_home1);
        store_4.put("storeName","萌客思维主题咖啡馆");
        store_4.put("storeAddress","甘井子区软件园144号");
        store_4.put("storeTelphone","150-4119-0144");

        storeList = new ArrayList<>();
        storeList.add(store_1);
        storeList.add(store_2);
        storeList.add(store_3);
        storeList.add(store_4);



        simpleAdapter = new SimpleAdapter(this,storeList,R.layout.storelist,
                new String[]{"storePic","storeName","storeAddress","storeTelphone"},
                new int[]{R.id.img_store,R.id.txt_storeName,R.id.txt_storeAddress,R.id.txt_storeTelphone});
        View_storelist.setAdapter(simpleAdapter);
        registerForContextMenu(View_storelist);
    }
}

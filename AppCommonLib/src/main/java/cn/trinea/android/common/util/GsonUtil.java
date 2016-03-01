package cn.trinea.android.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by dongkai on 2016/3/1.
 */
public class GsonUtil {
    private static GsonBuilder gsonBuilder = new GsonBuilder();

    public static <T> void registerTypeAdapter(Class<T> clazz,Object obj){
        gsonBuilder.registerTypeAdapter(clazz, obj);
    }

    public static <T> String toGson(T instance){
        String res = getGson().toJson(instance);
        return res;
    }
    public static <T> String toGson(T[] instanceArray){
        String res = getGson().toJson(instanceArray);
        return res;
    }

    public static <T> T fromGson(String gsonString,Class<T> clazz){
        try {
            T ins = getGson().fromJson(gsonString, clazz);
            return ins;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> T fromGson(JsonElement jsonElement,Class<T> clazz){
        try {
            T ins = getGson().fromJson(jsonElement, clazz);
            return ins;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> fromGson(String gsonString,T instance){
        List<T> list = getGson().fromJson(gsonString, new TypeToken<T>() {}.getType());
        return list;
    }

    public static Gson getGson(){
        return gsonBuilder.create();
    }

}

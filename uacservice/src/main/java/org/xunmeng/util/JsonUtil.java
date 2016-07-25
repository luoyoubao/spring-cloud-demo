/**
 * 
 */
package org.xunmeng.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author jasontang
 *
 */
public class JsonUtil
{
	private static Gson gson = new Gson();

	public static <T> T stringToBean(String json, Class<T> classOfT)
	{
		return gson.fromJson(json, classOfT);
	}

	public static String beanToString(Object object)
	{
		return gson.toJson(object);
	}
	
	public static String beanToString(Object object, TypeToken<?> tokenType)
    {
        return gson.toJson(object, tokenType.getType());
    }
	
	public static <T> T stringToBean(String json, TypeToken<?> tokenType)
    {
        return gson.fromJson(json, tokenType.getType());
    }
}
package com.charley.spring.util;//package util;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import java.util.*;
//
//
//@SuppressWarnings("unchecked")
//public class TransMapUtil {
//
//	public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
//		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		Iterator<JSONObject> it = jsonArr.iterator();
//		while (it.hasNext()) {
//			JSONObject json2 = it.next();
//			list.add(parseJSON2Map(json2.toString()));
//		}
//		return list;
//	}
//
//	public static Map<String, Object> parseJSON2Map(String jsonStr) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			// 最外层解析
//			JSONObject json = JSONObject.fromObject(jsonStr);
//			for (Object k : json.keySet()) {
//				Object v = json.get(k);
//				// 如果内层还是数组的话，继续解析
//				if (v instanceof JSONArray) {
//					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//					Iterator<JSONObject> it = ((JSONArray) v).iterator();
//					while (it.hasNext()) {
//						JSONObject json2 = it.next();
//						list.add(parseJSON2Map(json2.toString()));
//					}
//					map.put(k.toString(), list);
//				} else {
//					map.put(k.toString(), v);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return map;
//	}
//
//}
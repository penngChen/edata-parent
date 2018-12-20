package com.tzsw.api.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:37 2018/11/13
 */
public class CommonUtil {

    /*
     * @Description 日期统一处理
     * @Param
     * @return
     **/
    public static void changeDate(List<Map<String, Object>> mapList) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] dates = {"AAE136", "AAE036", "BDC056", "BDC05J", "BDC05K", "BDC05L", "BJC01D", "BJC01E"};
        for (Map<String, Object> map : mapList) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                for (String date : dates) {
                    if (date.equals(entry.getKey())) {
                        if (entry.getValue() != null) {
                            entry.setValue(DateUtil.formatDate(format.parse(entry.getValue().toString())));
                        }
                    }
                }
            }
        }
    }

    public static void removeOneList(List<Map<String, Object>> mapList) {
        for (int i = 1; i < mapList.size(); i++) {
            for (int j = 0; j < mapList.size() - 1; j++) {
//                if (mapList.get(i).containsKey("BPIC03_TOP") && mapList.get(i).containsKey("BPIC03_BOTTOM") && mapList.get(j).containsKey("BPIC03_BOTTOM") && mapList.get(j).containsKey("BPIC03_TOP")) {
//                    if (("02").equals(mapList.get(j).get("BPIC03_TOP")) && "03".equals(mapList.get(i).get("BPIC03_TOP")) && !"".equals(mapList.get(j).get("BPIC03_BOTTOM")) && !"".equals(mapList.get(i).get("BPIC03_BOTTOM"))) {
//                        mapList.get(i).replace("BPIC03_TOP", mapList.get(j).get("BPIC03_BOTTOM"));
//                        mapList.remove(j);
//                    }
//                }
                if (!mapList.get(i).containsKey("BPIC03_TOP")){
                    System.out.println(mapList.get(i));
                }
            }
        }
    }

    public static void sortListByAae036(List<Map<String, Object>> list) {
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                if (o1.get("AAE036").toString().compareTo(o2.get("AAE036").toString()) > 0) {
                    return -1;
                }
                if (o1.get("AAE036").toString().compareTo(o2.get("AAE036").toString()) == 0) {
                    return 0;
                }
                return 1;
            }
        });
    }

    public static void main(String[] args) {
        String t1 = "2013-10-30";
        String t2 = "2013-10-30";
        String t3 = "-";
        int result = t1.compareTo(t3);
        System.out.println(result);
    }
}

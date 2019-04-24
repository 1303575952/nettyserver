package com.huanxin.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huanxin.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class WorkingDataModel {
    /**
     * 脱氮，运行浓度
     *
     * @param gasInVol
     * @param no2InDen
     * @param o2InPer
     * @param gasInTemp
     * @param nH3InVol
     * @return
     */
    public static float nOperationConcentration(float gasInVol, float no2InDen, float o2InPer, float gasInTemp, float nH3InVol) {
        Map param = new HashMap();

        // 构造工况模型的参数
        param.put("gasInVol", (long) gasInVol);
        param.put("NOxInDen", String.valueOf(no2InDen));
        param.put("O2InPer", String.valueOf(o2InPer));
        param.put("gasInTemp", String.valueOf(gasInTemp));
        param.put("NH3InVol", String.valueOf(nH3InVol));

        // 工况模型接口的调用
        String result = HttpClientUtil.httpGetWithJSON("http://39.96.33.44:8081/renren-api/jnrdgk/tuoxiao_reaction", param);

        //System.out.println("result:" + result);

        // 对返回的 Json 进行解析
        Map<String, Object> parsemap = JSON.parseObject(result, new TypeReference<Map<String, Object>>() {
        });
        String s = parsemap.get("NOxOutDen").toString();
        return Float.valueOf(s);
    }
    public static void main(String[] args) {
        System.out.println(nOperationConcentration(1,1,1,1,1));
    }
    /**
     * 脱硫，运行浓度
     *
     * @param gasInVol
     * @param so2InDen
     * @param o2InPer
     * @param gasInTemp
     * @param slurrySupply
     * @param caQual
     * @param caDen
     * @param pumpGroup
     * @return
     */
    public static float sOperationConcentration(float gasInVol, float so2InDen, float o2InPer, float gasInTemp, float slurrySupply, float caQual, float caDen, String pumpGroup) {
        Map param = new HashMap();

        // 构造工况模型的参数
        param.put("gasInVol", (long) gasInVol);
        param.put("SO2InDen", String.valueOf(so2InDen));
        param.put("O2InPer", String.valueOf(o2InPer));
        param.put("gasInTemp", String.valueOf(gasInTemp));
        param.put("slurrySupply", String.valueOf(slurrySupply));
        param.put("CaQual", String.valueOf(caQual));
        param.put("CaDen", String.valueOf(caDen));
        param.put("pumpGroup", slurrySupply);

        // 工况模型接口的调用
        String result = HttpClientUtil.httpGetWithJSON("http://39.96.33.44:8081/renren-api/jnrdgk/tuoliu_reaction", param);

        //System.out.println("result:" + result);

        // 对返回的 Json 进行解析
        Map<String, Object> parsemap = JSON.parseObject(result, new TypeReference<Map<String, Object>>() {
        });

        String s = parsemap.get("SO2OutDen").toString();
        return Float.valueOf(s);
    }

    /**
     * 脱硝，运行效率
     *
     * @param nOxOutDen_All
     * @param gasInVol_A
     * @param nOxInDen_A
     * @param gasInVol_B
     * @param nOxInDen_B
     * @return
     */
    public static float nOperatingEfficiency(float nOxOutDen_All, float gasInVol_A, float nOxInDen_A, float gasInVol_B, float nOxInDen_B) {
        Map param = new HashMap();

        // 构造工况模型的参数
        param.put("NOxOutDen_All", (long) nOxOutDen_All);
        param.put("gasInVol_A", String.valueOf(gasInVol_A));
        param.put("NOxInDen_A", String.valueOf(nOxInDen_A));
        param.put("gasInVol_B", String.valueOf(gasInVol_B));
        param.put("NOxInDen_B", String.valueOf(nOxInDen_B));

        // 工况模型接口的调用
        String result = HttpClientUtil.httpGetWithJSON("http://39.96.33.44:8081/renren-api/jnrdgk/tuoxiao_ratio", param);

        //System.out.println("result:" + result);

        // 对返回的 Json 进行解析
        Map<String, Object> parsemap = JSON.parseObject(result, new TypeReference<Map<String, Object>>() {
        });

        return (float) parsemap.get("ratio");
    }

    /**
     * 脱硫，运行效率
     *
     * @param gasInVol
     * @param gasOutVol
     * @param sO2InDen
     * @param sO2OutDen
     * @return
     */
    public static float sOperatingEfficiency(float gasInVol, float gasOutVol, float sO2InDen, float sO2OutDen) {
        Map param = new HashMap();

        // 构造工况模型的参数
        param.put("gasInVol", (long) gasInVol);
        param.put("gasOutVol", String.valueOf(gasOutVol));
        param.put("SO2InDen", String.valueOf(sO2InDen));
        param.put("SO2OutDen", String.valueOf(sO2OutDen));

        // 工况模型接口的调用
        String result = HttpClientUtil.httpGetWithJSON("http://39.96.33.44:8081/renren-api/jnrdgk/tuoliu_ratio", param);

        //System.out.println("result:" + result);

        // 对返回的 Json 进行解析
        Map<String, Object> parsemap = JSON.parseObject(result, new TypeReference<Map<String, Object>>() {
        });

        return (float) parsemap.get("ratio");
    }

    /**
     * 脱硝直接计算
     *
     * @param nChukouNoxnongdu
     * @param nRukouNoxnongdu
     * @return
     */
    public static float nEfficiency(float nChukouNoxnongdu, float nRukouNoxnongdu) {
        float neff = 1 - nChukouNoxnongdu / nRukouNoxnongdu;
        if (neff < 0) {
            return 0.0f;
        } else if (neff > 1) {
            return 1.0f;
        } else {
            return neff;
        }
    }

    /**
     * 脱硝直接计算
     *
     * @param sChukounongdu
     * @param sChukouyanqiliang
     * @param sRukounongdu
     * @param sRukouyanqiliang
     * @return
     */
    public static float sEfficiency(float sChukounongdu, float sChukouyanqiliang, float sRukounongdu, float sRukouyanqiliang) {
        float seff = 1 - (sChukounongdu * sChukouyanqiliang) / (sRukounongdu * sRukouyanqiliang);
        if (seff < 0) {
            return 0.0f;
        } else if (seff > 1) {
            return 1.0f;
        } else {
            return seff;
        }
    }
}

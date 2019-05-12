package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.utils.Hex2Float;
import com.sxu.utils.TimeUtil;
import org.apache.log4j.Logger;

public class WorkingDataProcess {
    private static final Logger LOGGER = Logger.getLogger(WorkingDataProcess.class);

    /**
     * 通过帧拿到工况数据，封装到对象workingDataEntity中
     *
     * @param arrayHex
     * @return
     */
    public static WorkingDataEntity getWorkingDataEntityFromFrame(String[] arrayHex) {
        WorkingDataEntity workingDataEntity = new WorkingDataEntity();

        // 解析企业id
        String qiyeID = "";
        StringBuffer sbQiyeID = new StringBuffer();
        for (int i = 3; i <= 6; i++) {
            sbQiyeID.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        qiyeID = sbQiyeID.toString();

        // 解析排口编号
        String paikoubianhao = "";
        paikoubianhao = String.valueOf((char) Integer.parseInt(arrayHex[8], 16));

        // 解析年月日
        String nianyueri = "";
        StringBuffer sbNianyueri = new StringBuffer();
        for (int i = 9; i <= 16; i++) {
            sbNianyueri.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        nianyueri = sbNianyueri.toString();

        // 解析机组编号
        String jizubianhao_1 = "";
        jizubianhao_1 = String.valueOf((char) Integer.parseInt(arrayHex[17], 16));

        // 解析时分秒
        String shifenmiao_1 = "";
        StringBuffer sbShifenmiao_1 = new StringBuffer();
        for (int i = 18; i <= 25; i++) {
            sbShifenmiao_1.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        shifenmiao_1 = sbShifenmiao_1.toString();

        // 解析锅炉编号
        String guolubianhao_1_a = "";
        guolubianhao_1_a = String.valueOf((char) Integer.parseInt(arrayHex[29], 16));

        // 解析工艺类型脱硝TX
        String gongyileixingTX_1_a = "";
        StringBuffer sbGongyileixingTX_1_a = new StringBuffer();
        for (int i = 30; i <= 31; i++) {
            sbGongyileixingTX_1_a.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTX_1_a = sbGongyileixingTX_1_a.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_1_a = "";
        zhilisheshibianhao_1_a = String.valueOf((char) Integer.parseInt(arrayHex[32], 16));

        //SCR反应器出口烟气O2浓度
        Float SCRfanyingqichukouyanqiO2nongdu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[34], 16),
                Integer.parseInt(arrayHex[33], 16),
                Integer.parseInt(arrayHex[36], 16),
                Integer.parseInt(arrayHex[35], 16)
        });
        //SCR反应器出口烟气NOX浓度
        Float SCRfanyingqichukouyanqiNOXnongdu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[38], 16),
                Integer.parseInt(arrayHex[37], 16),
                Integer.parseInt(arrayHex[40], 16),
                Integer.parseInt(arrayHex[39], 16)
        });
        //SCR反应器出口烟气温度
        Float SCRfanyingqichukouyanqiwendu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[42], 16),
                Integer.parseInt(arrayHex[41], 16),
                Integer.parseInt(arrayHex[44], 16),
                Integer.parseInt(arrayHex[43], 16)
        });
        //SCR反应器出口烟气NH3浓度
        Float SCRfanyingqichukouyanqiNH3nongdu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[46], 16),
                Integer.parseInt(arrayHex[45], 16),
                Integer.parseInt(arrayHex[48], 16),
                Integer.parseInt(arrayHex[47], 16)
        });
        //机组锅炉负荷
        Float jizuguolufuhe_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[50], 16),
                Integer.parseInt(arrayHex[49], 16),
                Integer.parseInt(arrayHex[52], 16),
                Integer.parseInt(arrayHex[51], 16)
        });
        //SCR反应器XAIG前烟道流量
        Float SCRfanyingqiXAIGqianyandaoliuliang_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[54], 16),
                Integer.parseInt(arrayHex[53], 16),
                Integer.parseInt(arrayHex[56], 16),
                Integer.parseInt(arrayHex[55], 16)
        });
        ;
        //SCR反应器XAIG前烟道O2浓度
        Float SCRfanyingqiXAIGqianyandaoO2nongdu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[58], 16),
                Integer.parseInt(arrayHex[57], 16),
                Integer.parseInt(arrayHex[60], 16),
                Integer.parseInt(arrayHex[59], 16)
        });
        //SCR反应器XAIG前烟道烟气NOX浓度
        Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[62], 16),
                Integer.parseInt(arrayHex[61], 16),
                Integer.parseInt(arrayHex[64], 16),
                Integer.parseInt(arrayHex[63], 16)
        });
        //SCR反应器X进口烟气温度1
        Float SCRfanyingqiXjinkouyanqiwendu1_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[66], 16),
                Integer.parseInt(arrayHex[65], 16),
                Integer.parseInt(arrayHex[68], 16),
                Integer.parseInt(arrayHex[67], 16)
        });
        //氨气流量
        Float anqiliuliang_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[70], 16),
                Integer.parseInt(arrayHex[69], 16),
                Integer.parseInt(arrayHex[72], 16),
                Integer.parseInt(arrayHex[71], 16)
        });
        //反应器X烟气压差1
        Float fanyingqiXyanqiyacha1_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[74], 16),
                Integer.parseInt(arrayHex[73], 16),
                Integer.parseInt(arrayHex[76], 16),
                Integer.parseInt(arrayHex[75], 16)
        });
        //反应器X烟气压差2
        Float fanyingqiXyanqiyacha2_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[78], 16),
                Integer.parseInt(arrayHex[77], 16),
                Integer.parseInt(arrayHex[80], 16),
                Integer.parseInt(arrayHex[79], 16)
        });
        //反应器X烟气压差3
        Float fanyingqiXyanqiyacha3_1_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[82], 16),
                Integer.parseInt(arrayHex[81], 16),
                Integer.parseInt(arrayHex[84], 16),
                Integer.parseInt(arrayHex[83], 16)
        });
        //----------------------------------------------------------------------------------
// 解析锅炉编号
        String guolubianhao_1_b = "";
        guolubianhao_1_b = String.valueOf((char) Integer.parseInt(arrayHex[161], 16));

        // 解析工艺类型脱硝TX
        String gongyileixingTX_1_b = "";
        StringBuffer sbGongyileixingTX_1_b = new StringBuffer();
        for (int i = 162; i <= 163; i++) {
            sbGongyileixingTX_1_b.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTX_1_b = sbGongyileixingTX_1_b.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_1_b = "";
        zhilisheshibianhao_1_b = String.valueOf((char) Integer.parseInt(arrayHex[164], 16));

        //SCR反应器出口烟气O2浓度
        Float SCRfanyingqichukouyanqiO2nongdu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[166], 16),
                Integer.parseInt(arrayHex[165], 16),
                Integer.parseInt(arrayHex[168], 16),
                Integer.parseInt(arrayHex[167], 16)
        });
        //SCR反应器出口烟气NOX浓度
        Float SCRfanyingqichukouyanqiNOXnongdu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[170], 16),
                Integer.parseInt(arrayHex[169], 16),
                Integer.parseInt(arrayHex[172], 16),
                Integer.parseInt(arrayHex[171], 16)
        });
        //SCR反应器出口烟气温度
        Float SCRfanyingqichukouyanqiwendu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[174], 16),
                Integer.parseInt(arrayHex[173], 16),
                Integer.parseInt(arrayHex[176], 16),
                Integer.parseInt(arrayHex[175], 16)
        });
        //SCR反应器出口烟气NH3浓度
        Float SCRfanyingqichukouyanqiNH3nongdu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[178], 16),
                Integer.parseInt(arrayHex[177], 16),
                Integer.parseInt(arrayHex[180], 16),
                Integer.parseInt(arrayHex[179], 16)
        });
        //机组锅炉负荷
        Float jizuguolufuhe_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[182], 16),
                Integer.parseInt(arrayHex[181], 16),
                Integer.parseInt(arrayHex[184], 16),
                Integer.parseInt(arrayHex[183], 16)
        });
        //SCR反应器XAIG前烟道流量
        Float SCRfanyingqiXAIGqianyandaoliuliang_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[186], 16),
                Integer.parseInt(arrayHex[185], 16),
                Integer.parseInt(arrayHex[188], 16),
                Integer.parseInt(arrayHex[187], 16)
        });
        ;
        //SCR反应器XAIG前烟道O2浓度
        Float SCRfanyingqiXAIGqianyandaoO2nongdu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[190], 16),
                Integer.parseInt(arrayHex[189], 16),
                Integer.parseInt(arrayHex[192], 16),
                Integer.parseInt(arrayHex[191], 16)
        });
        //SCR反应器XAIG前烟道烟气NOX浓度
        Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[194], 16),
                Integer.parseInt(arrayHex[193], 16),
                Integer.parseInt(arrayHex[196], 16),
                Integer.parseInt(arrayHex[195], 16)
        });
        //SCR反应器X进口烟气温度1
        Float SCRfanyingqiXjinkouyanqiwendu1_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[198], 16),
                Integer.parseInt(arrayHex[197], 16),
                Integer.parseInt(arrayHex[200], 16),
                Integer.parseInt(arrayHex[199], 16)
        });
        //氨气流量
        Float anqiliuliang_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[202], 16),
                Integer.parseInt(arrayHex[201], 16),
                Integer.parseInt(arrayHex[204], 16),
                Integer.parseInt(arrayHex[203], 16)
        });
        //反应器X烟气压差1
        Float fanyingqiXyanqiyacha1_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[206], 16),
                Integer.parseInt(arrayHex[205], 16),
                Integer.parseInt(arrayHex[208], 16),
                Integer.parseInt(arrayHex[207], 16)
        });
        //反应器X烟气压差2
        Float fanyingqiXyanqiyacha2_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[210], 16),
                Integer.parseInt(arrayHex[209], 16),
                Integer.parseInt(arrayHex[212], 16),
                Integer.parseInt(arrayHex[211], 16)
        });
        //反应器X烟气压差3
        Float fanyingqiXyanqiyacha3_1_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[214], 16),
                Integer.parseInt(arrayHex[213], 16),
                Integer.parseInt(arrayHex[216], 16),
                Integer.parseInt(arrayHex[215], 16)
        });
//--------------------------------------------------------------------------------------
        // 解析锅炉编号
        String guolubianhao_1 = "";
        guolubianhao_1 = String.valueOf((char) Integer.parseInt(arrayHex[293], 16));

        // 解析工艺类型脱硫TS
        String gongyileixingTS_1 = "";
        StringBuffer sbGongyileixingTS_1 = new StringBuffer();
        for (int i = 294; i <= 295; i++) {
            sbGongyileixingTS_1.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTS_1 = sbGongyileixingTS_1.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_1 = "";
        zhilisheshibianhao_1 = String.valueOf((char) Integer.parseInt(arrayHex[296], 16));

        //入口烟气量
        Float rukouyanqiliang_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[298], 16),
                Integer.parseInt(arrayHex[297], 16),
                Integer.parseInt(arrayHex[300], 16),
                Integer.parseInt(arrayHex[299], 16)
        });
        //入口硫浓度
        Float rukouliunongdu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[302], 16),
                Integer.parseInt(arrayHex[301], 16),
                Integer.parseInt(arrayHex[304], 16),
                Integer.parseInt(arrayHex[303], 16)
        });
        //入口O2浓度
        Float rukouO2nongdu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[306], 16),
                Integer.parseInt(arrayHex[305], 16),
                Integer.parseInt(arrayHex[308], 16),
                Integer.parseInt(arrayHex[307], 16),
        });
        //入口烟温
        Float rukouyanwen_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[310], 16),
                Integer.parseInt(arrayHex[309], 16),
                Integer.parseInt(arrayHex[312], 16),
                Integer.parseInt(arrayHex[311], 16)
        });
        //入口烟气湿度
        Float rukouyanqishidu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[314], 16),
                Integer.parseInt(arrayHex[313], 16),
                Integer.parseInt(arrayHex[316], 16),
                Integer.parseInt(arrayHex[315], 16)
        });
        //石灰石供浆量
        Float shihuishigongjiangliang_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[318], 16),
                Integer.parseInt(arrayHex[317], 16),
                Integer.parseInt(arrayHex[320], 16),
                Integer.parseInt(arrayHex[319], 16)
        });
        //石膏液密度
        Float shigaoyemidu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[322], 16),
                Integer.parseInt(arrayHex[321], 16),
                Integer.parseInt(arrayHex[324], 16),
                Integer.parseInt(arrayHex[323], 16)
        });
        //PH值
        Float PHzhi_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[326], 16),
                Integer.parseInt(arrayHex[325], 16),
                Integer.parseInt(arrayHex[328], 16),
                Integer.parseInt(arrayHex[327], 16)
        });
        //出口烟气量
        Float chukouyanqiliang_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[330], 16),
                Integer.parseInt(arrayHex[329], 16),
                Integer.parseInt(arrayHex[332], 16),
                Integer.parseInt(arrayHex[331], 16)
        });
        //出口硫浓度
        Float chukouliunongdu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[334], 16),
                Integer.parseInt(arrayHex[333], 16),
                Integer.parseInt(arrayHex[336], 16),
                Integer.parseInt(arrayHex[335], 16)
        });
        //出口O2浓度
        Float chukouO2nongdu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[338], 16),
                Integer.parseInt(arrayHex[337], 16),
                Integer.parseInt(arrayHex[340], 16),
                Integer.parseInt(arrayHex[339], 16)
        });
        //出口烟温
        Float chukouyanwen_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[342], 16),
                Integer.parseInt(arrayHex[341], 16),
                Integer.parseInt(arrayHex[344], 16),
                Integer.parseInt(arrayHex[343], 16)
        });
        //出口烟气湿度
        Float chukouyanqishidu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[346], 16),
                Integer.parseInt(arrayHex[345], 16),
                Integer.parseInt(arrayHex[348], 16),
                Integer.parseInt(arrayHex[347], 16)
        });
        //入口烟气压力
        Float rukouyanqiyali_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[350], 16),
                Integer.parseInt(arrayHex[349], 16),
                Integer.parseInt(arrayHex[352], 16),
                Integer.parseInt(arrayHex[351], 16)
        });
        //出口烟气压力
        Float chukouyanqiyali_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[354], 16),
                Integer.parseInt(arrayHex[353], 16),
                Integer.parseInt(arrayHex[356], 16),
                Integer.parseInt(arrayHex[355], 16)
        });
        //入口烟气粉尘度
        Float rukouyanqifenchendu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[358], 16),
                Integer.parseInt(arrayHex[357], 16),
                Integer.parseInt(arrayHex[360], 16),
                Integer.parseInt(arrayHex[359], 16)
        });
        //出口烟气粉尘度
        Float chukouyanqifenchendu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[362], 16),
                Integer.parseInt(arrayHex[361], 16),
                Integer.parseInt(arrayHex[364], 16),
                Integer.parseInt(arrayHex[363], 16)
        });
        //1#循环泵开关状态
        Integer no1xunhuanbengkaiguanzhuangtai_1 = Integer.parseInt(arrayHex[365], 16) - 48;
        //2#循环泵开关状态
        Integer no2xunhuanbengkaiguanzhuangtai_1 = Integer.parseInt(arrayHex[366], 16) - 48;
        //3#循环泵开关状态
        Integer no3xunhuanbengkaiguanzhuangtai_1 = Integer.parseInt(arrayHex[367], 16) - 48;
        //4#循环泵开关状态
        Integer no4xunhuanbengkaiguanzhuangtai_1 = Integer.parseInt(arrayHex[368], 16) - 48;
        //1#氧化风机开关状态
        Integer no1yanghuafengjikaiguanzhuangtai_1 = Integer.parseInt(arrayHex[369], 16) - 48;
        //2#氧化风机开关状态
        Integer no2yanghuafengjikaiguanzhuangtai_1 = Integer.parseInt(arrayHex[370], 16) - 48;
        //X机组石灰石浆液密度
        Float shihuishijiangyemidu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[372], 16),
                Integer.parseInt(arrayHex[371], 16),
                Integer.parseInt(arrayHex[374], 16),
                Integer.parseInt(arrayHex[373], 16)
        });
        //锅炉负荷
        Float guolufuhe_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[376], 16),
                Integer.parseInt(arrayHex[375], 16),
                Integer.parseInt(arrayHex[378], 16),
                Integer.parseInt(arrayHex[377], 16)
        });
        //1#循环泵电流
        Float no1xunhuanbengdianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[380], 16),
                Integer.parseInt(arrayHex[379], 16),
                Integer.parseInt(arrayHex[382], 16),
                Integer.parseInt(arrayHex[381], 16)
        });
        //2#循环泵电流
        Float no2xunhuanbengdianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[384], 16),
                Integer.parseInt(arrayHex[383], 16),
                Integer.parseInt(arrayHex[386], 16),
                Integer.parseInt(arrayHex[385], 16)
        });
        //3#循环泵电流
        Float no3xunhuanbengdianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[388], 16),
                Integer.parseInt(arrayHex[387], 16),
                Integer.parseInt(arrayHex[390], 16),
                Integer.parseInt(arrayHex[389], 16)
        });
        //4#循环泵电流
        Float no4xunhuanbengdianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[392], 16),
                Integer.parseInt(arrayHex[391], 16),
                Integer.parseInt(arrayHex[394], 16),
                Integer.parseInt(arrayHex[393], 16)
        });
        //1#氧化风机电流
        Float no1yanghuafengjidianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[396], 16),
                Integer.parseInt(arrayHex[395], 16),
                Integer.parseInt(arrayHex[398], 16),
                Integer.parseInt(arrayHex[397], 16)
        });
        //2#氧化风机电流
        Float no2yanghuafengjidianliu_1 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[400], 16),
                Integer.parseInt(arrayHex[399], 16),
                Integer.parseInt(arrayHex[402], 16),
                Integer.parseInt(arrayHex[401], 16)
        });
        //=================================================================================================
// 解析机组编号
        String jizubianhao_2 = "";
        jizubianhao_2 = String.valueOf((char) Integer.parseInt(arrayHex[425], 16));

        // 解析时分秒
        String shifenmiao_2 = "";
        StringBuffer sbShifenmiao_2 = new StringBuffer();
        for (int i = 426; i <= 433; i++) {
            sbShifenmiao_2.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        shifenmiao_2 = sbShifenmiao_2.toString();

        // 解析锅炉编号
        String guolubianhao_2_a = "";
        guolubianhao_2_a = String.valueOf((char) Integer.parseInt(arrayHex[437], 16));

        // 解析工艺类型脱硝TX
        String gongyileixingTX_2_a = "";
        StringBuffer sbGongyileixingTX_2_a = new StringBuffer();
        for (int i = 438; i <= 439; i++) {
            sbGongyileixingTX_2_a.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTX_2_a = sbGongyileixingTX_2_a.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_2_a = "";
        zhilisheshibianhao_2_a = String.valueOf((char) Integer.parseInt(arrayHex[440], 16));

        //SCR反应器出口烟气O2浓度
        Float SCRfanyingqichukouyanqiO2nongdu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[442], 16),
                Integer.parseInt(arrayHex[441], 16),
                Integer.parseInt(arrayHex[444], 16),
                Integer.parseInt(arrayHex[443], 16)
        });
        //SCR反应器出口烟气NOX浓度
        Float SCRfanyingqichukouyanqiNOXnongdu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[446], 16),
                Integer.parseInt(arrayHex[445], 16),
                Integer.parseInt(arrayHex[448], 16),
                Integer.parseInt(arrayHex[447], 16)
        });
        //SCR反应器出口烟气温度
        Float SCRfanyingqichukouyanqiwendu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[450], 16),
                Integer.parseInt(arrayHex[449], 16),
                Integer.parseInt(arrayHex[452], 16),
                Integer.parseInt(arrayHex[451], 16)
        });
        //SCR反应器出口烟气NH3浓度
        Float SCRfanyingqichukouyanqiNH3nongdu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[454], 16),
                Integer.parseInt(arrayHex[453], 16),
                Integer.parseInt(arrayHex[456], 16),
                Integer.parseInt(arrayHex[455], 16)});
        //机组锅炉负荷
        Float jizuguolufuhe_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[458], 16),
                Integer.parseInt(arrayHex[457], 16),
                Integer.parseInt(arrayHex[460], 16),
                Integer.parseInt(arrayHex[459], 16)});
        //SCR反应器XAIG前烟道流量
        Float SCRfanyingqiXAIGqianyandaoliuliang_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[462], 16),
                Integer.parseInt(arrayHex[461], 16),
                Integer.parseInt(arrayHex[464], 16),
                Integer.parseInt(arrayHex[463], 16)});
        ;
        //SCR反应器XAIG前烟道O2浓度
        Float SCRfanyingqiXAIGqianyandaoO2nongdu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[466], 16),
                Integer.parseInt(arrayHex[465], 16),
                Integer.parseInt(arrayHex[468], 16),
                Integer.parseInt(arrayHex[467], 16)});
        //SCR反应器XAIG前烟道烟气NOX浓度
        Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[470], 16),
                Integer.parseInt(arrayHex[469], 16),
                Integer.parseInt(arrayHex[472], 16),
                Integer.parseInt(arrayHex[471], 16)});
        //SCR反应器X进口烟气温度1
        Float SCRfanyingqiXjinkouyanqiwendu1_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[474], 16),
                Integer.parseInt(arrayHex[473], 16),
                Integer.parseInt(arrayHex[476], 16),
                Integer.parseInt(arrayHex[475], 16)});
        //氨气流量
        Float anqiliuliang_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[478], 16),
                Integer.parseInt(arrayHex[477], 16),
                Integer.parseInt(arrayHex[480], 16),
                Integer.parseInt(arrayHex[479], 16)});
        //反应器X烟气压差1
        Float fanyingqiXyanqiyacha1_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[482], 16),
                Integer.parseInt(arrayHex[481], 16),
                Integer.parseInt(arrayHex[484], 16),
                Integer.parseInt(arrayHex[483], 16)});
        //反应器X烟气压差2
        Float fanyingqiXyanqiyacha2_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[486], 16),
                Integer.parseInt(arrayHex[485], 16),
                Integer.parseInt(arrayHex[488], 16),
                Integer.parseInt(arrayHex[487], 16)});
        //反应器X烟气压差3
        Float fanyingqiXyanqiyacha3_2_a = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[490], 16),
                Integer.parseInt(arrayHex[489], 16),
                Integer.parseInt(arrayHex[492], 16),
                Integer.parseInt(arrayHex[491], 16)});
        //----------------------------------------------------------------------------------
// 解析锅炉编号
        String guolubianhao_2_b = "";
        guolubianhao_2_b = String.valueOf((char) Integer.parseInt(arrayHex[569], 16));

        // 解析工艺类型脱硝TX
        String gongyileixingTX_2_b = "";
        StringBuffer sbGongyileixingTX_2_b = new StringBuffer();
        for (int i = 570; i <= 571; i++) {
            sbGongyileixingTX_2_b.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTX_2_b = sbGongyileixingTX_2_b.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_2_b = "";
        zhilisheshibianhao_2_b = String.valueOf((char) Integer.parseInt(arrayHex[572], 16));

        //SCR反应器出口烟气O2浓度
        Float SCRfanyingqichukouyanqiO2nongdu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[574], 16),
                Integer.parseInt(arrayHex[573], 16),
                Integer.parseInt(arrayHex[576], 16),
                Integer.parseInt(arrayHex[575], 16)});
        //SCR反应器出口烟气NOX浓度
        Float SCRfanyingqichukouyanqiNOXnongdu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[578], 16),
                Integer.parseInt(arrayHex[577], 16),
                Integer.parseInt(arrayHex[580], 16),
                Integer.parseInt(arrayHex[579], 16)});
        //SCR反应器出口烟气温度
        Float SCRfanyingqichukouyanqiwendu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[582], 16),
                Integer.parseInt(arrayHex[581], 16),
                Integer.parseInt(arrayHex[584], 16),
                Integer.parseInt(arrayHex[583], 16)});
        //SCR反应器出口烟气NH3浓度
        Float SCRfanyingqichukouyanqiNH3nongdu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[586], 16),
                Integer.parseInt(arrayHex[585], 16),
                Integer.parseInt(arrayHex[588], 16),
                Integer.parseInt(arrayHex[587], 16)});
        //机组锅炉负荷
        Float jizuguolufuhe_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[590], 16),
                Integer.parseInt(arrayHex[589], 16),
                Integer.parseInt(arrayHex[592], 16),
                Integer.parseInt(arrayHex[591], 16)});
        //SCR反应器XAIG前烟道流量
        Float SCRfanyingqiXAIGqianyandaoliuliang_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[594], 16),
                Integer.parseInt(arrayHex[593], 16),
                Integer.parseInt(arrayHex[596], 16),
                Integer.parseInt(arrayHex[595], 16)});
        ;
        //SCR反应器XAIG前烟道O2浓度
        Float SCRfanyingqiXAIGqianyandaoO2nongdu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[598], 16),
                Integer.parseInt(arrayHex[597], 16),
                Integer.parseInt(arrayHex[600], 16),
                Integer.parseInt(arrayHex[599], 16)});
        //SCR反应器XAIG前烟道烟气NOX浓度
        Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[602], 16),
                Integer.parseInt(arrayHex[601], 16),
                Integer.parseInt(arrayHex[604], 16),
                Integer.parseInt(arrayHex[603], 16)});
        //SCR反应器X进口烟气温度1
        Float SCRfanyingqiXjinkouyanqiwendu1_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[606], 16),
                Integer.parseInt(arrayHex[605], 16),
                Integer.parseInt(arrayHex[608], 16),
                Integer.parseInt(arrayHex[607], 16)});
        //氨气流量
        Float anqiliuliang_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[610], 16),
                Integer.parseInt(arrayHex[609], 16),
                Integer.parseInt(arrayHex[612], 16),
                Integer.parseInt(arrayHex[611], 16)});
        //反应器X烟气压差1
        Float fanyingqiXyanqiyacha1_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[614], 16),
                Integer.parseInt(arrayHex[613], 16),
                Integer.parseInt(arrayHex[616], 16),
                Integer.parseInt(arrayHex[615], 16)});
        //反应器X烟气压差2
        Float fanyingqiXyanqiyacha2_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[618], 16),
                Integer.parseInt(arrayHex[617], 16),
                Integer.parseInt(arrayHex[620], 16),
                Integer.parseInt(arrayHex[619], 16)});
        //反应器X烟气压差3
        Float fanyingqiXyanqiyacha3_2_b = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[622], 16),
                Integer.parseInt(arrayHex[621], 16),
                Integer.parseInt(arrayHex[624], 16),
                Integer.parseInt(arrayHex[623], 16)});
//--------------------------------------------------------------------------------------
        // 解析锅炉编号
        String guolubianhao_2 = "";
        guolubianhao_2 = String.valueOf((char) Integer.parseInt(arrayHex[701], 16));

        // 解析工艺类型脱硫TS
        String gongyileixingTS_2 = "";
        StringBuffer sbGongyileixingTS_2 = new StringBuffer();
        for (int i = 702; i <= 703; i++) {
            sbGongyileixingTS_2.append((char) Integer.parseInt(arrayHex[i], 16));
        }
        gongyileixingTS_2 = sbGongyileixingTS_2.toString();

        // 解析治理设施编号
        String zhilisheshibianhao_2 = "";
        zhilisheshibianhao_2 = String.valueOf((char) Integer.parseInt(arrayHex[704], 16));

        //入口烟气量
        Float rukouyanqiliang_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[706], 16),
                Integer.parseInt(arrayHex[705], 16),
                Integer.parseInt(arrayHex[708], 16),
                Integer.parseInt(arrayHex[707], 16)});
        //入口硫浓度
        Float rukouliunongdu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[710], 16),
                Integer.parseInt(arrayHex[709], 16),
                Integer.parseInt(arrayHex[712], 16),
                Integer.parseInt(arrayHex[711], 16)});
        //入口O2浓度
        Float rukouO2nongdu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[714], 16),
                Integer.parseInt(arrayHex[713], 16),
                Integer.parseInt(arrayHex[716], 16),
                Integer.parseInt(arrayHex[715], 16)});
        //入口烟温
        Float rukouyanwen_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[718], 16),
                Integer.parseInt(arrayHex[717], 16),
                Integer.parseInt(arrayHex[720], 16),
                Integer.parseInt(arrayHex[719], 16)});
        //入口烟气湿度
        Float rukouyanqishidu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[722], 16),
                Integer.parseInt(arrayHex[721], 16),
                Integer.parseInt(arrayHex[724], 16),
                Integer.parseInt(arrayHex[723], 16)});
        //石灰石供浆量
        Float shihuishigongjiangliang_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[726], 16),
                Integer.parseInt(arrayHex[725], 16),
                Integer.parseInt(arrayHex[728], 16),
                Integer.parseInt(arrayHex[727], 16)});
        //石膏液密度
        Float shigaoyemidu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[730], 16),
                Integer.parseInt(arrayHex[729], 16),
                Integer.parseInt(arrayHex[732], 16),
                Integer.parseInt(arrayHex[731], 16)});
        //PH值
        Float PHzhi_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[734], 16),
                Integer.parseInt(arrayHex[733], 16),
                Integer.parseInt(arrayHex[736], 16),
                Integer.parseInt(arrayHex[735], 16)});
        //出口烟气量
        Float chukouyanqiliang_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[738], 16),
                Integer.parseInt(arrayHex[737], 16),
                Integer.parseInt(arrayHex[740], 16),
                Integer.parseInt(arrayHex[739], 16)});
        //出口硫浓度
        Float chukouliunongdu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[742], 16),
                Integer.parseInt(arrayHex[741], 16),
                Integer.parseInt(arrayHex[744], 16),
                Integer.parseInt(arrayHex[743], 16)});
        //出口O2浓度
        Float chukouO2nongdu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[746], 16),
                Integer.parseInt(arrayHex[745], 16),
                Integer.parseInt(arrayHex[748], 16),
                Integer.parseInt(arrayHex[747], 16)});
        //出口烟温
        Float chukouyanwen_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[750], 16),
                Integer.parseInt(arrayHex[749], 16),
                Integer.parseInt(arrayHex[752], 16),
                Integer.parseInt(arrayHex[751], 16)});
        //出口烟气湿度
        Float chukouyanqishidu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[754], 16),
                Integer.parseInt(arrayHex[753], 16),
                Integer.parseInt(arrayHex[756], 16),
                Integer.parseInt(arrayHex[755], 16)});
        //入口烟气压力
        Float rukouyanqiyali_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[758], 16),
                Integer.parseInt(arrayHex[757], 16),
                Integer.parseInt(arrayHex[760], 16),
                Integer.parseInt(arrayHex[759], 16)});
        //出口烟气压力
        Float chukouyanqiyali_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[762], 16),
                Integer.parseInt(arrayHex[761], 16),
                Integer.parseInt(arrayHex[764], 16),
                Integer.parseInt(arrayHex[763], 16)});
        //入口烟气粉尘度
        Float rukouyanqifenchendu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[766], 16),
                Integer.parseInt(arrayHex[765], 16),
                Integer.parseInt(arrayHex[768], 16),
                Integer.parseInt(arrayHex[767], 16)});
        //出口烟气粉尘度
        Float chukouyanqifenchendu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[770], 16),
                Integer.parseInt(arrayHex[769], 16),
                Integer.parseInt(arrayHex[772], 16),
                Integer.parseInt(arrayHex[771], 16)});
        //1#循环泵开关状态
        Integer no1xunhuanbengkaiguanzhuangtai_2 = Integer.parseInt(arrayHex[773], 16) - 48;
        //2#循环泵开关状态
        Integer no2xunhuanbengkaiguanzhuangtai_2 = Integer.parseInt(arrayHex[774], 16) - 48;
        //3#循环泵开关状态
        Integer no3xunhuanbengkaiguanzhuangtai_2 = Integer.parseInt(arrayHex[775], 16) - 48;
        //4#循环泵开关状态
        Integer no4xunhuanbengkaiguanzhuangtai_2 = Integer.parseInt(arrayHex[776], 16) - 48;
        //1#氧化风机开关状态
        Integer no1yanghuafengjikaiguanzhuangtai_2 = Integer.parseInt(arrayHex[777], 16) - 48;
        //2#氧化风机开关状态
        Integer no2yanghuafengjikaiguanzhuangtai_2 = Integer.parseInt(arrayHex[778], 16) - 48;
        //X机组石灰石浆液密度
        Float shihuishijiangyemidu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[780], 16),
                Integer.parseInt(arrayHex[779], 16),
                Integer.parseInt(arrayHex[782], 16),
                Integer.parseInt(arrayHex[781], 16)});
        //锅炉负荷
        Float guolufuhe_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[784], 16),
                Integer.parseInt(arrayHex[783], 16),
                Integer.parseInt(arrayHex[786], 16),
                Integer.parseInt(arrayHex[785], 16)});
        //1#循环泵电流
        Float no1xunhuanbengdianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[788], 16),
                Integer.parseInt(arrayHex[787], 16),
                Integer.parseInt(arrayHex[790], 16),
                Integer.parseInt(arrayHex[789], 16)
        });
        //2#循环泵电流
        Float no2xunhuanbengdianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[792], 16),
                Integer.parseInt(arrayHex[791], 16),
                Integer.parseInt(arrayHex[794], 16),
                Integer.parseInt(arrayHex[793], 16)
        });
        //3#循环泵电流
        Float no3xunhuanbengdianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[796], 16),
                Integer.parseInt(arrayHex[795], 16),
                Integer.parseInt(arrayHex[798], 16),
                Integer.parseInt(arrayHex[797], 16)
        });
        //4#循环泵电流
        Float no4xunhuanbengdianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[800], 16),
                Integer.parseInt(arrayHex[799], 16),
                Integer.parseInt(arrayHex[802], 16),
                Integer.parseInt(arrayHex[801], 16)
        });
        //1#氧化风机电流
        Float no1yanghuafengjidianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[804], 16),
                Integer.parseInt(arrayHex[803], 16),
                Integer.parseInt(arrayHex[806], 16),
                Integer.parseInt(arrayHex[805], 16)
        });
        //2#氧化风机电流
        Float no2yanghuafengjidianliu_2 = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[808], 16),
                Integer.parseInt(arrayHex[807], 16),
                Integer.parseInt(arrayHex[810], 16),
                Integer.parseInt(arrayHex[809], 16)
        });


        LOGGER.debug("###############接收数据################");
        LOGGER.debug("企业ID:" + qiyeID);
        LOGGER.debug("排口编号:" + paikoubianhao);
        LOGGER.debug("年月日:" + nianyueri);
        LOGGER.debug("==============第一个机组================");
        LOGGER.debug("机组编号:" + jizubianhao_1);
        LOGGER.debug("时分秒:" + shifenmiao_1);
        LOGGER.debug("---------------第一个脱硝---------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_1_a);
        LOGGER.debug("工艺类型脱硝:" + gongyileixingTX_1_a);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_1_a);
        LOGGER.debug("SCR反应器A出口烟气O2浓度:" + SCRfanyingqichukouyanqiO2nongdu_1_a);
        LOGGER.debug("SCR反应器A出口烟气NOX浓度:" + SCRfanyingqichukouyanqiNOXnongdu_1_a);
        LOGGER.debug("SCR反应器A出口烟气温度:" + SCRfanyingqichukouyanqiwendu_1_a);
        LOGGER.debug("SCR反应器A出口烟气NH3浓度:" + SCRfanyingqichukouyanqiNH3nongdu_1_a);
        LOGGER.debug("机组锅炉负荷:" + jizuguolufuhe_1_a);
        LOGGER.debug("SCR反应器AAIG前烟道流量:" + SCRfanyingqiXAIGqianyandaoliuliang_1_a);
        LOGGER.debug("SCR反应器AAIG前烟道O2浓度:" + SCRfanyingqiXAIGqianyandaoO2nongdu_1_a);
        LOGGER.debug("SCR反应器AAIG前烟道烟气NOX浓度:" + SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a);
        LOGGER.debug("SCR反应器A进口烟气温度1:" + SCRfanyingqiXjinkouyanqiwendu1_1_a);
        LOGGER.debug("氨气流量；" + anqiliuliang_1_a);
        LOGGER.debug("反应器A烟气压差1:" + fanyingqiXyanqiyacha1_1_a);
        LOGGER.debug("反应器A烟气压差2:" + fanyingqiXyanqiyacha2_1_a);
        LOGGER.debug("反应器A烟气压差3:" + fanyingqiXyanqiyacha3_1_a);
        LOGGER.debug("-----------------第二个脱硝-----------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_1_b);
        LOGGER.debug("工艺类型脱硝:" + gongyileixingTX_1_b);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_1_b);
        LOGGER.debug("SCR反应器B出口烟气O2浓度:" + SCRfanyingqichukouyanqiO2nongdu_1_b);
        LOGGER.debug("SCR反应器B出口烟气NOX浓度:" + SCRfanyingqichukouyanqiNOXnongdu_1_b);
        LOGGER.debug("SCR反应器B出口烟气温度:" + SCRfanyingqichukouyanqiwendu_1_b);
        LOGGER.debug("SCR反应器B出口烟气NH3浓度:" + SCRfanyingqichukouyanqiNH3nongdu_1_b);
        LOGGER.debug("机组锅炉负荷:" + jizuguolufuhe_1_b);
        LOGGER.debug("SCR反应器BAIG前烟道流量:" + SCRfanyingqiXAIGqianyandaoliuliang_1_b);
        LOGGER.debug("SCR反应器BAIG前烟道O2浓度:" + SCRfanyingqiXAIGqianyandaoO2nongdu_1_b);
        LOGGER.debug("SCR反应器BAIG前烟道烟气NOX浓度:" + SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b);
        LOGGER.debug("SCR反应器B进口烟气温度1:" + SCRfanyingqiXjinkouyanqiwendu1_1_b);
        LOGGER.debug("氨气流量；" + anqiliuliang_1_b);
        LOGGER.debug("反应器B烟气压差1:" + fanyingqiXyanqiyacha1_1_b);
        LOGGER.debug("反应器B烟气压差2:" + fanyingqiXyanqiyacha2_1_b);
        LOGGER.debug("反应器B烟气压差3:" + fanyingqiXyanqiyacha3_1_b);
        LOGGER.debug("--------------------脱硫-----------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_1);
        LOGGER.debug("工艺类型脱硫:" + gongyileixingTS_1);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_1);
        LOGGER.debug("入口烟气量:" + rukouyanqiliang_1);
        LOGGER.debug("入口硫浓度:" + rukouliunongdu_1);
        LOGGER.debug("入口O2浓度:" + rukouO2nongdu_1);
        LOGGER.debug("入口烟温:" + rukouyanwen_1);
        LOGGER.debug("入口烟气湿度:" + rukouyanqishidu_1);
        LOGGER.debug("石灰石供浆量:" + shihuishigongjiangliang_1);
        LOGGER.debug("石膏液密度:" + shigaoyemidu_1);
        LOGGER.debug("PH值:" + PHzhi_1);
        LOGGER.debug("出口烟气量:" + chukouyanqiliang_1);
        LOGGER.debug("出口硫浓度:" + chukouliunongdu_1);
        LOGGER.debug("出口O2浓度:" + chukouO2nongdu_1);
        LOGGER.debug("出口烟温:" + chukouyanwen_1);
        LOGGER.debug("出口烟气湿度:" + chukouyanqishidu_1);
        LOGGER.debug("入口烟气压力:" + rukouyanqiyali_1);
        LOGGER.debug("出口烟气压力:" + chukouyanqiyali_1);
        LOGGER.debug("入口烟气粉尘度:" + rukouyanqifenchendu_1);
        LOGGER.debug("出口烟气粉尘度:" + chukouyanqifenchendu_1);
        LOGGER.debug("1#循环泵开关状态:" + no1xunhuanbengkaiguanzhuangtai_1);
        LOGGER.debug("2#循环泵开关状态:" + no2xunhuanbengkaiguanzhuangtai_1);
        LOGGER.debug("3#循环泵开关状态:" + no3xunhuanbengkaiguanzhuangtai_1);
        LOGGER.debug("4#循环泵开关状态:" + no4xunhuanbengkaiguanzhuangtai_1);
        LOGGER.debug("1#氧化风机开关状态:" + no1yanghuafengjikaiguanzhuangtai_1);
        LOGGER.debug("2#氧化风机开关状态:" + no2yanghuafengjikaiguanzhuangtai_1);
        LOGGER.debug("1机组石灰石浆液密度:" + shihuishijiangyemidu_1);
        LOGGER.debug("锅炉负荷:" + guolufuhe_1);
        LOGGER.debug("1#循环泵电流:" + no1xunhuanbengdianliu_1);
        LOGGER.debug("2#循环泵电流:" + no2xunhuanbengdianliu_1);
        LOGGER.debug("3#循环泵电流:" + no3xunhuanbengdianliu_1);
        LOGGER.debug("4#循环泵电流:" + no4xunhuanbengdianliu_1);
        LOGGER.debug("1#氧化风机电流:" + no1yanghuafengjidianliu_1);
        LOGGER.debug("2#氧化风机电流:" + no2yanghuafengjidianliu_1);

        LOGGER.debug("==============第二个机组================");
        LOGGER.debug("机组编号:" + jizubianhao_2);
        LOGGER.debug("时分秒:" + shifenmiao_2);
        LOGGER.debug("---------------第一个脱硝---------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_2_a);
        LOGGER.debug("工艺类型脱硝:" + gongyileixingTX_2_a);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_2_a);
        LOGGER.debug("SCR反应器A出口烟气O2浓度:" + SCRfanyingqichukouyanqiO2nongdu_2_a);
        LOGGER.debug("SCR反应器A出口烟气NOX浓度:" + SCRfanyingqichukouyanqiNOXnongdu_2_a);
        LOGGER.debug("SCR反应器A出口烟气温度:" + SCRfanyingqichukouyanqiwendu_2_a);
        LOGGER.debug("SCR反应器A出口烟气NH3浓度:" + SCRfanyingqichukouyanqiNH3nongdu_2_a);
        LOGGER.debug("机组锅炉负荷:" + jizuguolufuhe_2_a);
        LOGGER.debug("SCR反应器AAIG前烟道流量:" + SCRfanyingqiXAIGqianyandaoliuliang_2_a);
        LOGGER.debug("SCR反应器AAIG前烟道O2浓度:" + SCRfanyingqiXAIGqianyandaoO2nongdu_2_a);
        LOGGER.debug("SCR反应器AAIG前烟道烟气NOX浓度:" + SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a);
        LOGGER.debug("SCR反应器A进口烟气温度1:" + SCRfanyingqiXjinkouyanqiwendu1_2_a);
        LOGGER.debug("氨气流量；" + anqiliuliang_2_a);
        LOGGER.debug("反应器A烟气压差1:" + fanyingqiXyanqiyacha1_2_a);
        LOGGER.debug("反应器A烟气压差2:" + fanyingqiXyanqiyacha2_2_a);
        LOGGER.debug("反应器A烟气压差3:" + fanyingqiXyanqiyacha3_2_a);
        LOGGER.debug("-----------------第二个脱硝-----------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_2_b);
        LOGGER.debug("工艺类型脱硝:" + gongyileixingTX_2_b);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_2_b);
        LOGGER.debug("SCR反应器B出口烟气O2浓度:" + SCRfanyingqichukouyanqiO2nongdu_2_b);
        LOGGER.debug("SCR反应器B出口烟气NOX浓度:" + SCRfanyingqichukouyanqiNOXnongdu_2_b);
        LOGGER.debug("SCR反应器B出口烟气温度:" + SCRfanyingqichukouyanqiwendu_2_b);
        LOGGER.debug("SCR反应器B出口烟气NH3浓度:" + SCRfanyingqichukouyanqiNH3nongdu_2_b);
        LOGGER.debug("机组锅炉负荷:" + jizuguolufuhe_2_b);
        LOGGER.debug("SCR反应器BAIG前烟道流量:" + SCRfanyingqiXAIGqianyandaoliuliang_2_b);
        LOGGER.debug("SCR反应器BAIG前烟道O2浓度:" + SCRfanyingqiXAIGqianyandaoO2nongdu_2_b);
        LOGGER.debug("SCR反应器BAIG前烟道烟气NOX浓度:" + SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b);
        LOGGER.debug("SCR反应器B进口烟气温度1:" + SCRfanyingqiXjinkouyanqiwendu1_2_b);
        LOGGER.debug("氨气流量；" + anqiliuliang_2_b);
        LOGGER.debug("反应器B烟气压差1:" + fanyingqiXyanqiyacha1_2_b);
        LOGGER.debug("反应器B烟气压差2:" + fanyingqiXyanqiyacha2_2_b);
        LOGGER.debug("反应器B烟气压差3:" + fanyingqiXyanqiyacha3_2_b);
        LOGGER.debug("--------------------脱硫-----------------");
        LOGGER.debug("锅炉编号:" + guolubianhao_2);
        LOGGER.debug("工艺类型脱硫:" + gongyileixingTS_2);
        LOGGER.debug("治理设施编号:" + zhilisheshibianhao_2);
        LOGGER.debug("入口烟气量:" + rukouyanqiliang_2);
        LOGGER.debug("入口硫浓度:" + rukouliunongdu_2);
        LOGGER.debug("入口O2浓度:" + rukouO2nongdu_2);
        LOGGER.debug("入口烟温:" + rukouyanwen_2);
        LOGGER.debug("入口烟气湿度:" + rukouyanqishidu_2);
        LOGGER.debug("石灰石供浆量:" + shihuishigongjiangliang_2);
        LOGGER.debug("石膏液密度:" + shigaoyemidu_2);
        LOGGER.debug("PH值:" + PHzhi_2);
        LOGGER.debug("出口烟气量:" + chukouyanqiliang_2);
        LOGGER.debug("出口硫浓度:" + chukouliunongdu_2);
        LOGGER.debug("出口O2浓度:" + chukouO2nongdu_2);
        LOGGER.debug("出口烟温:" + chukouyanwen_2);
        LOGGER.debug("出口烟气湿度:" + chukouyanqishidu_2);
        LOGGER.debug("入口烟气压力:" + rukouyanqiyali_2);
        LOGGER.debug("出口烟气压力:" + chukouyanqiyali_2);
        LOGGER.debug("入口烟气粉尘度:" + rukouyanqifenchendu_2);
        LOGGER.debug("出口烟气粉尘度:" + chukouyanqifenchendu_2);
        LOGGER.debug("1#循环泵开关状态:" + no1xunhuanbengkaiguanzhuangtai_2);
        LOGGER.debug("2#循环泵开关状态:" + no2xunhuanbengkaiguanzhuangtai_2);
        LOGGER.debug("3#循环泵开关状态:" + no3xunhuanbengkaiguanzhuangtai_2);
        LOGGER.debug("4#循环泵开关状态:" + no4xunhuanbengkaiguanzhuangtai_2);
        LOGGER.debug("1#氧化风机开关状态:" + no1yanghuafengjikaiguanzhuangtai_2);
        LOGGER.debug("2#氧化风机开关状态:" + no2yanghuafengjikaiguanzhuangtai_2);
        LOGGER.debug("2机组石灰石浆液密度:" + shihuishijiangyemidu_2);
        LOGGER.debug("锅炉负荷:" + guolufuhe_2);
        LOGGER.debug("1#循环泵电流:" + no1xunhuanbengdianliu_2);
        LOGGER.debug("2#循环泵电流:" + no2xunhuanbengdianliu_2);
        LOGGER.debug("3#循环泵电流:" + no3xunhuanbengdianliu_2);
        LOGGER.debug("4#循环泵电流:" + no4xunhuanbengdianliu_2);
        LOGGER.debug("1#氧化风机电流:" + no1yanghuafengjidianliu_2);
        LOGGER.debug("2#氧化风机电流:" + no2yanghuafengjidianliu_2);


        workingDataEntity.setQiyeID(qiyeID);
        workingDataEntity.setPaikoubianhao(paikoubianhao);
        workingDataEntity.setNianyueri(nianyueri);
        workingDataEntity.setJizubianhao_1(jizubianhao_1);
        workingDataEntity.setShifenmiao_1(shifenmiao_1);
        workingDataEntity.setGuolubianhao_1_a(guolubianhao_1_a);
        workingDataEntity.setGongyileixingTX_1_a(gongyileixingTX_1_a);
        workingDataEntity.setZhilisheshibianhao_1_a(zhilisheshibianhao_1_a);
        workingDataEntity.setSCRfanyingqichukouyanqiO2nongdu_1_a(SCRfanyingqichukouyanqiO2nongdu_1_a);
        workingDataEntity.setSCRfanyingqichukouyanqiNOXnongdu_1_a(SCRfanyingqichukouyanqiNOXnongdu_1_a);
        workingDataEntity.setSCRfanyingqichukouyanqiwendu_1_a(SCRfanyingqichukouyanqiwendu_1_a);
        workingDataEntity.setSCRfanyingqichukouyanqiNH3nongdu_1_a(SCRfanyingqichukouyanqiNH3nongdu_1_a);
        workingDataEntity.setJizuguolufuhe_1_a(jizuguolufuhe_1_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoliuliang_1_a(SCRfanyingqiXAIGqianyandaoliuliang_1_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoO2nongdu_1_a(SCRfanyingqiXAIGqianyandaoO2nongdu_1_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a(SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a);
        workingDataEntity.setSCRfanyingqiXjinkouyanqiwendu1_1_a(SCRfanyingqiXjinkouyanqiwendu1_1_a);
        workingDataEntity.setAnqiliuliang_1_a(anqiliuliang_1_a);
        workingDataEntity.setFanyingqiXyanqiyacha1_1_a(fanyingqiXyanqiyacha1_1_a);
        workingDataEntity.setFanyingqiXyanqiyacha2_1_a(fanyingqiXyanqiyacha2_1_a);
        workingDataEntity.setFanyingqiXyanqiyacha3_1_a(fanyingqiXyanqiyacha3_1_a);
        workingDataEntity.setGuolubianhao_1_b(guolubianhao_1_b);
        workingDataEntity.setGongyileixingTX_1_b(gongyileixingTX_1_b);
        workingDataEntity.setZhilisheshibianhao_1_b(zhilisheshibianhao_1_b);
        workingDataEntity.setSCRfanyingqichukouyanqiO2nongdu_1_b(SCRfanyingqichukouyanqiO2nongdu_1_b);
        workingDataEntity.setSCRfanyingqichukouyanqiNOXnongdu_1_b(SCRfanyingqichukouyanqiNOXnongdu_1_b);
        workingDataEntity.setSCRfanyingqichukouyanqiwendu_1_b(SCRfanyingqichukouyanqiwendu_1_b);
        workingDataEntity.setSCRfanyingqichukouyanqiNH3nongdu_1_b(SCRfanyingqichukouyanqiNH3nongdu_1_b);
        workingDataEntity.setJizuguolufuhe_1_b(jizuguolufuhe_1_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoliuliang_1_b(SCRfanyingqiXAIGqianyandaoliuliang_1_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoO2nongdu_1_b(SCRfanyingqiXAIGqianyandaoO2nongdu_1_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b(SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b);
        workingDataEntity.setSCRfanyingqiXjinkouyanqiwendu1_1_b(SCRfanyingqiXjinkouyanqiwendu1_1_b);
        workingDataEntity.setAnqiliuliang_1_b(anqiliuliang_1_b);
        workingDataEntity.setFanyingqiXyanqiyacha1_1_b(fanyingqiXyanqiyacha1_1_b);
        workingDataEntity.setFanyingqiXyanqiyacha2_1_b(fanyingqiXyanqiyacha2_1_b);
        workingDataEntity.setFanyingqiXyanqiyacha3_1_b(fanyingqiXyanqiyacha3_1_b);
        workingDataEntity.setGuolubianhao_1(guolubianhao_1);
        workingDataEntity.setGongyileixingTS_1(gongyileixingTS_1);
        workingDataEntity.setZhilisheshibianhao_1(zhilisheshibianhao_1);
        workingDataEntity.setRukouyanqiliang_1(rukouyanqiliang_1);
        workingDataEntity.setRukouliunongdu_1(rukouliunongdu_1);
        workingDataEntity.setRukouO2nongdu_1(rukouO2nongdu_1);
        workingDataEntity.setRukouyanwen_1(rukouyanwen_1);
        workingDataEntity.setRukouyanqishidu_1(rukouyanqishidu_1);
        workingDataEntity.setShihuishigongjiangliang_1(shihuishigongjiangliang_1);
        workingDataEntity.setShigaoyemidu_1(shigaoyemidu_1);
        workingDataEntity.setPHzhi_1(PHzhi_1);
        workingDataEntity.setChukouyanqiliang_1(chukouyanqiliang_1);
        workingDataEntity.setChukouliunongdu_1(chukouliunongdu_1);
        workingDataEntity.setChukouO2nongdu_1(chukouO2nongdu_1);
        workingDataEntity.setChukouyanwen_1(chukouyanwen_1);
        workingDataEntity.setChukouyanqishidu_1(chukouyanqishidu_1);
        workingDataEntity.setRukouyanqiyali_1(rukouyanqiyali_1);
        workingDataEntity.setChukouyanqiyali_1(chukouyanqiyali_1);
        workingDataEntity.setRukouyanqifenchendu_1(rukouyanqifenchendu_1);
        workingDataEntity.setChukouyanqifenchendu_1(chukouyanqifenchendu_1);
        workingDataEntity.setNo1xunhuanbengkaiguanzhuangtai_1(no1xunhuanbengkaiguanzhuangtai_1);
        workingDataEntity.setNo2xunhuanbengkaiguanzhuangtai_1(no2xunhuanbengkaiguanzhuangtai_1);
        workingDataEntity.setNo3xunhuanbengkaiguanzhuangtai_1(no3xunhuanbengkaiguanzhuangtai_1);
        workingDataEntity.setNo4xunhuanbengkaiguanzhuangtai_1(no4xunhuanbengkaiguanzhuangtai_1);
        workingDataEntity.setNo1yanghuafengjikaiguanzhuangtai_1(no1yanghuafengjikaiguanzhuangtai_1);
        workingDataEntity.setNo2yanghuafengjikaiguanzhuangtai_1(no2yanghuafengjikaiguanzhuangtai_1);
        workingDataEntity.setShihuishijiangyemidu_1(shihuishijiangyemidu_1);
        workingDataEntity.setGuolufuhe_1(guolufuhe_1);
        workingDataEntity.setNo1xunhuanbengdianliu_1(no1xunhuanbengdianliu_1);
        workingDataEntity.setNo2xunhuanbengdianliu_1(no2xunhuanbengdianliu_1);
        workingDataEntity.setNo3xunhuanbengdianliu_1(no3xunhuanbengdianliu_1);
        workingDataEntity.setNo4xunhuanbengdianliu_1(no4xunhuanbengdianliu_1);
        workingDataEntity.setNo1yanghuafengjidianliu_1(no1yanghuafengjidianliu_1);
        workingDataEntity.setNo2yanghuafengjidianliu_1(no2yanghuafengjidianliu_1);
        workingDataEntity.setJizubianhao_2(jizubianhao_2);
        workingDataEntity.setShifenmiao_2(shifenmiao_2);
        workingDataEntity.setGuolubianhao_2_a(guolubianhao_2_a);
        workingDataEntity.setGongyileixingTX_2_a(gongyileixingTX_2_a);
        workingDataEntity.setZhilisheshibianhao_2_a(zhilisheshibianhao_2_a);
        workingDataEntity.setSCRfanyingqichukouyanqiO2nongdu_2_a(SCRfanyingqichukouyanqiO2nongdu_2_a);
        workingDataEntity.setSCRfanyingqichukouyanqiNOXnongdu_2_a(SCRfanyingqichukouyanqiNOXnongdu_2_a);
        workingDataEntity.setSCRfanyingqichukouyanqiwendu_2_a(SCRfanyingqichukouyanqiwendu_2_a);
        workingDataEntity.setSCRfanyingqichukouyanqiNH3nongdu_2_a(SCRfanyingqichukouyanqiNH3nongdu_2_a);
        workingDataEntity.setJizuguolufuhe_2_a(jizuguolufuhe_2_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoliuliang_2_a(SCRfanyingqiXAIGqianyandaoliuliang_2_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoO2nongdu_2_a(SCRfanyingqiXAIGqianyandaoO2nongdu_2_a);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a(SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a);
        workingDataEntity.setSCRfanyingqiXjinkouyanqiwendu1_2_a(SCRfanyingqiXjinkouyanqiwendu1_2_a);
        workingDataEntity.setAnqiliuliang_2_a(anqiliuliang_2_a);
        workingDataEntity.setFanyingqiXyanqiyacha1_2_a(fanyingqiXyanqiyacha1_2_a);
        workingDataEntity.setFanyingqiXyanqiyacha2_2_a(fanyingqiXyanqiyacha2_2_a);
        workingDataEntity.setFanyingqiXyanqiyacha3_2_a(fanyingqiXyanqiyacha3_2_a);
        workingDataEntity.setGuolubianhao_2_b(guolubianhao_2_b);
        workingDataEntity.setGongyileixingTX_2_b(gongyileixingTX_2_b);
        workingDataEntity.setZhilisheshibianhao_2_b(zhilisheshibianhao_2_b);
        workingDataEntity.setSCRfanyingqichukouyanqiO2nongdu_2_b(SCRfanyingqichukouyanqiO2nongdu_2_b);
        workingDataEntity.setSCRfanyingqichukouyanqiNOXnongdu_2_b(SCRfanyingqichukouyanqiNOXnongdu_2_b);
        workingDataEntity.setSCRfanyingqichukouyanqiwendu_2_b(SCRfanyingqichukouyanqiwendu_2_b);
        workingDataEntity.setSCRfanyingqichukouyanqiNH3nongdu_2_b(SCRfanyingqichukouyanqiNH3nongdu_2_b);
        workingDataEntity.setJizuguolufuhe_2_b(jizuguolufuhe_2_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoliuliang_2_b(SCRfanyingqiXAIGqianyandaoliuliang_2_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoO2nongdu_2_b(SCRfanyingqiXAIGqianyandaoO2nongdu_2_b);
        workingDataEntity.setSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b(SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b);
        workingDataEntity.setSCRfanyingqiXjinkouyanqiwendu1_2_b(SCRfanyingqiXjinkouyanqiwendu1_2_b);
        workingDataEntity.setAnqiliuliang_2_b(anqiliuliang_2_b);
        workingDataEntity.setFanyingqiXyanqiyacha1_2_b(fanyingqiXyanqiyacha1_2_b);
        workingDataEntity.setFanyingqiXyanqiyacha2_2_b(fanyingqiXyanqiyacha2_2_b);
        workingDataEntity.setFanyingqiXyanqiyacha3_2_b(fanyingqiXyanqiyacha3_2_b);
        workingDataEntity.setGuolubianhao_2(guolubianhao_2);
        workingDataEntity.setGongyileixingTS_2(gongyileixingTS_2);
        workingDataEntity.setZhilisheshibianhao_2(zhilisheshibianhao_2);
        workingDataEntity.setRukouyanqiliang_2(rukouyanqiliang_2);
        workingDataEntity.setRukouliunongdu_2(rukouliunongdu_2);
        workingDataEntity.setRukouO2nongdu_2(rukouO2nongdu_2);
        workingDataEntity.setRukouyanwen_2(rukouyanwen_2);
        workingDataEntity.setRukouyanqishidu_2(rukouyanqishidu_2);
        workingDataEntity.setShihuishigongjiangliang_2(shihuishigongjiangliang_2);
        workingDataEntity.setShigaoyemidu_2(shigaoyemidu_2);
        workingDataEntity.setPHzhi_2(PHzhi_2);
        workingDataEntity.setChukouyanqiliang_2(chukouyanqiliang_2);
        workingDataEntity.setChukouliunongdu_2(chukouliunongdu_2);
        workingDataEntity.setChukouO2nongdu_2(chukouO2nongdu_2);
        workingDataEntity.setChukouyanwen_2(chukouyanwen_2);
        workingDataEntity.setChukouyanqishidu_2(chukouyanqishidu_2);
        workingDataEntity.setRukouyanqiyali_2(rukouyanqiyali_2);
        workingDataEntity.setChukouyanqiyali_2(chukouyanqiyali_2);
        workingDataEntity.setRukouyanqifenchendu_2(rukouyanqifenchendu_2);
        workingDataEntity.setChukouyanqifenchendu_2(chukouyanqifenchendu_2);
        workingDataEntity.setNo1xunhuanbengkaiguanzhuangtai_2(no1xunhuanbengkaiguanzhuangtai_2);
        workingDataEntity.setNo2xunhuanbengkaiguanzhuangtai_2(no2xunhuanbengkaiguanzhuangtai_2);
        workingDataEntity.setNo3xunhuanbengkaiguanzhuangtai_2(no3xunhuanbengkaiguanzhuangtai_2);
        workingDataEntity.setNo4xunhuanbengkaiguanzhuangtai_2(no4xunhuanbengkaiguanzhuangtai_2);
        workingDataEntity.setNo1yanghuafengjikaiguanzhuangtai_2(no1yanghuafengjikaiguanzhuangtai_2);
        workingDataEntity.setNo2yanghuafengjikaiguanzhuangtai_2(no2yanghuafengjikaiguanzhuangtai_2);
        workingDataEntity.setShihuishijiangyemidu_2(shihuishijiangyemidu_2);
        workingDataEntity.setGuolufuhe_2(guolufuhe_2);
        workingDataEntity.setNo1xunhuanbengdianliu_2(no1xunhuanbengdianliu_2);
        workingDataEntity.setNo2xunhuanbengdianliu_2(no2xunhuanbengdianliu_2);
        workingDataEntity.setNo3xunhuanbengdianliu_2(no3xunhuanbengdianliu_2);
        workingDataEntity.setNo4xunhuanbengdianliu_2(no4xunhuanbengdianliu_2);
        workingDataEntity.setNo1yanghuafengjidianliu_2(no1yanghuafengjidianliu_2);
        workingDataEntity.setNo2yanghuafengjidianliu_2(no2yanghuafengjidianliu_2);
        workingDataEntity.setInsert_time(TimeUtil.getCurrentDateTimeSplitByHyphenAndColon());

        return workingDataEntity;

    }

}

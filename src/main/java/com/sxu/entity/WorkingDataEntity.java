package com.huanxin.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDataEntity {

    String qiyeID;//企业ID    3-6
    String paikoubianhao;//排口编号 8
    String nianyueri;//年月日  9-16

    String jizubianhao_1;//机组编号   17
    String shifenmiao_1;//时分秒 18-25

    String guolubianhao_1_a;//锅炉编号  29
    String gongyileixingTX_1_a;//工艺类型脱硝TX   30-31
    String zhilisheshibianhao_1_a;//治理设施编号1 32

    Float SCRfanyingqichukouyanqiO2nongdu_1_a;//SCR反应器出口烟气O2浓度
    Float SCRfanyingqichukouyanqiNOXnongdu_1_a;//SCR反应器出口烟气NOX浓度
    Float SCRfanyingqichukouyanqiwendu_1_a;//SCR反应器出口烟气温度
    Float SCRfanyingqichukouyanqiNH3nongdu_1_a;//SCR反应器出口烟气NH3浓度
    Float jizuguolufuhe_1_a;//机组锅炉负荷
    Float SCRfanyingqiXAIGqianyandaoliuliang_1_a;//SCR反应器XAIG前烟道流量
    Float SCRfanyingqiXAIGqianyandaoO2nongdu_1_a;//SCR反应器XAIG前烟道O2浓度
    Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a;//SCR反应器XAIG前烟道烟气NOX浓度
    Float SCRfanyingqiXjinkouyanqiwendu1_1_a;//SCR反应器X进口烟气温度1
    Float anqiliuliang_1_a;//氨气流量；
    Float fanyingqiXyanqiyacha1_1_a;//反应器X烟气压差1
    Float fanyingqiXyanqiyacha2_1_a;//反应器X烟气压差2
    Float fanyingqiXyanqiyacha3_1_a;//反应器X烟气压差3

    String guolubianhao_1_b;//锅炉编号B
    String gongyileixingTX_1_b;//工艺类型脱硝TX
    String zhilisheshibianhao_1_b;//治理设施编号2

    Float SCRfanyingqichukouyanqiO2nongdu_1_b;//SCR反应器出口烟气O2浓度
    Float SCRfanyingqichukouyanqiNOXnongdu_1_b;//SCR反应器出口烟气NOX浓度
    Float SCRfanyingqichukouyanqiwendu_1_b;//SCR反应器出口烟气温度
    Float SCRfanyingqichukouyanqiNH3nongdu_1_b;//SCR反应器出口烟气NH3浓度
    Float jizuguolufuhe_1_b;//机组锅炉负荷
    Float SCRfanyingqiXAIGqianyandaoliuliang_1_b;//SCR反应器XAIG前烟道流量
    Float SCRfanyingqiXAIGqianyandaoO2nongdu_1_b;//SCR反应器XAIG前烟道O2浓度
    Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b;//SCR反应器XAIG前烟道烟气NOX浓度
    Float SCRfanyingqiXjinkouyanqiwendu1_1_b;//SCR反应器X进口烟气温度1
    Float anqiliuliang_1_b;//氨气流量；
    Float fanyingqiXyanqiyacha1_1_b;//反应器X烟气压差1
    Float fanyingqiXyanqiyacha2_1_b;//反应器X烟气压差2
    Float fanyingqiXyanqiyacha3_1_b;//反应器X烟气压差3

    String guolubianhao_1;//锅炉编号A
    String gongyileixingTS_1;//工艺类型脱硫TS
    String zhilisheshibianhao_1;//治理设施编号1

    Float rukouyanqiliang_1;//入口烟气量
    Float rukouliunongdu_1;//入口硫浓度
    Float rukouO2nongdu_1;//入口O2浓度
    Float rukouyanwen_1;//入口烟温
    Float rukouyanqishidu_1;//入口烟气湿度
    Float shihuishigongjiangliang_1;//石灰石供浆量
    Float shigaoyemidu_1;//石膏液密度
    Float PHzhi_1;//PH值
    Float chukouyanqiliang_1;//出口烟气量
    Float chukouliunongdu_1;//出口硫浓度
    Float chukouO2nongdu_1;//出口O2浓度
    Float chukouyanwen_1;//出口烟温
    Float chukouyanqishidu_1;//出口烟气湿度
    Float rukouyanqiyali_1;//入口烟气压力
    Float chukouyanqiyali_1;//出口烟气压力
    Float rukouyanqifenchendu_1;//入口烟气粉尘度
    Float chukouyanqifenchendu_1;//出口烟气粉尘度
    Integer no1xunhuanbengkaiguanzhuangtai_1;//1#循环泵开关状态
    Integer no2xunhuanbengkaiguanzhuangtai_1;//2#循环泵开关状态
    Integer no3xunhuanbengkaiguanzhuangtai_1;//3#循环泵开关状态
    Integer no4xunhuanbengkaiguanzhuangtai_1;//4#循环泵开关状态
    Integer no1yanghuafengjikaiguanzhuangtai_1;//1#氧化风机开关状态
    Integer no2yanghuafengjikaiguanzhuangtai_1;//2#氧化风机开关状态
    Float shihuishijiangyemidu_1;//X机组石灰石浆液密度
    Float guolufuhe_1;//锅炉负荷
    Float no1xunhuanbengdianliu_1;//1#循环泵电流
    Float no2xunhuanbengdianliu_1;//2#循环泵电流
    Float no3xunhuanbengdianliu_1;//3#循环泵电流
    Float no4xunhuanbengdianliu_1;//3#循环泵电流
    Float no1yanghuafengjidianliu_1;//1#氧化风机电流
    Float no2yanghuafengjidianliu_1;//2#氧化风机电流


    String jizubianhao_2;//机组编号   17
    String shifenmiao_2;//时分秒 18-25

    String guolubianhao_2_a;//锅炉编号  29
    String gongyileixingTX_2_a;//工艺类型脱硝TX   30-31
    String zhilisheshibianhao_2_a;//治理设施编号1 32

    Float SCRfanyingqichukouyanqiO2nongdu_2_a;//SCR反应器出口烟气O2浓度
    Float SCRfanyingqichukouyanqiNOXnongdu_2_a;//SCR反应器出口烟气NOX浓度
    Float SCRfanyingqichukouyanqiwendu_2_a;//SCR反应器出口烟气温度
    Float SCRfanyingqichukouyanqiNH3nongdu_2_a;//SCR反应器出口烟气NH3浓度
    Float jizuguolufuhe_2_a;//机组锅炉负荷
    Float SCRfanyingqiXAIGqianyandaoliuliang_2_a;//SCR反应器XAIG前烟道流量
    Float SCRfanyingqiXAIGqianyandaoO2nongdu_2_a;//SCR反应器XAIG前烟道O2浓度
    Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a;//SCR反应器XAIG前烟道烟气NOX浓度
    Float SCRfanyingqiXjinkouyanqiwendu1_2_a;//SCR反应器X进口烟气温度1
    Float anqiliuliang_2_a;//氨气流量；
    Float fanyingqiXyanqiyacha1_2_a;//反应器X烟气压差1
    Float fanyingqiXyanqiyacha2_2_a;//反应器X烟气压差2
    Float fanyingqiXyanqiyacha3_2_a;//反应器X烟气压差3

    String guolubianhao_2_b;//锅炉编号B
    String gongyileixingTX_2_b;//工艺类型脱硝TX
    String zhilisheshibianhao_2_b;//治理设施编号2

    Float SCRfanyingqichukouyanqiO2nongdu_2_b;//SCR反应器出口烟气O2浓度
    Float SCRfanyingqichukouyanqiNOXnongdu_2_b;//SCR反应器出口烟气NOX浓度
    Float SCRfanyingqichukouyanqiwendu_2_b;//SCR反应器出口烟气温度
    Float SCRfanyingqichukouyanqiNH3nongdu_2_b;//SCR反应器出口烟气NH3浓度
    Float jizuguolufuhe_2_b;//机组锅炉负荷
    Float SCRfanyingqiXAIGqianyandaoliuliang_2_b;//SCR反应器XAIG前烟道流量
    Float SCRfanyingqiXAIGqianyandaoO2nongdu_2_b;//SCR反应器XAIG前烟道O2浓度
    Float SCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b;//SCR反应器XAIG前烟道烟气NOX浓度
    Float SCRfanyingqiXjinkouyanqiwendu1_2_b;//SCR反应器X进口烟气温度1
    Float anqiliuliang_2_b;//氨气流量；
    Float fanyingqiXyanqiyacha1_2_b;//反应器X烟气压差1
    Float fanyingqiXyanqiyacha2_2_b;//反应器X烟气压差2
    Float fanyingqiXyanqiyacha3_2_b;//反应器X烟气压差3

    String guolubianhao_2;//锅炉编号A
    String gongyileixingTS_2;//工艺类型脱硝TS
    String zhilisheshibianhao_2;//治理设施编号1

    Float rukouyanqiliang_2;//入口烟气量
    Float rukouliunongdu_2;//入口硫浓度
    Float rukouO2nongdu_2;//入口O2浓度
    Float rukouyanwen_2;//入口烟温
    Float rukouyanqishidu_2;//入口烟气湿度
    Float shihuishigongjiangliang_2;//石灰石供浆量
    Float shigaoyemidu_2;//石膏液密度
    Float PHzhi_2;//PH值
    Float chukouyanqiliang_2;//出口烟气量
    Float chukouliunongdu_2;//出口硫浓度
    Float chukouO2nongdu_2;//出口O2浓度
    Float chukouyanwen_2;//出口烟温
    Float chukouyanqishidu_2;//出口烟气湿度
    Float rukouyanqiyali_2;//入口烟气压力
    Float chukouyanqiyali_2;//出口烟气压力
    Float rukouyanqifenchendu_2;//入口烟气粉尘度
    Float chukouyanqifenchendu_2;//出口烟气粉尘度
    Integer no1xunhuanbengkaiguanzhuangtai_2;//1#循环泵开关状态
    Integer no2xunhuanbengkaiguanzhuangtai_2;//2#循环泵开关状态
    Integer no3xunhuanbengkaiguanzhuangtai_2;//3#循环泵开关状态
    Integer no4xunhuanbengkaiguanzhuangtai_2;//4#循环泵开关状态
    Integer no1yanghuafengjikaiguanzhuangtai_2;//1#氧化风机开关状态
    Integer no2yanghuafengjikaiguanzhuangtai_2;//2#氧化风机开关状态
    Float shihuishijiangyemidu_2;//X机组石灰石浆液密度
    Float guolufuhe_2;//锅炉负荷
    Float no1xunhuanbengdianliu_2;//1#循环泵电流
    Float no2xunhuanbengdianliu_2;//2#循环泵电流
    Float no3xunhuanbengdianliu_2;//3#循环泵电流
    Float no4xunhuanbengdianliu_2;//3#循环泵电流
    Float no1yanghuafengjidianliu_2;//1#氧化风机电流
    Float no2yanghuafengjidianliu_2;//2#氧化风机电流

    String insert_time;//入库时间
}

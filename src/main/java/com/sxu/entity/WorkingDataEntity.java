package com.sxu.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDataEntity {
    String insertDateTime; //插入时间
    String dataDateTime;//数据时间
    Float inletGasVolume;//入口烟气量
    Float inletSulphurConcentration;//入口硫浓度
    Float inletO2Concentration;//入口O2浓度
    Float inletGasTemperature;//入口烟温
    Float inletGasHumidity;//入口烟气湿度
    Float pulpSupply;//供浆量
    Float limestoneSlurryDensity;//石灰石浆液密度
    Float ph;//PH值
    Float outletGasVolume;//出口烟气量
    Float outletSulphurConcentration;//出口硫浓度
    Float outletO2Concentration;//出口O2浓度
    Float outletGasTemperature;//出口烟温
    Float outletGasHumidity;//出口烟气湿度
    Float inletGasPressure;//入口烟气压力
    Float outletGasPressure;//出口烟气压力
    Float inletGasDustDegree;//入口烟气粉尘度
    Float outletGasDustDegree;//出口烟气粉尘度
    Float circulatingPump1WitchingState;//1#循环泵开关状态
    Float circulatingPump2WitchingState;//2#循环泵开关状态
    Float circulatingPump3WitchingState;//3#循环泵开关状态
    Float circulatingPump4WitchingState;//4#循环泵开关状态
    Float circulatingPump5WitchingState;//5#循环泵开关状态
    Float circulatingPump6WitchingState;//6#循环泵开关状态
    Float unit1ScrOutletaO2Concentration;//1机组SCR反应器A出口烟气O2浓度
    Float unit1ScrOutletaNoxConcentration;//1机组SCR反应器A出口烟气NOX浓度
    Float unit1ScrOutletaGasTemperature;//1机组SCR反应器A出口烟气温度
    Float unit1ScrOutletaNh3Concentration;//1机组SCR反应器A出口烟气NH3浓度
    Float unit1Nh3Flow;//1机组氨气流量
    Float unit1ScrAaigFlueFlow;//1机组SCR反应器AAIG前烟道流量
    Float unit1ScrAaigFlueO2Concentration;//1机组SCR反应器AAIG前烟道O2浓度
    Float unit1ScrAaigFlueNoxConcentration;//1机组SCR反应器AAIG前烟道烟气NOX浓度
    Float unit1ScrAaigFlueGasTemperature;//1机组SCR反应器AAIG前烟道烟气温度
    Float unit1GasPressureDifference1;//1机组烟气压差1
    Float unit1GasPressureDifference2;//1机组烟气压差2
    Float unit1GasPressureDifference3;//1机组烟气压差3
    Float unit2ScrOutletaO2Concentration;//2机组SCR反应器A出口烟气O2浓度
    Float unit2ScrOutletaNoxConcentration;//2机组SCR反应器A出口烟气NOX浓度
    Float unit2ScrOutletaGasTemperature;//2机组SCR反应器A出口烟气温度
    Float unit2ScrOutletaNh3Concentration;//2机组SCR反应器A出口烟气NH3浓度
    Float unit2Nh3Flow;//2机组氨气流量
    Float unit2ScrAaigFlueFlow;//2机组SCR反应器AAIG前烟道流量
    Float unit2ScrAaigFlueO2Concentration;//2机组SCR反应器AAIG前烟道O2浓度
    Float unit2ScrAaigFlueNoxConcentration;//2机组SCR反应器AAIG前烟道烟气NOX浓度
    Float unit2ScrAaigFlueGasTemperature;//2机组SCR反应器AAIG前烟道烟气温度
    Float unit2GasPressureDifference1;//2机组烟气压差1
    Float unit2GasPressureDifference2;//2机组烟气压差2
    Float unit2GasPressureDifference3;//2机组烟气压差3

}

package com.sxu.data;

import com.sxu.Utils.TimeUtils;
import com.sxu.entity.WorkingModel;

public class WorkingModelData {
    public static WorkingModel getFieldsFromStr(String str) {
        String insertDateTime = TimeUtils.getCurrentDateTime(); //插入时间
        String dataDateTime = str.substring(0, 16).replaceAll(":", "");//数据时间
        Float inletGasVolume = Float.valueOf(str.substring(16, 20));//入口烟气量
        Float inletSulphurConcentration = Float.valueOf(str.substring(20, 24));//入口硫浓度
        Float inletO2Concentration = Float.valueOf(str.substring(24, 28));//入口O2浓度
        Float inletGasTemperature = Float.valueOf(str.substring(28, 32));//入口烟温
        Float inletGasHumidity = Float.valueOf(str.substring(32, 36));//入口烟气湿度
        Float pulpSupply = Float.valueOf(str.substring(36, 40));//供浆量
        Float limestoneSlurryDensity = Float.valueOf(str.substring(40, 44));//石灰石浆液密度
        Float ph = Float.valueOf(str.substring(44, 48));//PH值
        Float outletGasVolume = Float.valueOf(str.substring(48, 52));//出口烟气量
        Float outletSulphurConcentration = Float.valueOf(str.substring(52, 56));//出口硫浓度
        Float outletO2Concentration = Float.valueOf(str.substring(56, 60));//出口O2浓度
        Float outletGasTemperature = Float.valueOf(str.substring(60, 64));//出口烟温
        Float outletGasHumidity = Float.valueOf(str.substring(64, 68));//出口烟气湿度
        Float inletGasPressure = Float.valueOf(str.substring(68, 72));//入口烟气压力
        Float outletGasPressure = Float.valueOf(str.substring(72, 76));//出口烟气压力
        Float inletGasDustDegree = Float.valueOf(str.substring(76, 80));//入口烟气粉尘度
        Float outletGasDustDegree = Float.valueOf(str.substring(80, 84));//出口烟气粉尘度
        Float circulatingPump1WitchingState = Float.valueOf(str.substring(84, 85));//1#循环泵开关状态
        Float circulatingPump2WitchingState = Float.valueOf(str.substring(85, 86));//2#循环泵开关状态
        Float circulatingPump3WitchingState = Float.valueOf(str.substring(86, 87));//3#循环泵开关状态
        Float circulatingPump4WitchingState = Float.valueOf(str.substring(87, 88));//4#循环泵开关状态
        Float circulatingPump5WitchingState = Float.valueOf(str.substring(88, 89));//5#循环泵开关状态
        Float circulatingPump6WitchingState = Float.valueOf(str.substring(89, 90));//6#循环泵开关状态
        Float unit1ScrOutletaO2Concentration = Float.valueOf(str.substring(90, 94));//1机组SCR反应器A出口烟气O2浓度
        Float unit1ScrOutletaNoxConcentration = Float.valueOf(str.substring(94, 98));//1机组SCR反应器A出口烟气NOX浓度
        Float unit1ScrOutletaGasTemperature = Float.valueOf(str.substring(98, 102));//1机组SCR反应器A出口烟气温度
        Float unit1ScrOutletaNh3Concentration = Float.valueOf(str.substring(102, 106));//1机组SCR反应器A出口烟气NH3浓度
        Float unit1Nh3Flow = Float.valueOf(str.substring(106, 110));//1机组氨气流量
        Float unit1ScrAaigFlueFlow = Float.valueOf(str.substring(110, 114));//1机组SCR反应器AAIG前烟道流量
        Float unit1ScrAaigFlueO2Concentration = Float.valueOf(str.substring(114, 118));//1机组SCR反应器AAIG前烟道O2浓度
        Float unit1ScrAaigFlueNoxConcentration = Float.valueOf(str.substring(118, 122));//1机组SCR反应器AAIG前烟道烟气NOX浓度
        Float unit1ScrAaigFlueGasTemperature = Float.valueOf(str.substring(122, 126));//1机组SCR反应器AAIG前烟道烟气温度
        Float unit1GasPressureDifference1 = Float.valueOf(str.substring(126, 130));//1机组烟气压差1
        Float unit1GasPressureDifference2 = Float.valueOf(str.substring(130, 134));//1机组烟气压差2
        Float unit1GasPressureDifference3 = Float.valueOf(str.substring(134, 138));//1机组烟气压差3
        Float unit2ScrOutletaO2Concentration = Float.valueOf(str.substring(138, 142));//2机组SCR反应器A出口烟气O2浓度
        Float unit2ScrOutletaNoxConcentration = Float.valueOf(str.substring(142, 146));//2机组SCR反应器A出口烟气NOX浓度
        Float unit2ScrOutletaGasTemperature = Float.valueOf(str.substring(146, 150));//2机组SCR反应器A出口烟气温度
        Float unit2ScrOutletaNh3Concentration = Float.valueOf(str.substring(150, 154));//2机组SCR反应器A出口烟气NH3浓度
        Float unit2Nh3Flow = Float.valueOf(str.substring(154, 158));//2机组氨气流量
        Float unit2ScrAaigFlueFlow = Float.valueOf(str.substring(158, 162));//2机组SCR反应器AAIG前烟道流量
        Float unit2ScrAaigFlueO2Concentration = Float.valueOf(str.substring(162, 166));//2机组SCR反应器AAIG前烟道O2浓度
        Float unit2ScrAaigFlueNoxConcentration = Float.valueOf(str.substring(166, 170));//2机组SCR反应器AAIG前烟道烟气NOX浓度
        Float unit2ScrAaigFlueGasTemperature = Float.valueOf(str.substring(170, 174));//2机组SCR反应器AAIG前烟道烟气温度
        Float unit2GasPressureDifference1 = Float.valueOf(str.substring(174, 178));//2机组烟气压差1
        Float unit2GasPressureDifference2 = Float.valueOf(str.substring(178, 182));//2机组烟气压差2
        Float unit2GasPressureDifference3 = Float.valueOf(str.substring(182, 186));//2机组烟气压差3
        WorkingModel workingModel = new WorkingModel(
                insertDateTime,
                dataDateTime,
                inletGasVolume,
                inletSulphurConcentration,
                inletO2Concentration,
                inletGasTemperature,
                inletGasHumidity,
                pulpSupply,
                limestoneSlurryDensity,
                ph,
                outletGasVolume,
                outletSulphurConcentration,
                outletO2Concentration,
                outletGasTemperature,
                outletGasHumidity,
                inletGasPressure,
                outletGasPressure,
                inletGasDustDegree,
                outletGasDustDegree,
                circulatingPump1WitchingState,
                circulatingPump2WitchingState,
                circulatingPump3WitchingState,
                circulatingPump4WitchingState,
                circulatingPump5WitchingState,
                circulatingPump6WitchingState,
                unit1ScrOutletaO2Concentration,
                unit1ScrOutletaNoxConcentration,
                unit1ScrOutletaGasTemperature,
                unit1ScrOutletaNh3Concentration,
                unit1Nh3Flow,
                unit1ScrAaigFlueFlow,
                unit1ScrAaigFlueO2Concentration,
                unit1ScrAaigFlueNoxConcentration,
                unit1ScrAaigFlueGasTemperature,
                unit1GasPressureDifference1,
                unit1GasPressureDifference2,
                unit1GasPressureDifference3,
                unit2ScrOutletaO2Concentration,
                unit2ScrOutletaNoxConcentration,
                unit2ScrOutletaGasTemperature,
                unit2ScrOutletaNh3Concentration,
                unit2Nh3Flow,
                unit2ScrAaigFlueFlow,
                unit2ScrAaigFlueO2Concentration,
                unit2ScrAaigFlueNoxConcentration,
                unit2ScrAaigFlueGasTemperature,
                unit2GasPressureDifference1,
                unit2GasPressureDifference2,
                unit2GasPressureDifference3);
        System.out.println("getFieldsFromStr:" + workingModel);
        return workingModel;
    }
}

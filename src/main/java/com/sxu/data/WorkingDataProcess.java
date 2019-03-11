package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.utils.Hex2Float;
import com.sxu.utils.TimeUtils;

public class WorkingDataProcess {
    public static void main(String[] args) {
        String value = "32";
        System.out.println((char)Integer.parseInt(value,16));
    }

    /**
     * 通过帧拿到工况数据，封装到workingDataEntity中
     * @param arrayHex
     * @return
     */
    public static WorkingDataEntity getWorkingDataEntityFromFrame(String[] arrayHex){
        WorkingDataEntity workingDataEntity = new WorkingDataEntity();
        //插入时间
        String insertDateTime = TimeUtils.getCurrentDateTime();
        //数据时间
        String dataDateTime = "";
        StringBuffer sb = new StringBuffer();
        for(int i=6;i<=22;i++){
            sb.append((char)Integer.parseInt(arrayHex[i],16));
        }
        dataDateTime = sb.toString().trim().replaceAll(":","").replaceAll("\r","").replaceAll("\n","").replaceAll(" ","");

        //入口烟气量
        Float inletGasVolume = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[27],16),
                Integer.parseInt(arrayHex[28],16),
                Integer.parseInt(arrayHex[29],16),
                Integer.parseInt(arrayHex[30],16)});
        //入口硫浓度
        Float inletSulphurConcentration = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[31],16),
                Integer.parseInt(arrayHex[32],16),
                Integer.parseInt(arrayHex[33],16),
                Integer.parseInt(arrayHex[34],16)});
        //入口O2浓度
        Float inletO2Concentration = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[35],16),
                Integer.parseInt(arrayHex[36],16),
                Integer.parseInt(arrayHex[37],16),
                Integer.parseInt(arrayHex[38],16)});
        //入口烟温
        Float inletGasTemperature = Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[39],16),
                Integer.parseInt(arrayHex[40],16),
                Integer.parseInt(arrayHex[41],16),
                Integer.parseInt(arrayHex[42],16)});
        //入口烟气湿度
        Float inletGasHumidity= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[43],16),
                Integer.parseInt(arrayHex[44],16),
                Integer.parseInt(arrayHex[45],16),
                Integer.parseInt(arrayHex[46],16)});
        //供浆量
        Float pulpSupply= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[47],16),
                Integer.parseInt(arrayHex[48],16),
                Integer.parseInt(arrayHex[49],16),
                Integer.parseInt(arrayHex[50],16)});;
        //石灰石浆液密度
        Float limestoneSlurryDensity= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[51],16),
                Integer.parseInt(arrayHex[52],16),
                Integer.parseInt(arrayHex[53],16),
                Integer.parseInt(arrayHex[54],16)});
        //PH值
        Float ph= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[55],16),
                Integer.parseInt(arrayHex[56],16),
                Integer.parseInt(arrayHex[57],16),
                Integer.parseInt(arrayHex[58],16)});
        //出口烟气量
        Float outletGasVolume= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[59],16),
                Integer.parseInt(arrayHex[60],16),
                Integer.parseInt(arrayHex[61],16),
                Integer.parseInt(arrayHex[62],16)});
        //出口硫浓度
        Float outletSulphurConcentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[63],16),
                Integer.parseInt(arrayHex[64],16),
                Integer.parseInt(arrayHex[65],16),
                Integer.parseInt(arrayHex[66],16)});
        //出口O2浓度
        Float outletO2Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[67],16),
                Integer.parseInt(arrayHex[68],16),
                Integer.parseInt(arrayHex[69],16),
                Integer.parseInt(arrayHex[70],16)});
        //出口烟温
        Float outletGasTemperature= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[71],16),
                Integer.parseInt(arrayHex[72],16),
                Integer.parseInt(arrayHex[73],16),
                Integer.parseInt(arrayHex[74],16)});
        //出口烟气湿度
        Float outletGasHumidity= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[75],16),
                Integer.parseInt(arrayHex[76],16),
                Integer.parseInt(arrayHex[77],16),
                Integer.parseInt(arrayHex[78],16)});
        //入口烟气压力
        Float inletGasPressure= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[79],16),
                Integer.parseInt(arrayHex[80],16),
                Integer.parseInt(arrayHex[81],16),
                Integer.parseInt(arrayHex[82],16)});
        //出口烟气压力
        Float outletGasPressure= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[83],16),
                Integer.parseInt(arrayHex[84],16),
                Integer.parseInt(arrayHex[85],16),
                Integer.parseInt(arrayHex[86],16)});
        //入口烟气粉尘度
        Float inletGasDustDegree= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[87],16),
                Integer.parseInt(arrayHex[88],16),
                Integer.parseInt(arrayHex[89],16),
                Integer.parseInt(arrayHex[90],16)});
        //出口烟气粉尘度
        Float outletGasDustDegree= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[91],16),
                Integer.parseInt(arrayHex[92],16),
                Integer.parseInt(arrayHex[93],16),
                Integer.parseInt(arrayHex[94],16)});
        //1#循环泵开关状态
        Float circulatingPump1WitchingState= (float)Integer.parseInt(arrayHex[95],16);
        //2#循环泵开关状态
        Float circulatingPump2WitchingState= (float)Integer.parseInt(arrayHex[96],16);
        //3#循环泵开关状态
        Float circulatingPump3WitchingState= (float)Integer.parseInt(arrayHex[97],16);
        //4#循环泵开关状态
        Float circulatingPump4WitchingState= (float)Integer.parseInt(arrayHex[98],16);
        //5#循环泵开关状态
        Float circulatingPump5WitchingState= (float)Integer.parseInt(arrayHex[99],16);
        //6#循环泵开关状态
        Float circulatingPump6WitchingState= (float)Integer.parseInt(arrayHex[100],16);
        //1机组SCR反应器A出口烟气O2浓度
        Float unit1ScrOutletaO2Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[101],16),
                Integer.parseInt(arrayHex[102],16),
                Integer.parseInt(arrayHex[103],16),
                Integer.parseInt(arrayHex[104],16)});
        //1机组SCR反应器A出口烟气NOX浓度
        Float unit1ScrOutletaNoxConcentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[105],16),
                Integer.parseInt(arrayHex[106],16),
                Integer.parseInt(arrayHex[107],16),
                Integer.parseInt(arrayHex[108],16)});
        //1机组SCR反应器A出口烟气温度
        Float unit1ScrOutletaGasTemperature= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[109],16),
                Integer.parseInt(arrayHex[110],16),
                Integer.parseInt(arrayHex[111],16),
                Integer.parseInt(arrayHex[112],16)});
        //1机组SCR反应器A出口烟气NH3浓度
        Float unit1ScrOutletaNh3Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[113],16),
                Integer.parseInt(arrayHex[114],16),
                Integer.parseInt(arrayHex[115],16),
                Integer.parseInt(arrayHex[116],16)});
        //1机组氨气流量
        Float unit1Nh3Flow= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[117],16),
                Integer.parseInt(arrayHex[118],16),
                Integer.parseInt(arrayHex[119],16),
                Integer.parseInt(arrayHex[120],16)});
        //1机组SCR反应器AAIG前烟道流量
        Float unit1ScrAaigFlueFlow= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[121],16),
                Integer.parseInt(arrayHex[122],16),
                Integer.parseInt(arrayHex[123],16),
                Integer.parseInt(arrayHex[124],16)});
        //1机组SCR反应器AAIG前烟道O2浓度
        Float unit1ScrAaigFlueO2Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[125],16),
                Integer.parseInt(arrayHex[126],16),
                Integer.parseInt(arrayHex[127],16),
                Integer.parseInt(arrayHex[128],16)});
        //1机组SCR反应器AAIG前烟道烟气NOX浓度
        Float unit1ScrAaigFlueNoxConcentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[129],16),
                Integer.parseInt(arrayHex[130],16),
                Integer.parseInt(arrayHex[131],16),
                Integer.parseInt(arrayHex[132],16)});
        //1机组SCR反应器AAIG前烟道烟气温度
        Float unit1ScrAaigFlueGasTemperature= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[133],16),
                Integer.parseInt(arrayHex[134],16),
                Integer.parseInt(arrayHex[135],16),
                Integer.parseInt(arrayHex[136],16)});
        //1机组烟气压差1
        Float unit1GasPressureDifference1= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[137],16),
                Integer.parseInt(arrayHex[138],16),
                Integer.parseInt(arrayHex[139],16),
                Integer.parseInt(arrayHex[140],16)});
        //1机组烟气压差2
        Float unit1GasPressureDifference2= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[141],16),
                Integer.parseInt(arrayHex[142],16),
                Integer.parseInt(arrayHex[143],16),
                Integer.parseInt(arrayHex[144],16)});
        //1机组烟气压差3
        Float unit1GasPressureDifference3= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[145],16),
                Integer.parseInt(arrayHex[146],16),
                Integer.parseInt(arrayHex[147],16),
                Integer.parseInt(arrayHex[148],16)});
        //2机组SCR反应器A出口烟气O2浓度
        Float unit2ScrOutletaO2Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[149],16),
                Integer.parseInt(arrayHex[150],16),
                Integer.parseInt(arrayHex[151],16),
                Integer.parseInt(arrayHex[152],16)});
        //2机组SCR反应器A出口烟气NOX浓度
        Float unit2ScrOutletaNoxConcentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[153],16),
                Integer.parseInt(arrayHex[154],16),
                Integer.parseInt(arrayHex[155],16),
                Integer.parseInt(arrayHex[156],16)});
        //2机组SCR反应器A出口烟气温度
        Float unit2ScrOutletaGasTemperature= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[157],16),
                Integer.parseInt(arrayHex[158],16),
                Integer.parseInt(arrayHex[159],16),
                Integer.parseInt(arrayHex[160],16)});
        //2机组SCR反应器A出口烟气NH3浓度
        Float unit2ScrOutletaNh3Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[161],16),
                Integer.parseInt(arrayHex[162],16),
                Integer.parseInt(arrayHex[163],16),
                Integer.parseInt(arrayHex[164],16)});
        //2机组氨气流量
        Float unit2Nh3Flow= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[165],16),
                Integer.parseInt(arrayHex[166],16),
                Integer.parseInt(arrayHex[167],16),
                Integer.parseInt(arrayHex[168],16)});
        //2机组SCR反应器AAIG前烟道流量
        Float unit2ScrAaigFlueFlow= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[169],16),
                Integer.parseInt(arrayHex[170],16),
                Integer.parseInt(arrayHex[171],16),
                Integer.parseInt(arrayHex[172],16)});
        //2机组SCR反应器AAIG前烟道O2浓度
        Float unit2ScrAaigFlueO2Concentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[173],16),
                Integer.parseInt(arrayHex[174],16),
                Integer.parseInt(arrayHex[175],16),
                Integer.parseInt(arrayHex[176],16)});
        //2机组SCR反应器AAIG前烟道烟气NOX浓度
        Float unit2ScrAaigFlueNoxConcentration= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[177],16),
                Integer.parseInt(arrayHex[178],16),
                Integer.parseInt(arrayHex[179],16),
                Integer.parseInt(arrayHex[180],16)});
        //2机组SCR反应器AAIG前烟道烟气温度
        Float unit2ScrAaigFlueGasTemperature= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[181],16),
                Integer.parseInt(arrayHex[182],16),
                Integer.parseInt(arrayHex[183],16),
                Integer.parseInt(arrayHex[184],16)});
        //2机组烟气压差1
        Float unit2GasPressureDifference1= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[185],16),
                Integer.parseInt(arrayHex[186],16),
                Integer.parseInt(arrayHex[187],16),
                Integer.parseInt(arrayHex[188],16)});
        //2机组烟气压差2
        Float unit2GasPressureDifference2= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[189],16),
                Integer.parseInt(arrayHex[190],16),
                Integer.parseInt(arrayHex[191],16),
                Integer.parseInt(arrayHex[192],16)});
        //2机组烟气压差3
        Float unit2GasPressureDifference3= Hex2Float.hexToFloat(new int[]{
                Integer.parseInt(arrayHex[193],16),
                Integer.parseInt(arrayHex[194],16),
                Integer.parseInt(arrayHex[195],16),
                Integer.parseInt(arrayHex[196],16)});

        workingDataEntity.setInsertDateTime(insertDateTime); //插入时间
        workingDataEntity.setDataDateTime(dataDateTime);//数据时间
        workingDataEntity.setInletGasVolume(inletGasVolume);//入口烟气量
        workingDataEntity.setInletSulphurConcentration(inletSulphurConcentration);//入口硫浓度
        workingDataEntity.setInletO2Concentration(inletO2Concentration);//入口O2浓度
        workingDataEntity.setInletGasTemperature(inletGasTemperature);//入口烟温
        workingDataEntity.setInletGasHumidity(inletGasHumidity);//入口烟气湿度
        workingDataEntity.setPulpSupply(pulpSupply);//供浆量
        workingDataEntity.setLimestoneSlurryDensity(limestoneSlurryDensity);//石灰石浆液密度
        workingDataEntity.setPh(ph);//PH值
        workingDataEntity.setOutletGasVolume(outletGasVolume);//出口烟气量
        workingDataEntity.setOutletSulphurConcentration(outletSulphurConcentration);//出口硫浓度
        workingDataEntity.setOutletO2Concentration(outletO2Concentration);//出口O2浓度
        workingDataEntity.setOutletGasTemperature(outletGasTemperature);//出口烟温
        workingDataEntity.setOutletGasHumidity(outletGasHumidity);//出口烟气湿度
        workingDataEntity.setInletGasPressure(inletGasPressure);//入口烟气压力
        workingDataEntity.setOutletGasPressure(outletGasPressure);//出口烟气压力
        workingDataEntity.setInletGasDustDegree(inletGasDustDegree);//入口烟气粉尘度
        workingDataEntity.setOutletGasDustDegree(outletGasDustDegree);
        workingDataEntity.setCirculatingPump1WitchingState(circulatingPump1WitchingState);
        workingDataEntity.setCirculatingPump2WitchingState(circulatingPump2WitchingState);
        workingDataEntity.setCirculatingPump3WitchingState(circulatingPump3WitchingState);
        workingDataEntity.setCirculatingPump4WitchingState(circulatingPump4WitchingState);
        workingDataEntity.setCirculatingPump5WitchingState(circulatingPump5WitchingState);
        workingDataEntity.setCirculatingPump6WitchingState(circulatingPump6WitchingState);
        workingDataEntity.setUnit1ScrOutletaO2Concentration(unit1ScrOutletaO2Concentration);
        workingDataEntity.setUnit1ScrOutletaNoxConcentration(unit1ScrOutletaNoxConcentration);
        workingDataEntity.setUnit1ScrOutletaGasTemperature(unit1ScrOutletaGasTemperature);
        workingDataEntity.setUnit1ScrOutletaNh3Concentration(unit1ScrOutletaNh3Concentration);
        workingDataEntity.setUnit1Nh3Flow(unit1Nh3Flow);
        workingDataEntity.setUnit1ScrAaigFlueFlow(unit1ScrAaigFlueFlow);
        workingDataEntity.setUnit1ScrAaigFlueO2Concentration(unit1ScrAaigFlueO2Concentration);//1机组SCR反应器AAIG前烟道O2浓度
        workingDataEntity.setUnit1ScrAaigFlueNoxConcentration(unit1ScrAaigFlueNoxConcentration);//1机组SCR反应器AAIG前烟道烟气NOX浓度
        workingDataEntity.setUnit1ScrAaigFlueGasTemperature(unit1ScrAaigFlueGasTemperature);//1机组SCR反应器AAIG前烟道烟气温度
        workingDataEntity.setUnit1GasPressureDifference1(unit1GasPressureDifference1);//1机组烟气压差1
        workingDataEntity.setUnit1GasPressureDifference2(unit1GasPressureDifference2);//1机组烟气压差2
        workingDataEntity.setUnit1GasPressureDifference3(unit1GasPressureDifference3);//1机组烟气压差3
        workingDataEntity.setUnit2ScrOutletaO2Concentration(unit2ScrOutletaO2Concentration);//2机组SCR反应器A出口烟气O2浓度
        workingDataEntity.setUnit2ScrOutletaNoxConcentration(unit2ScrOutletaNoxConcentration);//2机组SCR反应器A出口烟气NOX浓度
        workingDataEntity.setUnit2ScrOutletaGasTemperature(unit2ScrOutletaGasTemperature);//2机组SCR反应器A出口烟气温度
        workingDataEntity.setUnit2ScrOutletaNh3Concentration(unit2ScrOutletaNh3Concentration);//2机组SCR反应器A出口烟气NH3浓度
        workingDataEntity.setUnit2Nh3Flow(unit2Nh3Flow);//2机组氨气流量
        workingDataEntity.setUnit2ScrAaigFlueFlow(unit2ScrAaigFlueFlow);//2机组SCR反应器AAIG前烟道流量
        workingDataEntity.setUnit2ScrAaigFlueO2Concentration(unit2ScrAaigFlueO2Concentration);//2机组SCR反应器AAIG前烟道O2浓度
        workingDataEntity.setUnit2ScrAaigFlueNoxConcentration(unit2ScrAaigFlueNoxConcentration);//2机组SCR反应器AAIG前烟道烟气NOX浓度
        workingDataEntity.setUnit2ScrAaigFlueGasTemperature(unit2ScrAaigFlueGasTemperature);//2机组SCR反应器AAIG前烟道烟气温度
        workingDataEntity.setUnit2GasPressureDifference1(unit2GasPressureDifference1);//2机组烟气压差1
        workingDataEntity.setUnit2GasPressureDifference2(unit2GasPressureDifference2);//2机组烟气压差2
        workingDataEntity.setUnit2GasPressureDifference3(unit2GasPressureDifference3);//2机组烟气压差3

        return workingDataEntity;
    }
}

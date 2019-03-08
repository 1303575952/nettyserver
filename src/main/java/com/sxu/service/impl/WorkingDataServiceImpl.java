package com.sxu.service.impl;

import com.sxu.config.JDBCConfiguration;
import com.sxu.entity.WorkingDataEntity;
import com.sxu.service.WorkingDataService;
import com.sxu.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkingDataServiceImpl implements WorkingDataService {

    public void insertWorkingData(WorkingDataEntity workingDataEntity) throws Exception {
        Connection connection = JDBCConfiguration.getConn();
        PreparedStatement insertworkingDataEntity = connection.prepareStatement(
                "insert into working_data (" +
                        "insert_date_time,\n" +
                        "data_date_time,\n" +
                        "inlet_gas_volume,\n" +
                        "inlet_sulphur_concentration,\n" +
                        "inlet_o2_concentration,\n" +
                        "inlet_gas_temperature,\n" +
                        "inlet_gas_humidity,\n" +
                        "pulp_supply,\n" +
                        "limestone_slurry_density,\n" +
                        "ph,\n" +
                        "outlet_gas_volume,\n" +
                        "outlet_sulphur_concentration,\n" +
                        "outlet_o2_concentration,\n" +
                        "outlet_gas_temperature,\n" +
                        "outlet_gas_humidity,\n" +
                        "inlet_gas_pressure,\n" +
                        "outlet_gas_pressure,\n" +
                        "inlet_gas_dust_degree,\n" +
                        "outlet_gas_dust_degree,\n" +
                        "circulating_pump1_witching_state,\n" +
                        "circulating_pump2_witching_state,\n" +
                        "circulating_pump3_witching_state,\n" +
                        "circulating_pump4_witching_state,\n" +
                        "circulating_pump5_witching_state,\n" +
                        "circulating_pump6_witching_state,\n" +
                        "unit1_scr_outleta_o2_concentration,\n" +
                        "unit1_scr_outleta_nox_concentration,\n" +
                        "unit1_scr_outleta_gas_temperature,\n" +
                        "unit1_scr_outleta_nh3_concentration,\n" +
                        "unit1_nh3_flow,\n" +
                        "unit1_scr_aaig_flue_flow,\n" +
                        "unit1_scr_aaig_flue_o2_concentration,\n" +
                        "unit1_scr_aaig_flue_nox_concentration,\n" +
                        "unit1_scr_aaig_flue_gas_temperature,\n" +
                        "unit1_gas_pressure_difference1,\n" +
                        "unit1_gas_pressure_difference2,\n" +
                        "unit1_gas_pressure_difference3,\n" +
                        "unit2_scr_outleta_o2_concentration,\n" +
                        "unit2_scr_outleta_nox_concentration,\n" +
                        "unit2_scr_outleta_gas_temperature,\n" +
                        "unit2_scr_outleta_nh3_concentration,\n" +
                        "unit2_nh3_flow,\n" +
                        "unit2_scr_aaig_flue_flow,\n" +
                        "unit2_scr_aaig_flue_o2_concentration,\n" +
                        "unit2_scr_aaig_flue_nox_concentration,\n" +
                        "unit2_scr_aaig_flue_gas_temperature,\n" +
                        "unit2_gas_pressure_difference1,\n" +
                        "unit2_gas_pressure_difference2,\n" +
                        "unit2_gas_pressure_difference3" +
                        ") " +
                        "values (?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?)");
        insertworkingDataEntity.setString(1, TimeUtils.getCurrentDateTime());
        insertworkingDataEntity.setString(2, workingDataEntity.getDataDateTime());
        insertworkingDataEntity.setFloat(3, workingDataEntity.getInletGasVolume());
        insertworkingDataEntity.setFloat(4, workingDataEntity.getInletSulphurConcentration());
        insertworkingDataEntity.setFloat(5, workingDataEntity.getInletO2Concentration());
        insertworkingDataEntity.setFloat(6, workingDataEntity.getInletGasTemperature());
        insertworkingDataEntity.setFloat(7, workingDataEntity.getInletGasHumidity());
        insertworkingDataEntity.setFloat(8, workingDataEntity.getPulpSupply());
        insertworkingDataEntity.setFloat(9, workingDataEntity.getLimestoneSlurryDensity());
        insertworkingDataEntity.setFloat(10, workingDataEntity.getPh());
        insertworkingDataEntity.setFloat(11, workingDataEntity.getOutletGasVolume());
        insertworkingDataEntity.setFloat(12, workingDataEntity.getOutletSulphurConcentration());
        insertworkingDataEntity.setFloat(13, workingDataEntity.getOutletO2Concentration());
        insertworkingDataEntity.setFloat(14, workingDataEntity.getOutletGasTemperature());
        insertworkingDataEntity.setFloat(15, workingDataEntity.getOutletGasHumidity());
        insertworkingDataEntity.setFloat(16, workingDataEntity.getInletGasPressure());
        insertworkingDataEntity.setFloat(17, workingDataEntity.getOutletGasPressure());
        insertworkingDataEntity.setFloat(18, workingDataEntity.getInletGasDustDegree());
        insertworkingDataEntity.setFloat(19, workingDataEntity.getOutletGasDustDegree());
        insertworkingDataEntity.setFloat(20, workingDataEntity.getCirculatingPump1WitchingState());
        insertworkingDataEntity.setFloat(21, workingDataEntity.getCirculatingPump2WitchingState());
        insertworkingDataEntity.setFloat(22, workingDataEntity.getCirculatingPump3WitchingState());
        insertworkingDataEntity.setFloat(23, workingDataEntity.getCirculatingPump4WitchingState());
        insertworkingDataEntity.setFloat(24, workingDataEntity.getCirculatingPump5WitchingState());
        insertworkingDataEntity.setFloat(25, workingDataEntity.getCirculatingPump6WitchingState());
        insertworkingDataEntity.setFloat(26, workingDataEntity.getUnit1ScrOutletaO2Concentration());
        insertworkingDataEntity.setFloat(27, workingDataEntity.getUnit1ScrOutletaNoxConcentration());
        insertworkingDataEntity.setFloat(28, workingDataEntity.getUnit1ScrOutletaGasTemperature());
        insertworkingDataEntity.setFloat(29, workingDataEntity.getUnit1ScrOutletaNh3Concentration());
        insertworkingDataEntity.setFloat(30, workingDataEntity.getUnit1Nh3Flow());
        insertworkingDataEntity.setFloat(31, workingDataEntity.getUnit1ScrAaigFlueFlow());
        insertworkingDataEntity.setFloat(32, workingDataEntity.getUnit1ScrAaigFlueO2Concentration());
        insertworkingDataEntity.setFloat(33, workingDataEntity.getUnit1ScrAaigFlueNoxConcentration());
        insertworkingDataEntity.setFloat(34, workingDataEntity.getUnit1ScrAaigFlueGasTemperature());
        insertworkingDataEntity.setFloat(35, workingDataEntity.getUnit1GasPressureDifference1());
        insertworkingDataEntity.setFloat(36, workingDataEntity.getUnit1GasPressureDifference2());
        insertworkingDataEntity.setFloat(37, workingDataEntity.getUnit1GasPressureDifference3());
        insertworkingDataEntity.setFloat(38, workingDataEntity.getUnit2ScrOutletaO2Concentration());
        insertworkingDataEntity.setFloat(39, workingDataEntity.getUnit2ScrOutletaNoxConcentration());
        insertworkingDataEntity.setFloat(40, workingDataEntity.getUnit2ScrOutletaGasTemperature());
        insertworkingDataEntity.setFloat(41, workingDataEntity.getUnit2ScrOutletaNh3Concentration());
        insertworkingDataEntity.setFloat(42, workingDataEntity.getUnit2Nh3Flow());
        insertworkingDataEntity.setFloat(43, workingDataEntity.getUnit2ScrAaigFlueFlow());
        insertworkingDataEntity.setFloat(44, workingDataEntity.getUnit2ScrAaigFlueO2Concentration());
        insertworkingDataEntity.setFloat(45, workingDataEntity.getUnit2ScrAaigFlueNoxConcentration());
        insertworkingDataEntity.setFloat(46, workingDataEntity.getUnit2ScrAaigFlueGasTemperature());
        insertworkingDataEntity.setFloat(47, workingDataEntity.getUnit2GasPressureDifference1());
        insertworkingDataEntity.setFloat(48, workingDataEntity.getUnit2GasPressureDifference2());
        insertworkingDataEntity.setFloat(49, workingDataEntity.getUnit2GasPressureDifference3());
        System.out.println(insertworkingDataEntity);
        insertworkingDataEntity.executeUpdate();
        insertworkingDataEntity.close();
        connection.close();
        System.out.println("连接关闭");
    }
}

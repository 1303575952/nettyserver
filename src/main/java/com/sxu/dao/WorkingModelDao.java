package com.sxu.dao;

import com.sxu.Utils.TimeUtils;
import com.sxu.config.JDBCConfiguration;
import com.sxu.entity.WorkingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkingModelDao {
    public static void insertWorkingModel(WorkingModel workingModel) throws Exception {
        Connection connection = JDBCConfiguration.getConn();
        PreparedStatement insertWorkingModel = connection.prepareStatement(
                "insert into working_model_data (" +
                        "insert_data_time,\n" +
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
        insertWorkingModel.setString(1, TimeUtils.getCurrentDateTime());
        insertWorkingModel.setString(2, workingModel.getDataDateTime());
        insertWorkingModel.setFloat(3, workingModel.getInletGasVolume());
        insertWorkingModel.setFloat(4, workingModel.getInletSulphurConcentration());
        insertWorkingModel.setFloat(5, workingModel.getInletO2Concentration());
        insertWorkingModel.setFloat(6, workingModel.getInletGasTemperature());
        insertWorkingModel.setFloat(7, workingModel.getInletGasHumidity());
        insertWorkingModel.setFloat(8, workingModel.getPulpSupply());
        insertWorkingModel.setFloat(9, workingModel.getLimestoneSlurryDensity());
        insertWorkingModel.setFloat(10, workingModel.getPh());
        insertWorkingModel.setFloat(11, workingModel.getOutletGasVolume());
        insertWorkingModel.setFloat(12, workingModel.getOutletSulphurConcentration());
        insertWorkingModel.setFloat(13, workingModel.getOutletO2Concentration());
        insertWorkingModel.setFloat(14, workingModel.getOutletGasTemperature());
        insertWorkingModel.setFloat(15, workingModel.getOutletGasHumidity());
        insertWorkingModel.setFloat(16, workingModel.getInletGasPressure());
        insertWorkingModel.setFloat(17, workingModel.getOutletGasPressure());
        insertWorkingModel.setFloat(18, workingModel.getInletGasDustDegree());
        insertWorkingModel.setFloat(19, workingModel.getOutletGasDustDegree());
        insertWorkingModel.setFloat(20, workingModel.getCirculatingPump1WitchingState());
        insertWorkingModel.setFloat(21, workingModel.getCirculatingPump2WitchingState());
        insertWorkingModel.setFloat(22, workingModel.getCirculatingPump3WitchingState());
        insertWorkingModel.setFloat(23, workingModel.getCirculatingPump4WitchingState());
        insertWorkingModel.setFloat(24, workingModel.getCirculatingPump5WitchingState());
        insertWorkingModel.setFloat(25, workingModel.getCirculatingPump6WitchingState());
        insertWorkingModel.setFloat(26, workingModel.getUnit1ScrOutletaO2Concentration());
        insertWorkingModel.setFloat(27, workingModel.getUnit1ScrOutletaNoxConcentration());
        insertWorkingModel.setFloat(28, workingModel.getUnit1ScrOutletaGasTemperature());
        insertWorkingModel.setFloat(29, workingModel.getUnit1ScrOutletaNh3Concentration());
        insertWorkingModel.setFloat(30, workingModel.getUnit1Nh3Flow());
        insertWorkingModel.setFloat(31, workingModel.getUnit1ScrAaigFlueFlow());
        insertWorkingModel.setFloat(32, workingModel.getUnit1ScrAaigFlueO2Concentration());
        insertWorkingModel.setFloat(33, workingModel.getUnit1ScrAaigFlueNoxConcentration());
        insertWorkingModel.setFloat(34, workingModel.getUnit1ScrAaigFlueGasTemperature());
        insertWorkingModel.setFloat(35, workingModel.getUnit1GasPressureDifference1());
        insertWorkingModel.setFloat(36, workingModel.getUnit1GasPressureDifference2());
        insertWorkingModel.setFloat(37, workingModel.getUnit1GasPressureDifference3());
        insertWorkingModel.setFloat(38, workingModel.getUnit2ScrOutletaO2Concentration());
        insertWorkingModel.setFloat(39, workingModel.getUnit2ScrOutletaNoxConcentration());
        insertWorkingModel.setFloat(40, workingModel.getUnit2ScrOutletaGasTemperature());
        insertWorkingModel.setFloat(41, workingModel.getUnit2ScrOutletaNh3Concentration());
        insertWorkingModel.setFloat(42, workingModel.getUnit2Nh3Flow());
        insertWorkingModel.setFloat(43, workingModel.getUnit2ScrAaigFlueFlow());
        insertWorkingModel.setFloat(44, workingModel.getUnit2ScrAaigFlueO2Concentration());
        insertWorkingModel.setFloat(45, workingModel.getUnit2ScrAaigFlueNoxConcentration());
        insertWorkingModel.setFloat(46, workingModel.getUnit2ScrAaigFlueGasTemperature());
        insertWorkingModel.setFloat(47, workingModel.getUnit2GasPressureDifference1());
        insertWorkingModel.setFloat(48, workingModel.getUnit2GasPressureDifference2());
        insertWorkingModel.setFloat(49, workingModel.getUnit2GasPressureDifference3());
        System.out.println(insertWorkingModel);
        insertWorkingModel.executeUpdate();
        insertWorkingModel.close();
        connection.close();
        System.out.println("连接关闭");
    }
}

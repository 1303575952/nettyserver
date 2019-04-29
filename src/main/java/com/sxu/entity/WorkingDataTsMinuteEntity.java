package com.huanxin.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDataTsMinuteEntity {
    String publishTime;
    Integer industryId;
    String industryName;
    Integer companyId;
    String companyName;
    Integer drainId;
    String drainName;
    Integer facilityId;
    String facilityName;
    Float operationConcentration;
    Float operatingEfficiency;
    Float calciumSulfurRatio;
    Float liquidGasRatio;
    Float pulpSupply;
    Float ph;
    Integer circulating_pump1_witching_state;
    Integer circulating_pump2_witching_state;
    Integer circulating_pump3_witching_state;
    Integer circulating_pump4_witching_state;
    Float exportSmokeDust;
    Float inletGasVolume;
    Float emissions;
    String createTime;
}

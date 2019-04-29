package com.huanxin.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDataTxMinuteEntity {
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
    Float nh3Flow;
    Float outNh3;
    Float outNo2;
    Float inNo2;
    Float aigFlueFlow;
    Float emission;
    String createTime;
}

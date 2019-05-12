package com.sxu.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDataTxTsEntity {
    String publishTime;
    String publishType;
    Integer regionId;
    Integer industryId;
    String industryName;
    Integer companyId;
    String companyName;
    Integer drainId;
    String drainName;
    Integer facilityId;
    String facilityNumber;
    String facilityName;
    Float operationConcentration;
    Float operatingEfficiency;
    String createTime;
}

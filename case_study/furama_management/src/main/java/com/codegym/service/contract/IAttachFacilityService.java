package com.codegym.service.contract;

import com.codegym.dto.contract.IAttachFacilityDto;
import com.codegym.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    List<AttachFacility> findByContractId(int id);

    List<IAttachFacilityDto> findByContractIdNew(int id);

    AttachFacility findById(int id);
}

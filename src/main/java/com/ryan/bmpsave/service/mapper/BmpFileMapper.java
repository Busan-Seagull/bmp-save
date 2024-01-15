package com.ryan.bmpsave.service.mapper;

import com.ryan.bmpsave.domain.BmpFile;
import com.ryan.bmpsave.service.dto.BmpFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.w3c.dom.Entity;

//unmappedTargetPolicy : 모든 Dto의 필드와 엔티티의 필드가 매핑될경우 사용하지 않아도 된다. 매핑 되지 않는 필드가 있을시 warning 표출 되는데 이를 무시하기 위함이다.
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BmpFileMapper extends EntityMapper<BmpFileDto, BmpFile> {
}

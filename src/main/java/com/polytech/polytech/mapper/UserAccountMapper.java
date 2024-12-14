package com.polytech.polytech.mapper;

import com.polytech.polytech.DTO.UserAccountDTO;
import com.polytech.polytech.entity.UserAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    UserAccount toEntity(UserAccountDTO userAccountDTO);

    UserAccountDTO toDTO(UserAccount userAccount);
}

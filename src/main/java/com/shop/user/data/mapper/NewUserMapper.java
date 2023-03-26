package com.shop.user.data.mapper;

import com.shop.user.data.dto.NewUser;
import com.shop.user.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NewUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isFrozen", ignore = true)
    User mapToUser(NewUser newUser);

}

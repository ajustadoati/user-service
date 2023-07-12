package com.ajustadoati.user.application.mapper;

import com.ajustadoati.user.application.request.dto.LocationDto;
import com.ajustadoati.user.application.request.dto.UserDto;
import com.ajustadoati.user.domain.Location;
import com.ajustadoati.user.domain.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toDto(User user);

    List<UserDto> toUserDtoList(List<User> users);

    List<Location> toListLocations(List<LocationDto> locationsDto);

    List<LocationDto> toListLocationsDto(List<Location> locations);

    Location toLocation(LocationDto locationDto);

    LocationDto toLocation(Location location);

}

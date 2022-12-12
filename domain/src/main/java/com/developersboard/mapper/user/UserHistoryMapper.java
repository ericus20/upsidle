package com.developersboard.mapper.user;

import com.developersboard.dto.user.UserHistoryDto;
import com.developersboard.entity.user.UserHistory;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * The UserDtoMapper class outlines the supported conversions between User and other objects.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserHistoryMapper {

  UserHistoryMapper MAPPER = Mappers.getMapper(UserHistoryMapper.class);

  /**
   * Convert and populate a userHistories to userHistoryDto object.
   *
   * @param userHistories the userHistories
   * @return the userHistoryDto
   */
  List<UserHistoryDto> toUserHistoryDto(Set<UserHistory> userHistories);

  /**
   * Convert and populate a userHistory to userHistoryDto object.
   *
   * @param userHistory the userHistory
   * @return the userHistoryDto
   */
  UserHistoryDto toUserHistoryDto(UserHistory userHistory);
}

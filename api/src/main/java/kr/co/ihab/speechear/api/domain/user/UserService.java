package kr.co.ihab.speechear.api.domain.user;

import kr.co.ihab.speechear.api.component.SecurityConfiguration;
import kr.co.ihab.speechear.api.component.exception.RestApiException;
import kr.co.ihab.speechear.api.domain.auth.UserInfoDetail;
import kr.co.ihab.speechear.api.enums.CommonErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.stereotype.Service;

import static kr.co.ihab.speechear.persistence.jooq.tables.UserInfo.USER_INFO;
import static org.jooq.impl.DSL.field;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final DSLContext dslContext;
    private final SecurityConfiguration configuration;

    public UserInfoResultDTO getUserInfo(UserInfoDetail userInfoDetail) {
        String userId = userInfoDetail.getUserInfo().getId();

        // TODO : make not native query
        Field<String> user_id = field("UI.id", String.class).as("user_id");
        Field<String> user_name = field("UI.name", String.class).as("user_name");
        Field<String> user_email = field("UI.email", String.class).as("user_email");
        Field<String> user_cellphone = field("UI.cellphone", String.class).as("user_cellphone");

        Field<String> manager_id = field("UM.id", String.class).as("manager_id");
        Field<String> manager_name = field("UM.name", String.class).as("manager_name");
        Field<String> manager_email = field("UM.email", String.class).as("manager_email");
        Field<String> manager_cellphone = field("UM.cellphone", String.class).as("manager_cellphone");

        Record record = dslContext
                .select(user_id, user_name, user_email, user_cellphone)
                .select(manager_id, manager_name, manager_email, manager_cellphone)
                .from("user_info as UI")
                    .join("user_assignment as UA")
                        .on("UI.id = UA.id")
                    .join("user_info as UM")
                        .on("UA.manager = UM.id")
                .where("UI.id = ?", userId)
                .fetchOne();

        if (record == null) {
            return null;
        }

        UserDTO dto = new UserDTO();

        dto.setId(record.get(user_id));
        dto.setName(record.get(user_name));
        dto.setEmail(record.get(user_email));
        dto.setCellPhone(record.get(user_cellphone));

        UserDTO mDto = new UserDTO();
        mDto.setId(record.get(manager_id));
        mDto.setName(record.get(manager_name));
        mDto.setEmail(record.get(manager_email));
        mDto.setCellPhone(record.get(manager_cellphone));

        UserInfoResultDTO resultDTO = new UserInfoResultDTO();
        resultDTO.setUser(dto);
        resultDTO.setManager(mDto);

        return resultDTO;
    }

    public Boolean updateUserInfo(UserInfoDetail userInfoDetail, UserInfoUpdateRequestDTO dto) {
        String userId = userInfoDetail.getUserInfo().getId();
        int result = dslContext.update(USER_INFO)
                .set(USER_INFO.NAME, dto.getName())
                .set(USER_INFO.EMAIL, dto.getEmail())
                .set(USER_INFO.CELLPHONE, dto.getCellPhone())
                .where(USER_INFO.ID.eq(userId))
                .execute();

        return result == 1;
    }

    public Boolean updateUserPassword(UserInfoDetail userInfoDetail, UserPassUpdateRequestDTO dto) {
        String userId = userInfoDetail.getUserInfo().getId();
        String password = userInfoDetail.getUserInfo().getPassword();

        if (!SecurityConfiguration.bCryptPasswordEncoder().matches(dto.getOriginPassword(), password)) {
            throw new RestApiException(CommonErrorCode.PASSWORD_NOT_MATCHED);
        }

        int result = dslContext.update(USER_INFO)
                .set(USER_INFO.PASSWORD, SecurityConfiguration.bCryptPasswordEncoder().encode(dto.getNewPassword()))
                .where(USER_INFO.ID.eq(userId))
                .execute();

        return result == 1;
    }
}

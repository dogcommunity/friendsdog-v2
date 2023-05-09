package company.friendsdog.dogcommunity.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    private int userNo;
    private String userId;
    private String userPassword;
    private String userNickname;
    private String userAdd;


}

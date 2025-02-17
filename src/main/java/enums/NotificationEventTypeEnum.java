package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationEventTypeEnum {

    WELCOME_EMAIL(1, "Welcome Email"),
    RESET_PASSWORD_EMAIL(2, "Reset Password Email"),
    PROFILE_APPROVED_EMAIL(3, "Profile Approved Email"),
    PROFILE_REJECTED_EMAIL(4, "Profile Rejected Email"),
    ACCOUNT_VERIFICATION_EMAIL(5, "Account Verification Email");

    private final int id;
    private final String description;

}

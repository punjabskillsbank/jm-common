package com.common.dto;

import com.common.enums.ProfileVisibility;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileVisibilityDTO {
    @NotNull(message = "freelancerId is required")
    private UUID freelancerId;

    @NotNull(message = "profileVisibility is required")
    private ProfileVisibility profileVisibility;
}

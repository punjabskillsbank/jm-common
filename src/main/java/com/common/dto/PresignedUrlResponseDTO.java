package com.common.dto;

import lombok.*;
import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PresignedUrlResponseDTO {
    private URL uploadUrl;
    private String s3Key;

}
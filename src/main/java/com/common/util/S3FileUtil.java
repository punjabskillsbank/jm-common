package com.common.util;

import com.common.dto.PresignedUrlResponseDTO;
import com.common.exceptionHandling.InvalidFileTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.*;

@Service
@RequiredArgsConstructor
public class S3FileUtil {

    private final S3PresignedURLUtil s3PresignedURLUtil;

    private static final Set<String> NOT_ALLOWED_EXTENSIONS = Set.of(
            ".exe", ".msi", ".bat", ".cmd", ".com", ".scr", ".pif", ".cpl", ".gadget",
            ".sh", ".bash", ".zsh", ".ps1", ".vbs", ".js", ".jse", ".wsf", ".wsh", ".reg",
            ".dll", ".so", ".dmg", ".pkg", ".jar", ".class",
            ".iso", ".img", ".vhd", ".vhdx",
            ".lnk", ".url",
            ".xlsm", ".docm", ".pptm"
    );

    public Map<String, PresignedUrlResponseDTO> generateMultipleJobAttachmentUrls(String entityId, Set<String> originalFilenames, String folderPrefix) {
        Map<String, PresignedUrlResponseDTO> urls = new HashMap<>();


        for (String fileName : originalFilenames) {
            String extension = getExtensionFromFileName(fileName).toLowerCase();

            //Validate extension
            if (NOT_ALLOWED_EXTENSIONS.contains(extension)) {
                throw new InvalidFileTypeException(extension);
            }

            String finalFileName = sanitizeFileName(fileName);  // Safe name
            String s3Key = folderPrefix + entityId + "/" + finalFileName;

            URL presignedUrl = s3PresignedURLUtil.generatePresignedUploadUrl(s3Key);
            urls.put(fileName, new PresignedUrlResponseDTO(presignedUrl, s3Key));
        }

        return urls;
    }

    private String getExtensionFromFileName(String fileName) {
        int index = fileName.lastIndexOf('.');
        return index != -1 ? fileName.substring(index).toLowerCase() : "";
    }

    // Replace spaces and reserved characters (/ \ ? % * : | " < > #) with underscore
    // these characters may break the URL during presigned upload as they have special meaning in the URLS
    // So replacing them make the file name remains safe for uploading to S3.
    private String sanitizeFileName(String fileName) {
        return fileName.trim().replaceAll("[\\s/\\\\?%*:|\"<>#]", "_");
    }

}

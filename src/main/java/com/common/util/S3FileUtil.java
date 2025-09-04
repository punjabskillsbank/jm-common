package com.common.util;

import com.common.dto.PresignedUrlResponseDTO;

import com.common.exceptionHandling.InvalidFileTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class S3FileUtil {

    private final S3PresignedURLUtil s3Service;

    // Allowed extensions
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".pdf", ".doc", ".docx", ".jpg",".jpeg",".png", ".webp", ".mp4",
            ".mp3", ".wav", ".ppt", ".pptx"
    );

    public List<PresignedUrlResponseDTO> generateMultipleJobAttachmentUrls(String bucketName, Long proposalId, List<String> originalFilenames) {
        List<PresignedUrlResponseDTO> urls = new ArrayList<>();

        for (String fileName : originalFilenames) {
            String extension = getExtensionFromFileName(fileName).toLowerCase();

            //Validate extension
            if (!ALLOWED_EXTENSIONS.contains(extension)) {
                throw new InvalidFileTypeException(extension);
            }

            String finalFileName = sanitizeFileName(fileName);  // Safe name
            String s3Key = "proposal-attachments/" + proposalId + "/" + finalFileName;

            String contentType = guessContentType(extension);

            URL presignedUrl = s3Service.generatePresignedUploadUrl(s3Key, contentType);
            urls.add(new PresignedUrlResponseDTO(presignedUrl, s3Key));
        }

        return urls;
    }

    private String getExtensionFromFileName(String fileName) {
        int index = fileName.lastIndexOf('.');
        return index != -1 ? fileName.substring(index).toLowerCase() : "";
    }

    private String guessContentType(String ext) {
        return switch (ext) {
            case ".jpg", ".jpeg" -> "image/jpeg";
            case ".png" -> "image/png";
            case ".webp" -> "image/webp";
            case ".pdf" -> "application/pdf";
            case ".doc" -> "application/msword";
            case ".docx" -> "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case ".ppt" -> "application/vnd.ms-powerpoint";
            case ".pptx" -> "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case ".mp4" -> "video/mp4";
            case ".mp3" -> "audio/mpeg";
            case ".wav" -> "audio/wav";
            default -> "application/octet-stream"; // fallback
        };
    }

    private String sanitizeFileName(String fileName) {
        return fileName.trim().replaceAll("[^a-zA-Z0-9._-]", "_");
    }

}

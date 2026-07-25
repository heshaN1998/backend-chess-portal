package com.checkmate_portal.chessclub.service;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    private static final List<String> allowed =
            List.of("image/jpeg", "image/png", "image/webp");

    public String storePlayerPhoto(MultipartFile file) {
        validate(file);

        try {
            Path targetDir = Paths.get(uploadDir, "players");
            Files.createDirectories(targetDir);

            String original = StringUtils.cleanPath(file.getOriginalFilename() == null ? "" : file.getOriginalFilename());
            String extension = original.contains(".") ? original.substring(original.lastIndexOf(".")) : "";

            String fileName = UUID.randomUUID() + extension.toLowerCase();
            Path targetPath = targetDir.resolve(fileName);

            try (InputStream in = file.getInputStream()) {Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
            return "players/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store uploaded photo", e);
        }
    }

    public void deletePlayerPhoto(String relativePath) {
        if (relativePath == null || relativePath.isBlank()) {
            return;
        }

        try {Files.deleteIfExists(Paths.get(uploadDir, relativePath));
        } catch (IOException ignored) {
            // Cleanup failure is not critical
        }
    }

    private void validate(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("No file was uploaded");}

        if (!allowed.contains(file.getContentType())) {
            throw new IllegalArgumentException("Only JPEG, PNG, and WEBP images are allowed");}

        if (file.getSize() > 5 * 1024 * 1024) {
            throw new IllegalArgumentException("File must be smaller than 5 MB");}
    }
}
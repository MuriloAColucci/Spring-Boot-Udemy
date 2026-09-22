package br.com.udemy.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UploadFileResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileDowloadUri;
    private String fileType;
    private long size;

    public UploadFileResponseDTO(){}

    public UploadFileResponseDTO(String fileName, String fileDowloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDowloadUri = fileDowloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDowloadUri() {
        return fileDowloadUri;
    }

    public void setFileDowloadUri(String fileDowloadUri) {
        this.fileDowloadUri = fileDowloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UploadFileResponseDTO that)) return false;
        return
                size == that.size &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(fileDowloadUri, that.fileDowloadUri) &&
                Objects.equals(fileType, that.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileDowloadUri, fileType, size);
    }
}

package zk.web;


import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class AttachmentFile {
  private String fileName;
	private File fileNameWithPath;
	// Made inputStream transient as they are machine dependent and cannot be
	// shared.
	private transient InputStream uploadedfile;
	private String beforeExtension;
	private String afterExtension;
	private File fileNameToUpload;
	private String saveFiletype;
	private String attachmentContentTypeUpload;
	private String fileFormat;
	private Integer uploadFileSize;
	private String dosPath;
	private String oldDosPathUpload;
	private String attachmentFileAliasUpload;
	private String attachmentFileSuffixUpload;
	private String uploadName;

	private String tableName;
	private Integer tableRSN;
	private String fileSavePath;
	private String folderType;
	private File tempFile;
	private boolean focusRow;

	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}

	public String getFolderType() {
		return folderType;
	}

	public void setFolderType(String folderType) {
		this.folderType = folderType;
	}

	public String getFileSavePath() {
		return fileSavePath;
	}

	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getTableRSN() {
		return tableRSN;
	}

	public void setTableRSN(Integer tableRSN) {
		this.tableRSN = tableRSN;
	}

	public String getUploadName() {
		return uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getFileNameWithPath() {
		return fileNameWithPath;
	}

	public void setFileNameWithPath(File fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
	}

	public InputStream getUploadedfile() {
		return uploadedfile;
	}

	public void setUploadedfile(InputStream uploadedfile) {
		this.uploadedfile = uploadedfile;
	}

	public String getBeforeExtension() {
		return beforeExtension;
	}

	public void setBeforeExtension(String beforeExtension) {
		this.beforeExtension = beforeExtension;
	}

	public String getAfterExtension() {
		return afterExtension;
	}

	public void setAfterExtension(String afterExtension) {
		this.afterExtension = afterExtension;
	}

	public File getFileNameToUpload() {
		return fileNameToUpload;
	}

	public void setFileNameToUpload(File fileNameToUpload) {
		this.fileNameToUpload = fileNameToUpload;
	}

	public String getSaveFiletype() {
		return saveFiletype;
	}

	public void setSaveFiletype(String saveFiletype) {
		this.saveFiletype = saveFiletype;
	}

	public String getAttachmentContentTypeUpload() {
		return attachmentContentTypeUpload;
	}

	public void setAttachmentContentTypeUpload(String attachmentContentTypeUpload) {
		this.attachmentContentTypeUpload = attachmentContentTypeUpload;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public Integer getUploadFileSize() {
		return uploadFileSize;
	}

	public void setUploadFileSize(Integer uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	public String getDosPath() {
		return dosPath;
	}

	public void setDosPath(String dosPath) {
		this.dosPath = dosPath;
	}

	public String getOldDosPathUpload() {
		return oldDosPathUpload;
	}

	public void setOldDosPathUpload(String oldDosPathUpload) {
		this.oldDosPathUpload = oldDosPathUpload;
	}

	public String getAttachmentFileAliasUpload() {
		return attachmentFileAliasUpload;
	}

	public void setAttachmentFileAliasUpload(String attachmentFileAliasUpload) {
		this.attachmentFileAliasUpload = attachmentFileAliasUpload;
	}

	public String getAttachmentFileSuffixUpload() {
		return attachmentFileSuffixUpload;
	}

	public void setAttachmentFileSuffixUpload(String attachmentFileSuffixUpload) {
		this.attachmentFileSuffixUpload = attachmentFileSuffixUpload;
	}

	public boolean isFocusRow() {
		return focusRow;
	}

	public void setFocusRow(boolean focusRow) {
		this.focusRow = focusRow;
	}

  
  
}

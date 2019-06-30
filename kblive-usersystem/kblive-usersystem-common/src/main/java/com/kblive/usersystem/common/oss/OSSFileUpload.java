package com.kblive.usersystem.common.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.kblive.usersystem.common.utils.datetools.DateTools;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * title: OSSFileUpload
 * projectName kbLive
 * description: oss文件上传工具
 * author 2671242147@qq.com
 * date 2019-06-29 15:00
 ***/
public class OSSFileUpload {

    public static final Logger logger = Logger.getLogger(OSSFileUpload.class);

    private OSSClient ossClient;

    public OSSFileUpload() {
        ossClient = new OSSClient(OSSConfigInfo.Endpoint, OSSConfigInfo.AccessKeyId, OSSConfigInfo.AccessKeySecret);
    }

    public static void main(String[] strs) {
    }

    /**
     * 判断bucketName是否存在
     *
     * @param bucketName 桶名称
     * @return 是否存在
     */
    public boolean bucketIsExit(String bucketName) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(OSSConfigInfo.Endpoint, OSSConfigInfo.AccessKeyId, OSSConfigInfo.AccessKeySecret);
        boolean exists = ossClient.doesBucketExist(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return exists;
    }

    /**
     * 创建桶
     *
     * @param bucketName 桶名称
     * @param cannedACL  读写权限
     */
    public void createBucket(String bucketName, CannedAccessControlList cannedACL) {
        try {
            this.ossClient.createBucket(bucketName);
            this.ossClient.setBucketAcl(bucketName, cannedACL);
            this.ossClient.shutdown();
        } catch (Exception e) {
            logger.error("创建bucket" + bucketName + "失败，失败原因：" + e.getMessage(), e);
        }
    }

    /**
     * 列举所有桶名称
     */
    public List<Bucket> getBucketList() {
        List<Bucket> buckets = this.ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }
        this.ossClient.shutdown();
        return buckets;
    }

    /**
     * 以文件的形式上传
     *
     * @param localfilepath 文件的路径
     * @param fileName      文件名称（有后缀）
     */
    public void upLoadFileByFile(String localfilepath, String fileName) {
        try {
            this.ossClient.putObject(OSSConfigInfo.OSSBucketName, OSSConfigInfo.FileSavePath + fileName, new File(localfilepath));
            logger.info("###上传" + fileName + "文件成功");
        } catch (OSSException | ClientException e) {
            logger.error("###上传文件失败" + "，失败原因:" + e.getMessage(), e);
        } finally {
            if (this.ossClient != null) {
                this.ossClient.shutdown();
            }
        }
    }

    /**
     * 上传单个文件
     *
     * @param file         文件
     * @param fileType     文件类型
     * @param fileName     文件名
     * @param fileSavePath 文件保存路径
     * @return 上传后文件的url
     */
    public String uploadSingleFile(File file, String fileType, String fileName, String fileSavePath) {
        InputStream iStream;
        try {
            iStream = new FileInputStream(file);
        } catch (Exception e) {
            logger.error("###获取文件流失败" + "，失败原因:" + e.getMessage(), e);
            return null;
        }
        return uploadSingleFile(iStream, fileType, fileName, fileSavePath);
    }

    /**
     * 已流的形式上传单个文件
     *
     * @param iStream      文件输入流
     * @param fileType     文件类型
     * @param fileName     文件名称（包括后缀）
     * @param fileSavePath 文件保存路径
     * @return 文件的url
     */
    private String uploadSingleFile(InputStream iStream, String fileType, String fileName, String fileSavePath) {
        //前缀
        String prefix = System.currentTimeMillis() + "-" + DateTools.dateToStrNoWithTimeNoLine(new Date());
        String name = (fileName == null) ? prefix + "." + fileType : prefix + "-" + fileName;
        return putObject(iStream, fileType, name, fileSavePath);
    }

    /**
     * 单文件删除
     *
     * @param fileSavePath 文件保存路径
     * @param fileUrl      需要删除的文件url
     * @return boolean 是否删除成功
     */
    public boolean deleteFile(String fileUrl, String fileSavePath) {
        //根据url获取bucketName
        String bucketName = getBucketName(fileUrl);
        //根据url获取fileName
        String fileName = getFileName(fileUrl, fileSavePath);
        if (bucketName == null || fileName == null) return false;
        try {
            GenericRequest request = new DeleteObjectsRequest(bucketName).withKey(fileName);
            this.ossClient.deleteObject(request);
            logger.info("###删除" + fileName + "文件成功");
        } catch (Exception e) {
            logger.error("###删除文件失败" + "，失败原因:" + e.getMessage(), e);
            return false;
        } finally {
            if (this.ossClient != null) {
                this.ossClient.shutdown();
            }
        }
        return true;
    }

    /**
     * 文件是否存在
     *
     * @param filePath 文件路径
     * @return 是否存在
     */
    public boolean doesObjectExist(String filePath) {
        try {
            int index = filePath.indexOf(".com/");
            filePath = filePath.substring(index + 5);
            return this.ossClient.doesObjectExist(OSSConfigInfo.OSSBucketName, filePath);
        } catch (Exception e) {
            logger.error("OSS判断doesObjectExist错误:" + e.getMessage(), e);
            return false;
        }
    }

    /**
     * 获取文件流
     *
     * @param filePath 文件路径
     * @return 输入流
     */
    public InputStream getObjectFile(String filePath) {
        try {
            int index = filePath.indexOf(".com/");
            filePath = filePath.substring(index + 5);
            OSSObject ossObject = this.ossClient.getObject(OSSConfigInfo.OSSBucketName, filePath);
            return ossObject.getObjectContent();
        } catch (Exception e) {
            logger.error("OSS获取错误：" + e.getMessage(), e);
            return new ByteArrayInputStream("".getBytes());
        }
    }

    /**
     * 列举指定存储空间下指定前缀的文件
     *
     * @param bucketName 桶名称
     * @param keyPrefix  前缀
     */
    public void listFile(String bucketName, String keyPrefix) {
        ObjectListing objectListing = this.ossClient.listObjects(bucketName, keyPrefix);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
        this.ossClient.shutdown();
    }

    /**
     * 列举指定存储空间下指定前缀的文件
     *
     * @param listObjectsRequest
     */
    public void listFile(ListObjectsRequest listObjectsRequest) {
        ObjectListing objectListing = this.ossClient.listObjects(listObjectsRequest);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
        this.ossClient.shutdown();
    }

    /**
     * 分页列举指定前缀的文件
     *
     * @param listObjectsRequest
     */
    public void listFile(ListObjectsRequest listObjectsRequest, String nextMarker) {
        ObjectListing objectListing;
        do {
            objectListing = this.ossClient.listObjects(listObjectsRequest.withMarker(nextMarker));
            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                System.out.println("\t" + s.getKey());
            }
            System.out.println("\t---------------------------------");
            nextMarker = objectListing.getNextMarker();
        } while (objectListing.isTruncated());
        this.ossClient.shutdown();
    }

    /**
     * 获取文件类型相对应的contentType
     *
     * @param fileType 文件类型
     * @return 文件类型相对应的contentType
     */
    private String geContentTypeByFileType(String fileType) {
        fileType = fileType.toLowerCase();
        String contentType;
        switch (fileType) {
            case "bmp":
                contentType = "image/bmp";
                break;
            case "gif":
                contentType = "image/gif";
                break;
            case "png":
            case "jpeg":
            case "jpg":
                contentType = "image/jpeg";
                break;
            case "html":
                contentType = "text/html";
                break;
            case "txt":
                contentType = "text/plain";
                break;
            case "vsd":
                contentType = "application/vnd.visio";
                break;
            case "ppt":
            case "pptx":
                contentType = "application/vnd.ms-powerpoint";
                break;
            case "doc":
            case "docx":
                contentType = "application/msword";
                break;
            case "xml":
                contentType = "text/xml";
                break;
            case "mp4":
                contentType = "video/mp4";
                break;
            case "xls":
                contentType = "application/x-xls";
                break;
            default:
                contentType = "application/octet-stream";
                break;
        }
        return contentType;
    }

    /**
     * 上传文件的基础方法
     *
     * @param input        文件流
     * @param fileType     文件类型
     * @param fileName     要保存的文件名（带后缀）
     * @param fileSavePath 文件保存路径
     * @return 上传成功后的URL
     */
    private String putObject(InputStream input, String fileType, String fileName, String fileSavePath) {
        //默认null
        String url;
        try {
            // 创建上传Object的元数据
            ObjectMetadata meta = new ObjectMetadata();
            // 设置上传内容类型
            meta.setContentType(geContentTypeByFileType(fileType));
            // 被下载时网页的缓存行为
            meta.setCacheControl("no-cache");
            //创建上传请求
            PutObjectRequest request = new PutObjectRequest(OSSConfigInfo.OSSBucketName, fileSavePath + fileName,
                    input, meta);
            this.ossClient.putObject(request);
            //上传成功再返回的文件路径
            url = OSSConfigInfo.Endpoint.replaceFirst("https://",
                    "https://" + OSSConfigInfo.OSSBucketName + ".") + "/" + fileSavePath + fileName;
            logger.info("###上传" + fileName + "文件成功");
        } catch (OSSException | ClientException e) {
            logger.error("###文件上传失败" + "，失败原因:" + e.getMessage(), e);
            return null;
        } finally {
            if (this.ossClient != null) {
                this.ossClient.shutdown();
            }
        }
        return url;
    }

    /**
     * 根据url获取bucketName
     *
     * @param fileUrl 文件url
     * @return String bucketName
     */
    private String getBucketName(String fileUrl) {
        String http = "http://";
        String https = "https://";
        int httpIndex = fileUrl.indexOf(http);
        int httpsIndex = fileUrl.indexOf(https);
        int startIndex;
        if (httpIndex == -1) {
            if (httpsIndex == -1) {
                return null;
            } else {
                startIndex = httpsIndex + https.length();
            }
        } else {
            startIndex = httpIndex + http.length();
        }
        int endIndex = fileUrl.indexOf(".oss-");
        return fileUrl.substring(startIndex, endIndex);
    }

    /**
     * 根据url获取fileName
     *
     * @param fileUrl      文件url
     * @param fileSavePath 文件保存路径
     * @return String fileName
     * //https://kblive.oss-cn-shenzhen.aliyuncs.com/txt/eason.txt
     */
    private String getFileName(String fileUrl, String fileSavePath) {
        String str = "aliyuncs.com/" + fileSavePath;
        int beginIndex = fileUrl.indexOf(str);
        if (beginIndex == -1) return null;
        return fileUrl.substring(beginIndex + str.length());
    }

}

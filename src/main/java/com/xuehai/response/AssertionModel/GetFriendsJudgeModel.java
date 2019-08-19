package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

/**
 * @Author slyart
 * @create 2019/8/13 2:58 PM
 */
public class GetFriendsJudgeModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked","Date":"Tue, 13 Aug 2019 06:47:49 GMT"}
     * responseInfo : false
     */

    private int responseCode;
    private String responseMessage;
    private ResponseHeaderBean responseHeader;
    private String responseInfo;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseHeaderBean getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeaderBean responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(String responseInfo) {
        this.responseInfo = responseInfo;
    }

    public static class ResponseHeaderBean {
        /**
         * X-Content-Type-Options : nosniff
         * X-XSS-Protection : 1; mode=block
         * Cache-Control : no-cache, no-store, max-age=0, must-revalidate
         * Pragma : no-cache
         * Expires : 0
         * X-Frame-Options : DENY
         * Content-Type : application/json;charset=UTF-8
         * Transfer-Encoding : chunked
         * Date : Tue, 13 Aug 2019 06:47:49 GMT
         */

        @SerializedName("X-Content-Type-Options")
        private String XContentTypeOptions;
        @SerializedName("X-XSS-Protection")
        private String XXSSProtection;
        @SerializedName("Cache-Control")
        private String CacheControl;
        private String Pragma;
        private String Expires;
        @SerializedName("X-Frame-Options")
        private String XFrameOptions;
        @SerializedName("Content-Type")
        private String ContentType;
        @SerializedName("Transfer-Encoding")
        private String TransferEncoding;
        private String Date;

        public String getXContentTypeOptions() {
            return XContentTypeOptions;
        }

        public void setXContentTypeOptions(String XContentTypeOptions) {
            this.XContentTypeOptions = XContentTypeOptions;
        }

        public String getXXSSProtection() {
            return XXSSProtection;
        }

        public void setXXSSProtection(String XXSSProtection) {
            this.XXSSProtection = XXSSProtection;
        }

        public String getCacheControl() {
            return CacheControl;
        }

        public void setCacheControl(String CacheControl) {
            this.CacheControl = CacheControl;
        }

        public String getPragma() {
            return Pragma;
        }

        public void setPragma(String Pragma) {
            this.Pragma = Pragma;
        }

        public String getExpires() {
            return Expires;
        }

        public void setExpires(String Expires) {
            this.Expires = Expires;
        }

        public String getXFrameOptions() {
            return XFrameOptions;
        }

        public void setXFrameOptions(String XFrameOptions) {
            this.XFrameOptions = XFrameOptions;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String ContentType) {
            this.ContentType = ContentType;
        }

        public String getTransferEncoding() {
            return TransferEncoding;
        }

        public void setTransferEncoding(String TransferEncoding) {
            this.TransferEncoding = TransferEncoding;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }
    }
}

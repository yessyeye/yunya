package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author slyart
 * @create 2019/8/18 9:11 AM
 */
public class GetShieldNotesModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked","Date":"Sun, 18 Aug 2019 00:55:24 GMT"}
     * responseInfo : {"version":1565925084121,"changes":[{"peerId":152414,"status":1},{"peerId":152412,"status":1},{"peerId":152575,"status":1},{"peerId":152576,"status":1},{"peerId":152577,"status":1},{"peerId":152578,"status":1},{"peerId":152579,"status":1},{"peerId":152580,"status":1},{"peerId":152581,"status":1},{"peerId":152574,"status":1},{"peerId":152573,"status":1},{"peerId":152422,"status":1},{"peerId":152421,"status":1},{"peerId":152420,"status":1},{"peerId":152419,"status":1},{"peerId":152418,"status":1},{"peerId":152417,"status":1},{"peerId":152416,"status":1},{"peerId":152415,"status":1},{"peerId":152582,"status":1}]}
     */

    private int responseCode;
    private String responseMessage;
    private ResponseHeaderBean responseHeader;
    private ResponseInfoBean responseInfo;

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

    public ResponseInfoBean getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfoBean responseInfo) {
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
         * Date : Sun, 18 Aug 2019 00:55:24 GMT
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

    public static class ResponseInfoBean {
        /**
         * version : 1565925084121
         * changes : [{"peerId":152414,"status":1},{"peerId":152412,"status":1},{"peerId":152575,"status":1},{"peerId":152576,"status":1},{"peerId":152577,"status":1},{"peerId":152578,"status":1},{"peerId":152579,"status":1},{"peerId":152580,"status":1},{"peerId":152581,"status":1},{"peerId":152574,"status":1},{"peerId":152573,"status":1},{"peerId":152422,"status":1},{"peerId":152421,"status":1},{"peerId":152420,"status":1},{"peerId":152419,"status":1},{"peerId":152418,"status":1},{"peerId":152417,"status":1},{"peerId":152416,"status":1},{"peerId":152415,"status":1},{"peerId":152582,"status":1}]
         */

        private long version;
        private List<ChangesBean> changes;

        public long getVersion() {
            return version;
        }

        public void setVersion(long version) {
            this.version = version;
        }

        public List<ChangesBean> getChanges() {
            return changes;
        }

        public void setChanges(List<ChangesBean> changes) {
            this.changes = changes;
        }

        public static class ChangesBean {
            /**
             * peerId : 152414
             * status : 1
             */

            private int peerId;
            private int status;

            public int getPeerId() {
                return peerId;
            }

            public void setPeerId(int peerId) {
                this.peerId = peerId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}

package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author slyart
 * @create 2019/9/4 9:04 AM
 */
public class GetUserSearchModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"date":"Tue, 03 Sep 2019 08:20:01 GMT","transfer-encoding":"chunked","X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked"}
     * responseInfo : {"totalElements":1540,"numberOfElements":10,"hasNext":true,"number":0,"content":[{"id":1667,"roles":["student"],"name":"谢佳佳佳"},{"id":23508,"roles":["student"],"name":"佳佳"},{"id":1968,"roles":["student"],"name":"董佳佳"},{"id":3728,"roles":["student"],"name":"吴佳佳"},{"id":5070,"roles":["student"],"name":"莫佳佳"},{"id":8120,"roles":["student"],"name":"向佳佳"},{"id":11375,"roles":["student"],"name":".郑佳佳"},{"id":16091,"roles":["student"],"name":"祝佳佳"},{"id":16365,"roles":["student"],"name":"陈佳佳"},{"id":16488,"roles":["student"],"name":"徐佳佳"}]}
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
         * date : Tue, 03 Sep 2019 08:20:01 GMT
         * transfer-encoding : chunked
         * X-Content-Type-Options : nosniff
         * X-XSS-Protection : 1; mode=block
         * Cache-Control : no-cache, no-store, max-age=0, must-revalidate
         * Pragma : no-cache
         * Expires : 0
         * X-Frame-Options : DENY
         * Content-Type : application/json;charset=UTF-8
         * Transfer-Encoding : chunked
         */

        private String date;
        @SerializedName("transfer-encoding")
        private String transferencoding;
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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTransferencoding() {
            return transferencoding;
        }

        public void setTransferencoding(String transferencoding) {
            this.transferencoding = transferencoding;
        }

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
    }

    public static class ResponseInfoBean {
        /**
         * totalElements : 1540
         * numberOfElements : 10
         * hasNext : true
         * number : 0
         * content : [{"id":1667,"roles":["student"],"name":"谢佳佳佳"},{"id":23508,"roles":["student"],"name":"佳佳"},{"id":1968,"roles":["student"],"name":"董佳佳"},{"id":3728,"roles":["student"],"name":"吴佳佳"},{"id":5070,"roles":["student"],"name":"莫佳佳"},{"id":8120,"roles":["student"],"name":"向佳佳"},{"id":11375,"roles":["student"],"name":".郑佳佳"},{"id":16091,"roles":["student"],"name":"祝佳佳"},{"id":16365,"roles":["student"],"name":"陈佳佳"},{"id":16488,"roles":["student"],"name":"徐佳佳"}]
         */

        private int totalElements;
        private int numberOfElements;
        private boolean hasNext;
        private int number;
        private List<ContentBean> content;

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean {
            /**
             * id : 1667
             * roles : ["student"]
             * name : 谢佳佳佳
             */

            private int id;
            private String name;
            private List<String> roles;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getRoles() {
                return roles;
            }

            public void setRoles(List<String> roles) {
                this.roles = roles;
            }
        }
    }
}

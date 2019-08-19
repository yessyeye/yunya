package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author slyart
 * @create 2019/8/18 9:43 AM
 */
public class GetSessionMessagesModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked","Date":"Sun, 18 Aug 2019 00:55:24 GMT"}
     * responseInfo : [{"fromId":152569,"sessionId":152569,"msgId":12,"type":"SINGLE_APP","content":"{\"shareType\":\"HOME_WORK\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cce9682c922871c5b5b1cc1\\\",\\\"homeWorkTitle\\\":\\\"1 春 学海学海学海输入法浙江学海教育科技有限公司\\\",\\\"homeWorkCreator\\\":\\\"殷天正\\\",\\\"homeWorkDate\\\":\\\"周日 15:53\\\"}\"}","createdTime":1558343209205,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":11,"type":"SINGLE_TEXT","content":"1111","createdTime":1558336461867,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":10,"type":"SINGLE_TEXT","content":"111","createdTime":1558336449945,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":9,"type":"SINGLE_TEXT","content":"111","createdTime":1558336442460,"status":"REVOKE","extend":""},{"fromId":152569,"sessionId":152569,"msgId":8,"type":"SINGLE_TEXT","content":"1111","createdTime":1558336424471,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":7,"type":"SINGLE_TEXT","content":"111","createdTime":1558336115534,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":6,"type":"SINGLE_TEXT","content":"1111","createdTime":1558335997164,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":5,"type":"SINGLE_TEXT","content":"5666","createdTime":1558335920307,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":4,"type":"SINGLE_TEXT","content":"6666","createdTime":1558335913226,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":3,"type":"SINGLE_TEXT","content":"111","createdTime":1558335867675,"status":"OK","extend":""},{"fromId":152569,"sessionId":152569,"msgId":2,"type":"SINGLE_IMAGE","content":"{\"img_height\":1184,\"img_width\":800,\"localimg_url\":\"/storage/emulated/0/xuehai/com.xh.arespunc/tmp/1558335448071.png\",\"serverimg_url\":\"http://xhfs0.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190520/c8b69e35ae6548268eba2da446f364eb.PNG\"}","createdTime":1558335611395,"status":"OK","extend":""},{"fromId":152424,"sessionId":152569,"msgId":1,"type":"SINGLE_APP","content":"{\"shareType\":\"MCRO_COURSE\",\"content\":\"{\\\"courseId\\\":null,\\\"courseTitle\\\":\\\"微课\\\",\\\"courseSubTitle\\\":null,\\\"url\\\":\\\"http://xhfs5.oss-cn-hangzhou.aliyuncs.com/CA103001/SingleUpload/21b2cd01737841e08c971333204a7d31.cwp\\\",\\\"courseDuration\\\":\\\"01'33\\\\\\\"\\\",\\\"courseDate\\\":\\\"2019-03-25\\\",\\\"microTitle\\\":\\\"能看见马\\\",\\\"userName\\\":\\\"张翠山\\\",\\\"lectureId\\\":\\\"5c98a883468d4a5bb6e32ae8\\\",\\\"topicId\\\":\\\"59a4f8d6e6279517d0362bbc\\\",\\\"workId\\\":null}\"}","createdTime":1553508504212,"status":"OK","extend":""}]
     */

    private int responseCode;
    private String responseMessage;
    private ResponseHeaderBean responseHeader;
    private List<ResponseInfoBean> responseInfo;

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

    public List<ResponseInfoBean> getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(List<ResponseInfoBean> responseInfo) {
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
         * fromId : 152569
         * sessionId : 152569
         * msgId : 12
         * type : SINGLE_APP
         * content : {"shareType":"HOME_WORK","content":"{\"homeWorkId\":\"5cce9682c922871c5b5b1cc1\",\"homeWorkTitle\":\"1 春 学海学海学海输入法浙江学海教育科技有限公司\",\"homeWorkCreator\":\"殷天正\",\"homeWorkDate\":\"周日 15:53\"}"}
         * createdTime : 1558343209205
         * status : OK
         * extend :
         */

        private int fromId;
        private int sessionId;
        private int msgId;
        private String type;
        private String content;
        private long createdTime;
        private String status;
        private String extend;

        public int getFromId() {
            return fromId;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public int getSessionId() {
            return sessionId;
        }

        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }

        public int getMsgId() {
            return msgId;
        }

        public void setMsgId(int msgId) {
            this.msgId = msgId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getExtend() {
            return extend;
        }

        public void setExtend(String extend) {
            this.extend = extend;
        }
    }
}

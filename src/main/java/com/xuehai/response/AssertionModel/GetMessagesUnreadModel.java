package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author slyart
 * @create 2019/8/18 9:54 AM
 */
public class GetMessagesUnreadModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked","Date":"Sun, 18 Aug 2019 00:55:25 GMT"}
     * responseInfo : {"userId":152424,"totalCounter":25,"unreadInfoList":[{"sessionId":152420,"sessionType":"SINGLE","unreadCount":1,"latestMsgId":27,"latestMsgContent":"黑乎乎","latestMsgType":"SINGLE_TEXT","latestMsgFromUserId":152420,"latestMsgCreatedDate":1563240896269,"latestMsgStatus":"OK","latestMsgExtend":""},{"sessionId":152414,"sessionType":"SINGLE","unreadCount":23,"latestMsgId":473,"latestMsgContent":"111","latestMsgType":"SINGLE_TEXT","latestMsgFromUserId":152424,"latestMsgCreatedDate":1565752900600,"latestMsgStatus":"REVOKE","latestMsgExtend":""},{"sessionId":152425,"sessionType":"SINGLE","unreadCount":1,"latestMsgId":64,"latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Tencent/QQfile_recv/DE923958-4E9F-4AC8-A73C-FE141473EC70.png\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190816/f56f25a10e3440259eb1888d05edb1ff.PNG\"}","latestMsgType":"SINGLE_IMAGE","latestMsgFromUserId":152425,"latestMsgCreatedDate":1565938242667,"latestMsgStatus":"OK","latestMsgExtend":""}],"version":1558336446709,"revokeInfoList":[{"sessionId":152569,"sessionType":"SINGLE","msgId":9,"msgContent":"111","msgType":"SINGLE_TEXT","fromUserId":152569,"createdDate":1558336442460,"revokeDate":1558336446709,"status":"REVOKE","extend":""},{"sessionId":152425,"sessionType":"SINGLE","msgId":7,"msgContent":"大兄弟","msgType":"SINGLE_TEXT","fromUserId":152425,"createdDate":1554691312442,"revokeDate":1554691322123,"status":"REVOKE","extend":""},{"sessionId":152425,"sessionType":"SINGLE","msgId":6,"msgContent":"兄弟","msgType":"SINGLE_TEXT","fromUserId":152425,"createdDate":1554691296426,"revokeDate":1554691320276,"status":"REVOKE","extend":""}]}
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
         * Date : Sun, 18 Aug 2019 00:55:25 GMT
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
         * userId : 152424
         * totalCounter : 25
         * unreadInfoList : [{"sessionId":152420,"sessionType":"SINGLE","unreadCount":1,"latestMsgId":27,"latestMsgContent":"黑乎乎","latestMsgType":"SINGLE_TEXT","latestMsgFromUserId":152420,"latestMsgCreatedDate":1563240896269,"latestMsgStatus":"OK","latestMsgExtend":""},{"sessionId":152414,"sessionType":"SINGLE","unreadCount":23,"latestMsgId":473,"latestMsgContent":"111","latestMsgType":"SINGLE_TEXT","latestMsgFromUserId":152424,"latestMsgCreatedDate":1565752900600,"latestMsgStatus":"REVOKE","latestMsgExtend":""},{"sessionId":152425,"sessionType":"SINGLE","unreadCount":1,"latestMsgId":64,"latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Tencent/QQfile_recv/DE923958-4E9F-4AC8-A73C-FE141473EC70.png\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190816/f56f25a10e3440259eb1888d05edb1ff.PNG\"}","latestMsgType":"SINGLE_IMAGE","latestMsgFromUserId":152425,"latestMsgCreatedDate":1565938242667,"latestMsgStatus":"OK","latestMsgExtend":""}]
         * version : 1558336446709
         * revokeInfoList : [{"sessionId":152569,"sessionType":"SINGLE","msgId":9,"msgContent":"111","msgType":"SINGLE_TEXT","fromUserId":152569,"createdDate":1558336442460,"revokeDate":1558336446709,"status":"REVOKE","extend":""},{"sessionId":152425,"sessionType":"SINGLE","msgId":7,"msgContent":"大兄弟","msgType":"SINGLE_TEXT","fromUserId":152425,"createdDate":1554691312442,"revokeDate":1554691322123,"status":"REVOKE","extend":""},{"sessionId":152425,"sessionType":"SINGLE","msgId":6,"msgContent":"兄弟","msgType":"SINGLE_TEXT","fromUserId":152425,"createdDate":1554691296426,"revokeDate":1554691320276,"status":"REVOKE","extend":""}]
         */

        private int userId;
        private int totalCounter;
        private long version;
        private List<UnreadInfoListBean> unreadInfoList;
        private List<RevokeInfoListBean> revokeInfoList;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTotalCounter() {
            return totalCounter;
        }

        public void setTotalCounter(int totalCounter) {
            this.totalCounter = totalCounter;
        }

        public long getVersion() {
            return version;
        }

        public void setVersion(long version) {
            this.version = version;
        }

        public List<UnreadInfoListBean> getUnreadInfoList() {
            return unreadInfoList;
        }

        public void setUnreadInfoList(List<UnreadInfoListBean> unreadInfoList) {
            this.unreadInfoList = unreadInfoList;
        }

        public List<RevokeInfoListBean> getRevokeInfoList() {
            return revokeInfoList;
        }

        public void setRevokeInfoList(List<RevokeInfoListBean> revokeInfoList) {
            this.revokeInfoList = revokeInfoList;
        }

        public static class UnreadInfoListBean {
            /**
             * sessionId : 152420
             * sessionType : SINGLE
             * unreadCount : 1
             * latestMsgId : 27
             * latestMsgContent : 黑乎乎
             * latestMsgType : SINGLE_TEXT
             * latestMsgFromUserId : 152420
             * latestMsgCreatedDate : 1563240896269
             * latestMsgStatus : OK
             * latestMsgExtend :
             */

            private int sessionId;
            private String sessionType;
            private int unreadCount;
            private int latestMsgId;
            private String latestMsgContent;
            private String latestMsgType;
            private int latestMsgFromUserId;
            private long latestMsgCreatedDate;
            private String latestMsgStatus;
            private String latestMsgExtend;

            public int getSessionId() {
                return sessionId;
            }

            public void setSessionId(int sessionId) {
                this.sessionId = sessionId;
            }

            public String getSessionType() {
                return sessionType;
            }

            public void setSessionType(String sessionType) {
                this.sessionType = sessionType;
            }

            public int getUnreadCount() {
                return unreadCount;
            }

            public void setUnreadCount(int unreadCount) {
                this.unreadCount = unreadCount;
            }

            public int getLatestMsgId() {
                return latestMsgId;
            }

            public void setLatestMsgId(int latestMsgId) {
                this.latestMsgId = latestMsgId;
            }

            public String getLatestMsgContent() {
                return latestMsgContent;
            }

            public void setLatestMsgContent(String latestMsgContent) {
                this.latestMsgContent = latestMsgContent;
            }

            public String getLatestMsgType() {
                return latestMsgType;
            }

            public void setLatestMsgType(String latestMsgType) {
                this.latestMsgType = latestMsgType;
            }

            public int getLatestMsgFromUserId() {
                return latestMsgFromUserId;
            }

            public void setLatestMsgFromUserId(int latestMsgFromUserId) {
                this.latestMsgFromUserId = latestMsgFromUserId;
            }

            public long getLatestMsgCreatedDate() {
                return latestMsgCreatedDate;
            }

            public void setLatestMsgCreatedDate(long latestMsgCreatedDate) {
                this.latestMsgCreatedDate = latestMsgCreatedDate;
            }

            public String getLatestMsgStatus() {
                return latestMsgStatus;
            }

            public void setLatestMsgStatus(String latestMsgStatus) {
                this.latestMsgStatus = latestMsgStatus;
            }

            public String getLatestMsgExtend() {
                return latestMsgExtend;
            }

            public void setLatestMsgExtend(String latestMsgExtend) {
                this.latestMsgExtend = latestMsgExtend;
            }
        }

        public static class RevokeInfoListBean {
            /**
             * sessionId : 152569
             * sessionType : SINGLE
             * msgId : 9
             * msgContent : 111
             * msgType : SINGLE_TEXT
             * fromUserId : 152569
             * createdDate : 1558336442460
             * revokeDate : 1558336446709
             * status : REVOKE
             * extend :
             */

            private int sessionId;
            private String sessionType;
            private int msgId;
            private String msgContent;
            private String msgType;
            private int fromUserId;
            private long createdDate;
            private long revokeDate;
            private String status;
            private String extend;

            public int getSessionId() {
                return sessionId;
            }

            public void setSessionId(int sessionId) {
                this.sessionId = sessionId;
            }

            public String getSessionType() {
                return sessionType;
            }

            public void setSessionType(String sessionType) {
                this.sessionType = sessionType;
            }

            public int getMsgId() {
                return msgId;
            }

            public void setMsgId(int msgId) {
                this.msgId = msgId;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }

            public String getMsgType() {
                return msgType;
            }

            public void setMsgType(String msgType) {
                this.msgType = msgType;
            }

            public int getFromUserId() {
                return fromUserId;
            }

            public void setFromUserId(int fromUserId) {
                this.fromUserId = fromUserId;
            }

            public long getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(long createdDate) {
                this.createdDate = createdDate;
            }

            public long getRevokeDate() {
                return revokeDate;
            }

            public void setRevokeDate(long revokeDate) {
                this.revokeDate = revokeDate;
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
}

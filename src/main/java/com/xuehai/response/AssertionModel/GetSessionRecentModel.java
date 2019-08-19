package com.xuehai.response.AssertionModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author slyart
 * @create 2019/8/18 9:32 AM
 */
public class GetSessionRecentModel {

    /**
     * responseCode : 200
     * responseMessage :
     * responseHeader : {"X-Content-Type-Options":"nosniff","X-XSS-Protection":"1; mode=block","Cache-Control":"no-cache, no-store, max-age=0, must-revalidate","Pragma":"no-cache","Expires":"0","X-Frame-Options":"DENY","Content-Type":"application/json;charset=UTF-8","Transfer-Encoding":"chunked","Date":"Sun, 18 Aug 2019 00:55:24 GMT"}
     * responseInfo : {"lastTime":1565938242667,"sessions":[{"sessionId":152425,"status":"OK","type":"SINGLE","updateTime":1565938242667,"latestMsgFromUserId":152425,"latestMsgId":64,"latestMsgType":"SINGLE_IMAGE","latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Tencent/QQfile_recv/DE923958-4E9F-4AC8-A73C-FE141473EC70.png\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190816/f56f25a10e3440259eb1888d05edb1ff.PNG\"}","latestMsgCreatedDate":1565938242667,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152568,"status":"OK","type":"SINGLE","updateTime":1565777327093,"latestMsgFromUserId":152568,"latestMsgId":34,"latestMsgType":"SINGLE_IMAGE","latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Pictures/1562566305394.jpg\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190814/b8e387ac2a2b42cc836fb6c506f84063.PNG\"}","latestMsgCreatedDate":1565777327093,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152414,"status":"OK","type":"SINGLE","updateTime":1565752901001,"latestMsgFromUserId":152424,"latestMsgId":473,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1565752900600,"latestMsgStatus":"REVOKE","latestMsgExtend":"","isTop":0,"topSortTime":1565752900944,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152420,"status":"OK","type":"SINGLE","updateTime":1563240896269,"latestMsgFromUserId":152420,"latestMsgId":27,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"黑乎乎","latestMsgCreatedDate":1563240896269,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31822,"status":"OK","type":"GROUP","updateTime":1562899365279,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31695,"status":"OK","type":"GROUP","updateTime":1562660144546,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31694,"status":"OK","type":"GROUP","updateTime":1562659779091,"latestMsgFromUserId":152424,"latestMsgId":1,"latestMsgType":"GROUP_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1562659779091,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31693,"status":"OK","type":"GROUP","updateTime":1562658088166,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31692,"status":"OK","type":"GROUP","updateTime":1562657908912,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31691,"status":"OK","type":"GROUP","updateTime":1562657492999,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152417,"status":"OK","type":"SINGLE","updateTime":1562656906626,"latestMsgFromUserId":152424,"latestMsgId":55,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1562656906626,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31656,"status":"OK","type":"GROUP","updateTime":1561546050734,"latestMsgFromUserId":152413,"latestMsgId":10,"latestMsgType":"GROUP_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cc801edc922871c5b5b1766\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1 Good morning！\\\",\\\"homeWorkCreator\\\":\\\"任我行\\\",\\\"homeWorkDate\\\":\\\"周二 16:06\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cc801edc922871c5b5b1766&authorId=152413&shareName=Starter Unit 1 Good morning！\\\"}\"}","latestMsgCreatedDate":1561603985536,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152416,"status":"OK","type":"SINGLE","updateTime":1561358450448,"latestMsgFromUserId":152416,"latestMsgId":28,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"我","latestMsgCreatedDate":1561358450448,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31632,"status":"OK","type":"GROUP","updateTime":1561104097973,"latestMsgFromUserId":152424,"latestMsgId":21,"latestMsgType":"GROUP_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1561104097973,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31618,"status":"OK","type":"GROUP","updateTime":1561104015131,"latestMsgFromUserId":152414,"latestMsgId":251,"latestMsgType":"GROUP_TEXT","latestMsgContent":"as ","latestMsgCreatedDate":1565658525338,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31617,"status":"OK","type":"GROUP","updateTime":1560495425077,"latestMsgFromUserId":152424,"latestMsgId":4,"latestMsgType":"GROUP_TEXT","latestMsgContent":"2222","latestMsgCreatedDate":1560495425077,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152415,"status":"OK","type":"SINGLE","updateTime":1560495399972,"latestMsgFromUserId":152424,"latestMsgId":40,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1561104097973,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31264,"status":"OK","type":"GROUP","updateTime":1560495327090,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"GROUP_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327090,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31613,"status":"OK","type":"GROUP","updateTime":1560495262764,"latestMsgFromUserId":152571,"latestMsgId":29,"latestMsgType":"GROUP_AUDIO","latestMsgContent":"{\"hasread\":0,\"localpath\":\"/storage/emulated/0/record/20190625103536.amr\",\"serverpath\":\"http://xhfs4.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190625/bab062bf637c4564a5e2cc0e651e36d5.amr\",\"voicelength\":3}","latestMsgCreatedDate":1561430137416,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152413,"status":"OK","type":"SINGLE","updateTime":1560495022551,"latestMsgFromUserId":152424,"latestMsgId":4,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327668,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152423,"status":"OK","type":"SINGLE","updateTime":1560492912894,"latestMsgFromUserId":152424,"latestMsgId":11,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327150,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31566,"status":"OK","type":"GROUP","updateTime":1559616588733,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"GROUP_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1559616588733,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":151353,"status":"OK","type":"SINGLE","updateTime":1559111677799,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\"}\"}","latestMsgCreatedDate":1559111677784,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152569,"status":"OK","type":"SINGLE","updateTime":1559034066587,"latestMsgFromUserId":152424,"latestMsgId":16,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327626,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false}]}
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
         * lastTime : 1565938242667
         * sessions : [{"sessionId":152425,"status":"OK","type":"SINGLE","updateTime":1565938242667,"latestMsgFromUserId":152425,"latestMsgId":64,"latestMsgType":"SINGLE_IMAGE","latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Tencent/QQfile_recv/DE923958-4E9F-4AC8-A73C-FE141473EC70.png\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190816/f56f25a10e3440259eb1888d05edb1ff.PNG\"}","latestMsgCreatedDate":1565938242667,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152568,"status":"OK","type":"SINGLE","updateTime":1565777327093,"latestMsgFromUserId":152568,"latestMsgId":34,"latestMsgType":"SINGLE_IMAGE","latestMsgContent":"{\"img_height\":0,\"img_width\":0,\"localimg_url\":\"/storage/emulated/0/Pictures/1562566305394.jpg\",\"serverimg_url\":\"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190814/b8e387ac2a2b42cc836fb6c506f84063.PNG\"}","latestMsgCreatedDate":1565777327093,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152414,"status":"OK","type":"SINGLE","updateTime":1565752901001,"latestMsgFromUserId":152424,"latestMsgId":473,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1565752900600,"latestMsgStatus":"REVOKE","latestMsgExtend":"","isTop":0,"topSortTime":1565752900944,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152420,"status":"OK","type":"SINGLE","updateTime":1563240896269,"latestMsgFromUserId":152420,"latestMsgId":27,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"黑乎乎","latestMsgCreatedDate":1563240896269,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31822,"status":"OK","type":"GROUP","updateTime":1562899365279,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31695,"status":"OK","type":"GROUP","updateTime":1562660144546,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31694,"status":"OK","type":"GROUP","updateTime":1562659779091,"latestMsgFromUserId":152424,"latestMsgId":1,"latestMsgType":"GROUP_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1562659779091,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31693,"status":"OK","type":"GROUP","updateTime":1562658088166,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31692,"status":"OK","type":"GROUP","updateTime":1562657908912,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31691,"status":"OK","type":"GROUP","updateTime":1562657492999,"latestMsgFromUserId":0,"latestMsgId":0,"latestMsgCreatedDate":0,"isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152417,"status":"OK","type":"SINGLE","updateTime":1562656906626,"latestMsgFromUserId":152424,"latestMsgId":55,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1562656906626,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31656,"status":"OK","type":"GROUP","updateTime":1561546050734,"latestMsgFromUserId":152413,"latestMsgId":10,"latestMsgType":"GROUP_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cc801edc922871c5b5b1766\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1 Good morning！\\\",\\\"homeWorkCreator\\\":\\\"任我行\\\",\\\"homeWorkDate\\\":\\\"周二 16:06\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cc801edc922871c5b5b1766&authorId=152413&shareName=Starter Unit 1 Good morning！\\\"}\"}","latestMsgCreatedDate":1561603985536,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152416,"status":"OK","type":"SINGLE","updateTime":1561358450448,"latestMsgFromUserId":152416,"latestMsgId":28,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"我","latestMsgCreatedDate":1561358450448,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31632,"status":"OK","type":"GROUP","updateTime":1561104097973,"latestMsgFromUserId":152424,"latestMsgId":21,"latestMsgType":"GROUP_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1561104097973,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31618,"status":"OK","type":"GROUP","updateTime":1561104015131,"latestMsgFromUserId":152414,"latestMsgId":251,"latestMsgType":"GROUP_TEXT","latestMsgContent":"as ","latestMsgCreatedDate":1565658525338,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31617,"status":"OK","type":"GROUP","updateTime":1560495425077,"latestMsgFromUserId":152424,"latestMsgId":4,"latestMsgType":"GROUP_TEXT","latestMsgContent":"2222","latestMsgCreatedDate":1560495425077,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152415,"status":"OK","type":"SINGLE","updateTime":1560495399972,"latestMsgFromUserId":152424,"latestMsgId":40,"latestMsgType":"SINGLE_TEXT","latestMsgContent":"Eoeeke","latestMsgCreatedDate":1561104097973,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31264,"status":"OK","type":"GROUP","updateTime":1560495327090,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"GROUP_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327090,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31613,"status":"OK","type":"GROUP","updateTime":1560495262764,"latestMsgFromUserId":152571,"latestMsgId":29,"latestMsgType":"GROUP_AUDIO","latestMsgContent":"{\"hasread\":0,\"localpath\":\"/storage/emulated/0/record/20190625103536.amr\",\"serverpath\":\"http://xhfs4.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190625/bab062bf637c4564a5e2cc0e651e36d5.amr\",\"voicelength\":3}","latestMsgCreatedDate":1561430137416,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152413,"status":"OK","type":"SINGLE","updateTime":1560495022551,"latestMsgFromUserId":152424,"latestMsgId":4,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327668,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152423,"status":"OK","type":"SINGLE","updateTime":1560492912894,"latestMsgFromUserId":152424,"latestMsgId":11,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327150,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":31566,"status":"OK","type":"GROUP","updateTime":1559616588733,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"GROUP_TEXT","latestMsgContent":"111","latestMsgCreatedDate":1559616588733,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":151353,"status":"OK","type":"SINGLE","updateTime":1559111677799,"latestMsgFromUserId":152424,"latestMsgId":2,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\"}\"}","latestMsgCreatedDate":1559111677784,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false},{"sessionId":152569,"status":"OK","type":"SINGLE","updateTime":1559034066587,"latestMsgFromUserId":152424,"latestMsgId":16,"latestMsgType":"SINGLE_APP","latestMsgContent":"{\"shareType\":\"HOME_WORK_NEW\",\"content\":\"{\\\"homeWorkId\\\":\\\"5cadb462c9228749ee7d24d0\\\",\\\"homeWorkTitle\\\":\\\"Starter Unit 1-Unit 3\\\",\\\"homeWorkCreator\\\":\\\"张翠山\\\",\\\"homeWorkDate\\\":\\\"周三 17:16\\\",\\\"dataUri\\\":\\\"xhyunzuoye://com.xh.acldtch/acldtch?type=HOME_WORK_NEW&shareId=5cadb462c9228749ee7d24d0&authorId=152424&shareName=Starter Unit 1-Unit 3\\\"}\"}","latestMsgCreatedDate":1560495327626,"latestMsgStatus":"OK","latestMsgExtend":"","isTop":0,"topSortTime":0,"isAssisting":false,"isPassive":false,"isClosed":false}]
         */

        private long lastTime;
        private List<SessionsBean> sessions;

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }

        public List<SessionsBean> getSessions() {
            return sessions;
        }

        public void setSessions(List<SessionsBean> sessions) {
            this.sessions = sessions;
        }

        public static class SessionsBean {
            /**
             * sessionId : 152425
             * status : OK
             * type : SINGLE
             * updateTime : 1565938242667
             * latestMsgFromUserId : 152425
             * latestMsgId : 64
             * latestMsgType : SINGLE_IMAGE
             * latestMsgContent : {"img_height":0,"img_width":0,"localimg_url":"/storage/emulated/0/Tencent/QQfile_recv/DE923958-4E9F-4AC8-A73C-FE141473EC70.png","serverimg_url":"http://xhfs2.oss-cn-hangzhou.aliyuncs.com/CA107011/arespunc/20190816/f56f25a10e3440259eb1888d05edb1ff.PNG"}
             * latestMsgCreatedDate : 1565938242667
             * latestMsgStatus : OK
             * latestMsgExtend :
             * isTop : 0
             * topSortTime : 0
             * isAssisting : false
             * isPassive : false
             * isClosed : false
             */

            private int sessionId;
            private String status;
            private String type;
            private long updateTime;
            private int latestMsgFromUserId;
            private int latestMsgId;
            private String latestMsgType;
            private String latestMsgContent;
            private long latestMsgCreatedDate;
            private String latestMsgStatus;
            private String latestMsgExtend;
            private int isTop;
            private long topSortTime;
            private boolean isAssisting;
            private boolean isPassive;
            private boolean isClosed;

            public int getSessionId() {
                return sessionId;
            }

            public void setSessionId(int sessionId) {
                this.sessionId = sessionId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getLatestMsgFromUserId() {
                return latestMsgFromUserId;
            }

            public void setLatestMsgFromUserId(int latestMsgFromUserId) {
                this.latestMsgFromUserId = latestMsgFromUserId;
            }

            public int getLatestMsgId() {
                return latestMsgId;
            }

            public void setLatestMsgId(int latestMsgId) {
                this.latestMsgId = latestMsgId;
            }

            public String getLatestMsgType() {
                return latestMsgType;
            }

            public void setLatestMsgType(String latestMsgType) {
                this.latestMsgType = latestMsgType;
            }

            public String getLatestMsgContent() {
                return latestMsgContent;
            }

            public void setLatestMsgContent(String latestMsgContent) {
                this.latestMsgContent = latestMsgContent;
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

            public int getIsTop() {
                return isTop;
            }

            public void setIsTop(int isTop) {
                this.isTop = isTop;
            }

            public long getTopSortTime() {
                return topSortTime;
            }

            public void setTopSortTime(long topSortTime) {
                this.topSortTime = topSortTime;
            }

            public boolean isIsAssisting() {
                return isAssisting;
            }

            public void setIsAssisting(boolean isAssisting) {
                this.isAssisting = isAssisting;
            }

            public boolean isIsPassive() {
                return isPassive;
            }

            public void setIsPassive(boolean isPassive) {
                this.isPassive = isPassive;
            }

            public boolean isIsClosed() {
                return isClosed;
            }

            public void setIsClosed(boolean isClosed) {
                this.isClosed = isClosed;
            }
        }
    }
}

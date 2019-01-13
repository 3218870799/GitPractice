package com.xqc.util.weixinpay;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.security.MessageDigest;
import java.util.*;

/**

 * @author sunzhicheng
 * Created by cheng on 2016-5-25.
 */
/**
 * 
 * @author xqc
 * @data 2019��1��13��
 * Description:Ϊ����ǰ�Ĳ�����������װ��
 * ΢��֧���ӿڲ�����װʵ���ࣻ
 * ���ݣ�https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
 *  �� ��https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1
 *  ��������Щ����Ϊ���
 */
public class WeixinPayApiImpl {
    private Map<String, Object> map = null;
    private List<String> requiredList = null;
    private final String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private String key = "";
    /**
     * ��ȡ΢�Žӿڵ�ַ
     * @return
     */
    public String getUrl() {
        return url;
    }


    //�˱���û��ʵ�ʵ�ʹ�õ�������Ϊ�˱���ʱ���㶨λ���Ƿ�©������������
    private String appid = null;//1   �����˺�ID
    private String mch_id = null;//1   �̻���
    private String sub_appid = null;//���̻������˺�ID
    private String sub_mch_id = null;//1   ���̻���
    private String device_info = null;//�豸��
    private String nonce_str = null;//1   ����ַ���
    private String sign = null;//1   ǩ��
    private String body = null;//1   ��Ʒ����
    private String detail = null;//��Ʒ����
    private String attach = null;//��������
    private String out_trade_no = null;//1�̻�������
    private String fee_type = null;//��������
    private Integer total_fee = null;//1�ܽ��
    private String spbill_create_ip = null;//1�ն�IP
    private String time_start = null;//������ʼʱ��
    private String time_expire = null;//���׽���ʱ��
    private String goods_tag = null;//��Ʒ���
    private String notify_url = null;//1֪ͨ��ַ
    private String trade_type = null;//1��������
    private String product_id = null;//��ƷID
    private String limit_pay = null;//ָ��֧����ʽ
    private String openid = null;//�û���ʶ
    private String sub_openid = null;//�û��ӱ�ʶ

    /**
     * ���� �����˺�ID
     * ����wxd678efh567hg6787
     * ˵����΢�ŷ���Ĺ����˺�ID����ҵ��corpid��Ϊ��appId��
     *
     * @param appid
     */
    public void setAppid(String appid) {
        if(null!=appid){
            this.map.put("appid", appid);
        }
        this.appid = appid;
    }
    /**
     * ���� �̻���
     * ����1230000109
     * ˵����΢��֧��������̻���
     *
     * @param mch_id
     */
    public void setMch_id(String mch_id) {
        if(null!=mch_id){
            this.map.put("mch_id", mch_id);
        }
        this.mch_id = mch_id;
    }
    /**
     * ���̻������˺�ID
     * ����wxd678efh567hg6787
     * ˵����΢�ŷ�������̻������˺�ID��������֧����ɺ��ȡsub_openid��˲����ش���
     *
     * @param sub_appid
     */
    public void setSub_appid(String sub_appid) {
        if(null!=sub_appid){
            this.map.put("sub_appid", sub_appid);
        }
        this.sub_appid = sub_appid;
    }
    /**
     * ���� ���̻���
     * ����1230000109
     * ˵����΢��֧����������̻���
     *
     * @param sub_mch_id
     */
    public void setSub_mch_id(String sub_mch_id) {
        if(null!=sub_mch_id){
            this.map.put("sub_mch_id", sub_mch_id);
        }
        this.sub_mch_id = sub_mch_id;
    }
    /**
     * �豸��
     * ����013467007045764
     * ˵�����ն��豸��(�ŵ�Ż������豸ID)��ע�⣺PC��ҳ���ں���֧���봫"WEB"
     *
     * @param device_info
     */
    public void setDevice_info(String device_info) {
        if(null!=device_info){
            this.map.put("device_info", device_info);
        }
        this.device_info = device_info;
    }
    /**
     * ���� ����ַ���
     * ����5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * ˵��������ַ�����������32λ��https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
     * Ĭ��ֵ��30λ������A-Z,0-9��ɵ������
     * @param nonce_str
     */
    public void setNonce_str(String nonce_str) {
        if(null!=nonce_str){
            this.map.put("nonce_str", nonce_str);
        }
        this.nonce_str = nonce_str;
    }
    /**
     * ���� ǩ���������ֶ���ֵ������ʱ���Զ����㲢��ֵ��
     * ����C380BEC2BFD727A4B6845133519F3AD6
     * ˵����ǩ������� https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
     * Ĭ��ֵ������ʱ������Ӧ���㷨�Զ����м������
     * @param sign
     */
    public void setSign(String sign) {
        if(null!=sign){
            this.map.put("sign", sign);
        }
        this.sign = sign;
    }
    /**
     * ���� ��Ʒ����
     * ����Ipad mini  16G  ��ɫ
     * ˵��:��Ʒ��֧������Ҫ����
     *
     * @param body
     */
    public void setBody(String body) {
        if(null!=body){
            this.map.put("body", body);
        }
        this.body = body;
    }
    /**
     * ��Ʒ����
     * ����Ipad mini  16G  ��ɫ
     * ˵��:��Ʒ������ϸ�б�
     *
     * @param detail
     */
    public void setDetail(String detail) {
        if(null!=detail){
            this.map.put("detail", detail);
        }
        this.detail = detail;
    }
    /**
     * ��������
     * �������ڷֵ�
     * ˵�����������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ����ֶ���Ҫ�����̻�Я���������Զ�������
     *
     * @param attach
     */
    public void setAttach(String attach) {
        if(null!=attach){
            this.map.put("attach", attach);
        }
        this.attach = attach;
    }
    /**
     * ���� �̻�������
     * ����20150806125346
     * ˵�����̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ,��
     * ����˵�� https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param out_trade_no
     */
    public void setOut_trade_no(String out_trade_no) {
        if(null!=out_trade_no){
            this.map.put("out_trade_no", out_trade_no);
        }
        this.out_trade_no = out_trade_no;
    }
    /**
     * ��������  Ĭ��Ϊ��CNY �����
     * ����CNY
     * ˵��������ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY
     * ������� https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param fee_type
     */
    public void setFee_type(String fee_type) {
        if(null!=fee_type){
            this.map.put("fee_type", fee_type);
        }
        this.fee_type = fee_type;
    }
    /**
     * ���� �ܽ��������0 ��λ����
     * ����888��8Ԫ8��8�֡�
     * ˵���������ܽ���λΪ��
     *
     * @param total_fee
     */
    public void setTotal_fee(Integer total_fee) {
        if(null!=total_fee&&total_fee>0){
            this.map.put("total_fee", total_fee);
        }
        this.total_fee = total_fee;
    }
    /**
     * ���� �ն�IP
     * ����	123.12.12.123
     * ˵����APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP��
     * Ĭ��ֵ����������IP
     * @param spbill_create_ip
     */
    public void setSpbill_create_ip(String spbill_create_ip) {
        if(null!=spbill_create_ip){
            this.map.put("spbill_create_ip", spbill_create_ip);
        }
        this.spbill_create_ip = spbill_create_ip;
    }
    /**
     * ������ʼʱ��
     * ����20091225091010
     * ˵������������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010��
     * ��ϸ��https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param time_start
     */
    public void setTime_start(String time_start) {
        if(null!=time_start){
            this.map.put("time_start", time_start);
        }
        this.time_start = time_start;
    }
    /**
     * ���׽���ʱ��
     * ����20091225091010
     * ˵������������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010��
     * ��ϸ��https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param time_expire
     */
    public void setTime_expire(String time_expire) {
        if(null!=time_expire){
            this.map.put("time_expire", time_expire);
        }
        this.time_expire = time_expire;
    }
    /**
     * ��Ʒ���
     * ����WXG
     * ˵������Ʒ��ǣ�����ȯ�������Żݹ��ܵĲ���
     * ˵�������https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_1
     *
     * @param goods_tag
     */
    public void setGoods_tag(String goods_tag) {
        if(null!=goods_tag){
            this.map.put("goods_tag", goods_tag);
        }
        this.goods_tag = goods_tag;
    }
    /**
     * ���� ֪ͨ��ַ���ص���ַ��
     * ����http://www.weixin.qq.com/wxpay/pay.php
     * ˵��������΢��֧���첽֪ͨ�ص���ַ��֪ͨurl����Ϊֱ�ӿɷ��ʵ�url������Я��������
     *
     * @param notify_url
     */
    public void setNotify_url(String notify_url) {
        if(null!=notify_url){
            this.map.put("notify_url", notify_url);
        }
        this.notify_url = notify_url;
    }
    /**
     * ���� ��������
     * ����NATIVE
     * ˵����ȡֵ���£�JSAPI��NATIVE��APP
     * ��ϸ˵����https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param trade_type
     */
    public void setTrade_type(String trade_type) {
        if(null!=trade_type){
            this.map.put("trade_type", trade_type);
        }
        this.trade_type = trade_type;
    }
    /**
     * ��ƷID
     * ����12235413214070356458058
     * ˵����trade_type=NATIVE���˲����ش�����idΪ��ά���а�������ƷID���̻����ж��塣
     *
     * @param product_id
     */
    public void setProduct_id(String product_id) {
        if(null!=product_id){
            this.map.put("product_id", product_id);
        }
        this.product_id = product_id;
    }
    /**
     * ָ��֧����ʽ
     * ����no_credit
     * ˵����no_credit--ָ������ʹ�����ÿ�֧��
     *
     * @param limit_pay
     */
    public void setLimit_pay(String limit_pay) {
        if(null!=limit_pay){
            this.map.put("limit_pay", limit_pay);
        }
        this.limit_pay = limit_pay;
    }
    /**
     * �û���ʶ
     * ����oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * ˵����trade_type=JSAPI���˲����ش����û����̻�appid�µ�Ψһ��ʶ��openid��λ�ȡ���ɲο�https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_4
     * ��ҵ����ʹ��http://qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3
     * ��ȡ��ҵ���ڳ�Աuserid���ٵ���http://qydev.weixin.qq.com/wiki/index.php?title=Userid%E4%B8%8Eopenid%E4%BA%92%E6%8D%A2%E6%8E%A5%E5%8F%A3
     * ����ת��
     *
     * @param openid
     */
    public void setOpenid(String openid) {
        if(null!=openid){
            this.map.put("openid", openid);
        }
        this.openid = openid;
    }
    /**
     * �û��ӱ�ʶ
     * ����oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * ˵����trade_type=JSAPI���˲����ش����û����̻�appid�µ�Ψһ��ʶ��openid��λ�ȡ���ɲο�https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_4
     * ��ҵ����ʹ��http://qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3
     * ��ȡ��ҵ���ڳ�Աuserid���ٵ���http://qydev.weixin.qq.com/wiki/index.php?title=Userid%E4%B8%8Eopenid%E4%BA%92%E6%8D%A2%E6%8E%A5%E5%8F%A3
     * ����ת��
     *
     * @param sub_openid
     */
    public void setSub_openid(String sub_openid) {
        if(null!=sub_openid) {
            this.map.put("sub_openid", sub_openid);
        }
        this.sub_openid = sub_openid;
    }

    /**
     * ������Ϊ�յ���ָ����list�в��������list
     * @return
     */
    private List<String> requiredParam() {
        //���岻��Ϊ�յ��ֶ�
        List<String> list = new ArrayList<String>();
        list.add("appid");
        list.add("mch_id");
        list.add("sub_mch_id");
        list.add("nonce_str");
        list.add("sign");
        list.add("body");
        list.add("out_trade_no");
        list.add("total_fee");
        list.add("spbill_create_ip");
        list.add("notify_url");
        list.add("trade_type");
        return list;
    }

    /**
     * appid,mch_id,nonce_str,sign,body,out_trade_no,total_fee,spbill_create_ip,notify_url,trade_type
     * ����Ϊ�ջ�NULL�����set����˵��
     * ��������Ĭ��Ϊnull
     * �ĵ���ַ��https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1
     * @param key  Ϊ�̻���key��API�ܳס�
     */
    public WeixinPayApiImpl(String key) {
        super();
        this.key=key;
        map = new HashMap<String, Object>();
       List<String> tmpList = requiredParam();
        if (tmpList.size() > 0) {
            this.requiredList = tmpList;
        } else {
            this.requiredList = null;
        }
    }


    /**
     * �����в�Ϊnull�����Է�װ��map������
     */
    public Map<String, Object> getMap() throws Exception {
        this.setDefaultValue();
        if(null!=this.requiredList) {
                for (String s : this.requiredList) {//���Ϊ�յ�ֵ�Ƿ����
                    if (!this.map.containsKey(s)) {//����δ�����ı�����
                        throw new Exception(s + "--Ϊ�������������" + this.requiredList + " �Ƿ���д��ȷ��");
                    }
                    if ("total_fee".equals(s)) {//���
                        Object o =  this.map.get(s);
                        int total = (Integer) o;
                        if (total <= 0) {
                            throw new Exception(s + "--Ϊ������ұ������0��");
                        }
                    }
                }
        }
        return this.map;
    }

    /**
     * ��xmlRootElementNameΪnill��û��Root�ڵ�
     *
     * @param xmlRootElementName ����Ϊnull
     * @return
     */
    public String getXml(String xmlRootElementName) throws Exception{
       Map<String, Object> tmap = getMap();
        StringBuffer sbf = null;
        sbf = new StringBuffer();
        if (null != xmlRootElementName) {
            sbf.append("<" + xmlRootElementName + ">");
        }
            for (String s : tmap.keySet()) {
                Object tmp = tmap.get(s);
                    sbf.append("<" + s + ">" + tmp + "</" + s + ">");
            }
        if (null != xmlRootElementName) {
            sbf.append("</" + xmlRootElementName + ">");
        }
        try {
            return new String(sbf.toString().getBytes(),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * MD5���� ����32λmd5��
     */
    private String string2MD5(String str){
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf).toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ΢��֧��ǩ���㷨sign
     */
    private String getSign() {
        StringBuffer sb = new StringBuffer();
        String[] keyArr = (String[]) this.map.keySet().toArray(new String[this.map.keySet().size()]);//��ȡmap�е�keyתΪarray
        Arrays.sort(keyArr);//��array����
        for (int i = 0, size = keyArr.length; i < size; ++i) {
            if ("sign".equals(keyArr[i])) {
                continue;
            }
            sb.append(keyArr[i] + "=" + this.map.get(keyArr[i]) + "&");
        }
        sb.append("key=" + key);
        String sign = string2MD5(sb.toString());
        return sign;
    }

    /**
     * ������[A-Z,0-9]���ɵ�����ַ���
     * @param length  �����ɵ��ַ�������
     * @return
     */
    private String getRandomString(int length){
        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i){
            int number = random.nextInt(2);
            long result = 0;

            switch(number){
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:

                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * ��ȡ����IP��ַ��������
     * @return IP
     */
    private static String getLocalIp() {
        String ip = null;
        Enumeration allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();
                for (InterfaceAddress add : InterfaceAddress) {
                    InetAddress Ip = add.getAddress();
                    if (Ip != null && Ip instanceof Inet4Address) {
                        ip = Ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ip;
    }


    /**
     * ����Ĭ��ֵ
     */
    private void setDefaultValue(){
        if(null == this.map.get("nonce_str")){//�����
            this.setNonce_str(this.getRandomString(30));
        }
        if(null == this.map.get("spbill_create_ip")){//�ն�IP
            this.setSpbill_create_ip(this.getLocalIp());
        }
        if(null == this.map.get("sign")){//ǩ��
            this.setSign(this.getSign());
        }
    }
}

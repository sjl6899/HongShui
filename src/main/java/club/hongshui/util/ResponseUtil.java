package club.hongshui.util;


import java.util.List;

/**+
 * 数据返回规范：状态码、数据、错误信息，
 * 把要返回的数据放入下面的三个方法中即可，分别对应正确、异常和自定义
 */
public class ResponseUtil {

    //状态码
    private int code;
    //数据
    private Object dataList;
    //错误信息
    private String msg;
    //执行结果，true为执行成功 false为执行失败
    private boolean flag;

    //序列化必须要有get/set方法

    public int getCode() {
        return code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getDataList() {
        return dataList;
    }

    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseUtil() {
    }
    //正常情况下将数据进行赋值
    public ResponseUtil(Object dataList) {
        this.dataList = dataList;
    }
    public ResponseUtil(int code, Object dataList,boolean flag) {
        this.code = code;
        this.dataList = dataList;
        this.flag=flag;
    }

    //异常情况返回错误信息

    public ResponseUtil(int code, String msg,boolean flag) {
        this.code = code;
        this.msg = msg;
        this.flag=flag;
    }

    public ResponseUtil(int code, Object dataList, String msg,boolean flag) {
        this.code = code;
        this.dataList = dataList;
        this.msg = msg;
        this.flag=flag;
    }

    //正常情况下的返回
    public static club.hongshui.util.ResponseUtil bulidSuccess(Object dataList,boolean flag, String msg){
        return new club.hongshui.util.ResponseUtil(200,dataList,"success",true);
    }

    public static club.hongshui.util.ResponseUtil Success(Object dataList){
        return new club.hongshui.util.ResponseUtil(200,dataList,true);
    }
    //异常情况下的返回后
    public static club.hongshui.util.ResponseUtil bulidError(String msg){
        return new club.hongshui.util.ResponseUtil(500,"",msg,false);
    }
    //自定义状态码和返回信息
    public static club.hongshui.util.ResponseUtil bulidCoustmer(Object dataList){
        return new club.hongshui.util.ResponseUtil(dataList);
    }
}

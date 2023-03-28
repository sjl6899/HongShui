package club.hongshui.util;


/**+
 * 数据返回规范：状态码、数据、错误信息，
 * 把要返回的数据放入下面的三个方法中即可，分别对应正确、异常和自定义
 */
public class ResponseUtil {

    //状态码
    private int code;
    //数据
    private Object data;
    //错误信息
    private String msg;
    //序列化必须要有get/set方法

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    public ResponseUtil(int code, Object data) {
        this.code = code;
        this.data = data;
    }
    //异常情况返回错误信息

    public ResponseUtil(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseUtil(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    //正常情况下的返回
    public static club.hongshui.util.ResponseUtil bulidSuccess(Object data){
        return new club.hongshui.util.ResponseUtil(200,data);
    }
    //异常情况下的返回后
    public static club.hongshui.util.ResponseUtil bulidError(String msg){
        return new club.hongshui.util.ResponseUtil(500,"",msg);
    }
    //自定义状态码和返回信息
    public static club.hongshui.util.ResponseUtil bulidCoustmer(int code, Object data, String msg){
        return new club.hongshui.util.ResponseUtil(code,data,msg);
    }
}

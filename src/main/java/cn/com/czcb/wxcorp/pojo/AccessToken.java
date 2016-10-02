package cn.com.czcb.wxcorp.pojo;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2016-10-02 9:15:7
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class AccessToken {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }
     public String getAccessToken() {
         return accessToken;
     }

    public void setExpiresIn(int expiresIn) {
         this.expiresIn = expiresIn;
     }
     public int getExpiresIn() {
         return expiresIn;
     }

}

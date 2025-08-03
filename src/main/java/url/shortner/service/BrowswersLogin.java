package url.shortner.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


    @Component

    public class BrowswersLogin {
        private final Map<String, String> map = new HashMap();

        public void setLoginDetails(String ip, String agent) {
            map.put(ip, agent);

        }

        public Map<String, String> getLoginDetails() {

            return map;
        }
    }

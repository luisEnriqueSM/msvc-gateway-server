package com.luis.springcloud.app.gateway.filters.factory.configuration;

public class ConfigurationCookie {

        private String name;
        private String value;
        private String message;
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }

}

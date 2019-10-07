package com.example.ghar;

public class userprofile {
        public String fn;
        public String un;
        public String eml;

        public userprofile(){

        }

        public userprofile(String fn, String un, String eml) {
            this.fn = fn;
            this.un = un;
            this.eml = eml;
        }

        public  String getFn() {
            return fn;
        }

        public void setFn(String fn) {
            this.fn = fn;
        }

        public String getUn() {
            return un;
        }

        public void setUn(String un) {
            this.un = un;
        }

        public String getEml() {
            return eml;
        }

        public void setEml(String eml) {
            this.eml = eml;
        }
    }



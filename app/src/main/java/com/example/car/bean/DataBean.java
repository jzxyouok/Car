package com.example.car.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11355 on 2016/5/26.
 */
public class DataBean {


    /**
     * id : 7
     * cover_image : http://www.bz55.com/uploads1/allimg/100829/1_100829103300_8.jpg
     * title : 玛莎拉蒂即将上市，售价10万
     * idn : 4
     * image_list : null
     * type : 3
     */

    private int id;
    private String cover_image;
    private String title;
    private int idn;
    private Object image_list;
    private int type;

    public static List<DataBean> arrayDataBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DataBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }
    private List<DataBean> YaoWenBean;
    public List<DataBean> getYaoWenBean(){
        return YaoWenBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdn() {
        return idn;
    }

    public void setIdn(int idn) {
        this.idn = idn;
    }

    public Object getImage_list() {
        return image_list;
    }

    public void setImage_list(Object image_list) {
        this.image_list = image_list;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package com.bwie.redchildren.bean;

import java.util.List;

public class ChildrenBean {
            private String attriCf;
            private String bigPicture;
            private String categoryGoto;
            private int clickCount;
            private String description;
            private String dirName;
            private String gotoApp;
            private String gotoWap;
            private int id;
            private String ifShowShoppingCart;
            private String imgApp;
            private String imgWap;
            private int level;
            private int parentId;
            private String pcCi;
            private String seoCf;
            private int sort;
            /**
             * advts : []
             * attriCf :
             * bigPicture : 0
             * categoryGoto : 2
             * children : []
             * clickCount : 0
             * description :
             * dirName : 一段奶粉
             * gotoApp :
             * gotoWap :
             * id : 100007005
             * ifShowShoppingCart : 0
             * imgApp : http://sale.suning.com/act/20140808/milk/1.png
             * imgWap : http://sale.suning.com/act/20140808/milk/1.png
             * level : 3
             * parentId : 100007004
             * pcCi : 313006
             * seoCf :
             * sort : 9
             */

            private List<ChildrenBean> children;
    private boolean header;

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }
            public String getAttriCf() {
                return attriCf;
            }

            public void setAttriCf(String attriCf) {
                this.attriCf = attriCf;
            }

            public String getBigPicture() {
                return bigPicture;
            }

            public void setBigPicture(String bigPicture) {
                this.bigPicture = bigPicture;
            }

            public String getCategoryGoto() {
                return categoryGoto;
            }

            public void setCategoryGoto(String categoryGoto) {
                this.categoryGoto = categoryGoto;
            }

            public int getClickCount() {
                return clickCount;
            }

            public void setClickCount(int clickCount) {
                this.clickCount = clickCount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDirName() {
                return dirName;
            }

            public void setDirName(String dirName) {
                this.dirName = dirName;
            }

            public String getGotoApp() {
                return gotoApp;
            }

            public void setGotoApp(String gotoApp) {
                this.gotoApp = gotoApp;
            }

            public String getGotoWap() {
                return gotoWap;
            }

            public void setGotoWap(String gotoWap) {
                this.gotoWap = gotoWap;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIfShowShoppingCart() {
                return ifShowShoppingCart;
            }

            public void setIfShowShoppingCart(String ifShowShoppingCart) {
                this.ifShowShoppingCart = ifShowShoppingCart;
            }

            public String getImgApp() {
                return imgApp;
            }

            public void setImgApp(String imgApp) {
                this.imgApp = imgApp;
            }

            public String getImgWap() {
                return imgWap;
            }

            public void setImgWap(String imgWap) {
                this.imgWap = imgWap;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getPcCi() {
                return pcCi;
            }

            public void setPcCi(String pcCi) {
                this.pcCi = pcCi;
            }

            public String getSeoCf() {
                return seoCf;
            }

            public void setSeoCf(String seoCf) {
                this.seoCf = seoCf;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }


            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

    @Override
    public String toString() {
        return "ChildrenBean{" +
                "attriCf='" + attriCf + '\'' +
                ", bigPicture='" + bigPicture + '\'' +
                ", categoryGoto='" + categoryGoto + '\'' +
                ", clickCount=" + clickCount +
                ", description='" + description + '\'' +
                ", dirName='" + dirName + '\'' +
                ", gotoApp='" + gotoApp + '\'' +
                ", gotoWap='" + gotoWap + '\'' +
                ", id=" + id +
                ", ifShowShoppingCart='" + ifShowShoppingCart + '\'' +
                ", imgApp='" + imgApp + '\'' +
                ", imgWap='" + imgWap + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", pcCi='" + pcCi + '\'' +
                ", seoCf='" + seoCf + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }
}
package com.shivamkibhu.onboardwalkthrough;

public class Page {
    private int imagePage = 0,
            imgWidth = 100, imgHeight = 100,
            titleSize = 0, descSize = 0,
            imgTop = 0, imgRight = 0, imgBottom = 0, imgLeft = 0,
            titleTop = 0, titleRight = 0, titleBottom = 0, titleLeft = 0;

    private String titlePage, descriptionPage, backgroundPage, titleColor = "#000000", descriptionColor = "#000000";

    public Page(){}

    public Page(String title, String description, int img){
        this.titlePage = title;
        this.descriptionPage = description;
        this.imagePage = img;
    }

    public Page setBackgroundColor(String backgroundColor) {
        backgroundPage = backgroundColor;
        return this;
    }

    public Page setImage(int imagePage) {
        this.imagePage = imagePage;
        return this;
    }

    public Page setImageLayoutParams(int width, int height, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        imgWidth = width;
        imgHeight = height;
        imgTop = marginTop;
        imgRight = marginRight;
        imgBottom = marginBottom;
        imgLeft = marginLeft;

        return this;
    }

    public Page setTitle(String title) {
        this.titlePage = title;
        return this;
    }


    public Page setTitleColor(String color){
        titleColor = color;
        return this;
    }

    public Page setTitleSize(int size) {
        titleSize = size;
        return this;
    }


    public Page setDescription(String description) {
        descriptionPage = description;
        return this;
    }

    public Page setDescriptionColor(String color){
        descriptionColor = color;
        return this;
    }

    public Page setDescriptionSize(int size) {
        descSize = size;
        return this;
    }


    public Page setTitleContainerMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        titleTop = marginTop;
        titleRight = marginRight;
        titleBottom = marginBottom;
        titleLeft = marginLeft;

        return this;
    }

    public String getBackgroundPage() {
        return backgroundPage;
    }

    public int getImagePage() {
        return imagePage;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public int getDescSize() {
        return descSize;
    }

    public int getImgTop() {
        return imgTop;
    }

    public int getImgRight() {
        return imgRight;
    }

    public int getImgBottom() {
        return imgBottom;
    }

    public int getImgLeft() {
        return imgLeft;
    }

    public int getTitleTop() {
        return titleTop;
    }

    public int getTitleRight() {
        return titleRight;
    }

    public int getTitleBottom() {
        return titleBottom;
    }

    public int getTitleLeft() {
        return titleLeft;
    }

    public String getTitlePage() {
        return titlePage;
    }

    public String getDescriptionPage() {
        return descriptionPage;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public String getDescriptionColor() {
        return descriptionColor;
    }
}

package com.example.trabalho_final_pdm.model;

public class PixItem {
    private String name;
    private String type;
    private String key;
    private boolean favorite;
    private boolean selected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public static class PixItemBuilder{
        private String name;
        private String type;
        private String key;
        private boolean favorite;
        private boolean selected;

        public PixItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PixItemBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public PixItemBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public PixItemBuilder setFavorite(boolean favorite) {
            this.favorite = favorite;
            return this;
        }

        public PixItemBuilder setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }

        private PixItemBuilder(){}
        public static PixItemBuilder builder(){
            return new PixItemBuilder();
        }
        public PixItem build(){
            PixItem pixItem = new PixItem();
            pixItem.name = name;
            pixItem.type = type;
            pixItem.key = key;
            pixItem.favorite = favorite;
            pixItem.selected = selected;
            return pixItem;
        }
    }
}

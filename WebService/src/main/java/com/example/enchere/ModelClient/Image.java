package com.example.enchere.ModelClient;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "image")
public class Image {
    int idimage;
    String[] image;

    int idenchere;

    public Image(int idimage, String[] image, int idenchere) {
        this.idimage = idimage;
        this.image = image;
        this.idenchere = idenchere;
    }

    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public int getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(int idenchere) {
        this.idenchere = idenchere;
    }
}

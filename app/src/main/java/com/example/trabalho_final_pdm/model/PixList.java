package com.example.trabalho_final_pdm.model;

import java.util.Arrays;
import java.util.List;

public class PixList {
    public static List<PixItem> fakePixs(){
        return Arrays.asList(

            PixItem.PixItemBuilder.builder()
                    .setName("Thomas")
                    .setType("Telefone")
                    .setKey("(51) 99240-4040")
                    .setFavorite(false)
                    .build(),

            PixItem.PixItemBuilder.builder()
                    .setName("Thomas")
                    .setType("Telefone")
                    .setKey("(51) 99240-4040")
                    .setFavorite(true)
                    .build(),

            PixItem.PixItemBuilder.builder()
                    .setName("Thomas")
                    .setType("Telefone")
                    .setKey("(51) 99240-4040")
                    .setFavorite(false)
                    .build(),

            PixItem.PixItemBuilder.builder()
                    .setName("Thomas")
                    .setType("Telefone")
                    .setKey("(51) 99240-4040")
                    .setFavorite(true)
                    .build()
        );
    }
}

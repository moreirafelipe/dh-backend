package com.dh.pizzaria;

import com.dh.pizzaria.service.Cozinheiro;
import com.dh.pizzaria.service.impl.CozinheiroNoVeggie;
import com.dh.pizzaria.service.impl.CozinheiroVeggie;

public class Main {

    public static void main(String[] args) {
        Cozinheiro cozinheiroVeggie = new CozinheiroVeggie();
        Cozinheiro cozinheiroNoVeggie = new CozinheiroNoVeggie();

        cozinheiroVeggie.fazerPizza();
        cozinheiroNoVeggie.fazerPizza();
    }
}

package com.dh.pizzaria.service.impl;

import com.dh.pizzaria.service.Cozinheiro;

public class CozinheiroVeggie extends Cozinheiro {


    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando tomate e diferentes queijos");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("Adicionando queijos e tomate");

    }
}

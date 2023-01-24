package com.teste.finch.entities.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public enum TiposLanches {
	X_BACON,
    X_BURGUER,
    X_EGG,
    X_EGG_BACON;
	
	public static Collection<? extends Ingredientes> lanches (TiposLanches tipoLanches){
        switch (tipoLanches){
            case X_BACON:
                return Arrays.asList(Ingredientes.BACON, Ingredientes.HAMBURGUER, Ingredientes.QUEIJO);
            case X_BURGUER:
            	return Arrays.asList(Ingredientes.BACON, Ingredientes.HAMBURGUER, Ingredientes.QUEIJO);
            case X_EGG:
            	return Arrays.asList(Ingredientes.BACON, Ingredientes.HAMBURGUER, Ingredientes.QUEIJO);
            case X_EGG_BACON:
            	return Arrays.asList(Ingredientes.BACON, Ingredientes.HAMBURGUER, Ingredientes.QUEIJO);
            default:
                break;
        }
       return new ArrayList<Ingredientes>();
    }
}

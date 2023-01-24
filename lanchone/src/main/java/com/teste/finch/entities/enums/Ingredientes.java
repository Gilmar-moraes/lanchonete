package com.teste.finch.entities.enums;

public enum Ingredientes {

	 ALFACE,
	 BACON,
	 HAMBURGUER,
	 OVO,
	 QUEIJO;

	public static Double ingrediente (Ingredientes tipoIngrediente){
        switch (tipoIngrediente){
            case ALFACE:
                return 0.40;
            case BACON:
                return 2.00;
            case HAMBURGUER:
                return 3.00;
            case OVO:
                return 0.80;
            case QUEIJO:
                return 1.50;
            default:
                break;
        }
        return 0.0;
    }
}

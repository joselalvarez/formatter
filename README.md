#Formatter

Conjunto de utilidades básicas para serializar y deserializar objetos. 

##Tipos de objetos soportados

Todos los tipos primitivos y su clase equivalente:
- boolean, Boolean
- byte, Byte
- char, Character
- double, Double
- float, Float
- int, Integer
- long, Long
- short, Short

También soporta los tipos:
- java.util.String
- java.util.Date
- enum

##Clase "FormatterUtil"

Es la clase que contiene los métodos para serializar y deserializar los objetos. Es una clase estatica y no necesita ser instanciada.

Para serializar:

	FormatterUtil.format(type, object, config);
	FormatterUtil.format(type, object);
	
Existe una versión "null safe" de los métodos anteriores, en la que se puede indicar un valor por defecto para el caso que el objeto a serializar sea nulo:

	FormatterUtil.format(type, object, default, config);
	FormatterUtil.format(type, object, default);


Para deserializar:

    FormatterUtil.parse(type, source, config);
    FormatterUtil.parse(type, source);
    
De manera analoga al caso anterior existe una versión "null safe":

    FormatterUtil.parse(type, source, default, config);
    FormatterUtil.parse(type, source, default);	

##Proveedor de configuración

Las siguientes factorias permiten instanciar un objeto configurable para poder se usado en una serialización o deserialización:

Factoria por defecto:

	Format.config();

Factoria para un tipo especifico:	

	Format.config(type);

##Configuración:

    Format.config()
        .forType(type) // Tipo que queremos configurar
        .forDefault() // Para cualquier tipo								
        .withPattern(pattern)	// Patrón
        .withLocale(locale) // Localización
        .withTrueValue(value) // Valor "true"
        .withFalseValue(value) // Valor "false"
        .withBooleanValues(trueValue, falseValue) // 
        .withDecimalSeparator(separator) // Separador para los decimales
        .withGroupingSeparator(separator) // Separador para el agrupador
        .withNumberSeparators(decimal, grouping) //
        .withOnlyDate() //Solo fecha
        .withOnlyTime() //Solo la hora
        .withDateAndTime() //Fecha y hora
        .with(key, value) // clave, valor (Format.keys, Format.values)
        .without(key); //
        
##Ejemplos de uso

Serialización:

	FormatterUtil.format(Boolean.class, true) // "true"
	FormatterUtil.format(Boolean.class, true, Format.config().withBooleanValues("1", "0")) // "1"
	FormatterUtil.format(Double.class, 1000d, Format.config().withPattern("###,###.00").withNumberSeparators('\'', '.')); // "1.000'00"															
	FormatterUtil.format(Date.class, new Date(), Format.config().withPattern("dd/MM/yyyy hh:mm:ss"));

Deserialización:

	FormatterUtil.parse(Boolean.class, "false") // false
	FormatterUtil.parse(Boolean.class, "1", Format.config().withBooleanValues("1", "0")); // true
	FormatterUtil.parse(Float.class, "1.000'00", Format.config().withPattern("###,###.00").withNumberSeparators('\'', '.')); // 1000f
	FormatterUtil.parse(Date.class, "24/12/2020 12:05:35", Format.config().withPattern("dd/MM/yyyy hh:mm:ss")); //Thu Dec 24 00:05:35 CET 2020



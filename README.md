# MorseAPI
MeLi Challenge

# Descripción
La API traduce un texto con caracteres ASCII a morse y visceversa.

# Forma de uso

* Transformar texto con caracteres latinos a morse (cada caracter en morse es separado con un ' ' y cada palabra con dos ' ').

  * Mediante: curl -X POST "https://api-meli-translator.herokuapp.com/2Morse" -d '{"text": "HOLA MELI"}'


* Transformar morse a texto con caracteres latinos (las palabras se deben separar con dos ' ').

  * Mediante: curl -X POST "https://api-meli-translator.herokuapp.com/2Human" -d '{"text": ".... --- .-.. .-  -- . .-.. .."}'
  
- Ejemplo de uso

input

```JSON
{"text": ".... --- .-.. .-  -- . .-.. .."}
```

output
```JSON
{
  "code": 200,
  "response": "HOLA MELI"  
}
```
# Errores
Pueden generarse errores en caso de:
 * Caracteres inválidos en "text".

Por ejemplo:
 ```JSON
Para el texto en ASCII:
{"text": "HOLA MELI!"}
O en el caso de morse:
{"text": ".... --- .-.. .-  -- . .-.. ..a"}
```
Devolverá:
```JSON
{
  "code": 400,
  "response": "Algún caracter es inválido"  
}
```
Ya que el caracter '!' no se encuentra dentro de los caracteres ASCII utilizados, ni 'a' dentro de los caracteres que componen el código morse (ver Nota 1).

 * Caracteres morse inválidos en "text".
  Por ejemplo:
 ```JSON
{"text": "........ --- .-.. .-  -- . .-.. ..a"}
```
Devolverá:
```JSON
{
  "code": 400,
  "response": "No se reconoce el caracter [........]"  
}
```

# Notas
 1) Valores admitidos para caracteres latinos [A-Z,a-z,0-9], ' ' y '.'; el código morse debe estar compuesto sólo por los caracteres '.', '-' y ' '.)
 2) Alfabeto utilizado:

 |ASCII|Morse|ASCII|Morse
 |---|---|       ---|---|
 |"A",|".-"|"S",|"..."|
|"B",| "-..."  |"T",| "-"|
|"C",| "-.-."  |"U",| "..-"|
|"D",| "-.."   |"V",| "...-"  |
|"E",| "."     |"W",| ".--"   |
|"F",| "..-."  |"X",| "-..-"  |
|"G",| "--."   |"Y",| "-.--"  |
|"H",| "...."  |"Z",| "--.."  |
|"I",| ".."    |"0",| "-----" |
|"J",| ".---"  |"1",| ".----" |
|"K",| "-.-"   |"2",| "..---" |
|"L",| ".-.."  |"3",| "...--" |
|"M",| "--"    |"4",| "....-" |
|"N",| "-."    |"5",| "....." |
|"O",| "---"   |"6",| "-...." |
|"P",| ".--."  |"7",| "--..." |
|"Q",| "--.-"  |"8",| "---.." |
|"R",| ".-."   |"9",| "----." |
|".",| ".-.-.-"| " " | " " |

# Links
 * Swagger: https://api-meli-translator.herokuapp.com/swagger-ui.html

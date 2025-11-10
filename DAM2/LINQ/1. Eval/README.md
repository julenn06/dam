# 📚 GUÍA COMPLETA DE LINQ - RESUMEN PARA EXAMEN

## 📖 Índice
- [Operadores LINQ](#-operadores-linq)
  - [Any()](#any)
  - [All()](#all)
  - [Where()](#where)
  - [Count()](#count)
  - [Contains()](#contains)
  - [FirstOrDefault()](#firstordefault)
  - [OrderBy() / OrderByDescending()](#orderby--orderbyDescending)
  - [Max() y Min()](#max-y-min)
  - [Average()](#average)
  - [Sum()](#sum)
  - [Select()](#select)
  - [ToList() / ToArray()](#tolist--toarray)
- [Expresiones Lambda](#-expresiones-lambda)
- [Sintaxis LINQ](#-sintaxis-linq)
- [Ejemplos por Proyecto](#-ejemplos-por-proyecto)

---

## 🔧 OPERADORES LINQ

### Any()

**¿Qué hace?**
Verifica si **al menos un elemento** de la colección cumple una condición. Devuelve `bool`.

**Sintaxis:**
```csharp
bool resultado = coleccion.Any(x => condicion);
```

**Cuándo usarlo:**
- ✅ Para verificar si existe algún elemento que cumpla una condición
- ✅ Para validaciones rápidas (¿hay algo que...?)
- ✅ Mejor rendimiento que `Count() > 0` porque se detiene al encontrar el primero

**Ejemplos:**
```csharp
// ¿Hay algún número mayor que 100?
bool existe = numeros.Any(n => n > 100);

// ¿Hay algún perro que pese más de 36kg?
bool hayPerroPesado = pets.Any(p => p.Type == PetType.Dog && p.Weight >= 36);

// ¿Hay algún estudiante llamado Mikel mayor de 20 años?
bool existeMikel = students.Any(s => s.Name == "Mikel" && s.Age > 20);

// ¿Hay palabras que contengan "net"?
bool tieneNet = palabras.Any(p => p.Contains("net"));
```

---

### All()

**¿Qué hace?**
Verifica si **TODOS** los elementos de la colección cumplen una condición. Devuelve `bool`.

**Sintaxis:**
```csharp
bool resultado = coleccion.All(x => condicion);
```

**Cuándo usarlo:**
- ✅ Para validar que toda la colección cumple un requisito
- ✅ Para verificar condiciones estrictas en todos los elementos
- ✅ Para validaciones de datos

**Ejemplos:**
```csharp
// ¿Todos los caracteres de una palabra están en mayúsculas?
bool todoMayusculas = palabra.All(char.IsUpper);

// ¿Todos los números son pares?
bool todosPares = numeros.All(n => n % 2 == 0);

// ¿Todos los nombres contienen 'a'?
bool todosConA = nombres.All(n => n.Contains('a'));

// ¿Todos los números son positivos?
bool todosPositivos = numeros.All(n => n > 0);
```

**💡 Diferencia clave:**
- `Any()` → "¿Existe AL MENOS UNO?"
- `All()` → "¿Todos SIN EXCEPCIÓN?"

---

### Where()

**¿Qué hace?**
Filtra elementos de una colección que cumplen una condición. Devuelve `IEnumerable<T>`.

**Sintaxis:**
```csharp
var resultado = coleccion.Where(x => condicion);
```

**Cuándo usarlo:**
- ✅ Para filtrar elementos y obtener una nueva colección
- ✅ Cuando necesitas trabajar con múltiples elementos filtrados
- ✅ Para encadenar con otros operadores LINQ

**Ejemplos:**
```csharp
// Obtener solo números pares
var pares = numeros.Where(n => n % 2 == 0);

// Obtener perros que pesen más de 36kg
var perrosPesados = pets.Where(p => p.Type == PetType.Dog && p.Weight >= 36);

// Obtener personas mayores de edad
var adultos = personas.Where(p => p.Edad >= 18);

// Obtener productos sin stock
var sinStock = productos.Where(p => p.Stock == 0);

// Obtener estudiantes con nota > 6
var aprobados = estudiantes.Where(e => e.Nota > 6).ToList();
```

**💡 Importante:**
`Where()` no ejecuta la consulta hasta que iteras el resultado o usas `.ToList()` / `.ToArray()`.

---

### Count()

**¿Qué hace?**
Cuenta elementos de una colección (opcionalmente con condición). Devuelve `int`.

**Sintaxis:**
```csharp
int total = coleccion.Count();              // Cuenta todos
int cantidad = coleccion.Count(x => condicion);  // Cuenta los que cumplen
```

**Cuándo usarlo:**
- ✅ Para obtener la cantidad de elementos
- ✅ Para contar elementos que cumplen una condición
- ✅ Para estadísticas y reportes

**Ejemplos:**
```csharp
// Contar números pares
int pares = numeros.Count(n => n % 2 == 0);

// Contar libros con más de 300 páginas
int libroLargos = libros.Count(l => l.Paginas > 300);

// Contar personas menores de edad
int menores = personas.Count(p => p.Edad < 18);

// Contar productos sin stock
int sinStock = productos.Count(p => p.Stock == 0);

// Contar palabras que empiezan con vocal
int conVocal = palabras.Count(p => "aeiou".Contains(char.ToLower(p[0])));

// Contar todos los elementos
int total = lista.Count();
```

---

### Contains()

**¿Qué hace?**
Verifica si una colección contiene un **valor específico**. Devuelve `bool`.

**Sintaxis:**
```csharp
bool existe = coleccion.Contains(valor);
```

**Cuándo usarlo:**
- ✅ Para buscar valores directos en colecciones simples (int, string, char)
- ✅ Cuando buscas igualdad exacta, no condiciones complejas
- ✅ Más simple y directo que `Any()` para valores simples

**Ejemplos:**
```csharp
// ¿Existe el número 10?
bool existe = numeros.Contains(10);

// ¿Existe el título "LINQ"?
bool existeLINQ = titulos.Contains("LINQ");

// ¿Existe la letra 'A'?
bool existeA = letras.Contains('A');

// ¿Existe el ID 3?
bool existeId = ids.Contains(3);

// Verificar si una cadena contiene un carácter
bool tieneZ = "aeiou".Contains('z');
```

**💡 Diferencia con Any():**
- `Contains(valor)` → Busca un valor exacto en colecciones simples
- `Any(x => condicion)` → Busca con condiciones en objetos complejos

```csharp
// Contains - valor directo
numeros.Contains(10)

// Any - condición compleja
personas.Any(p => p.Nombre == "Luis")
```

---

### FirstOrDefault()

**¿Qué hace?**
Devuelve el **primer elemento** que cumple una condición, o `null`/valor por defecto si no encuentra nada.

**Sintaxis:**
```csharp
var resultado = coleccion.FirstOrDefault();                  // Primer elemento
var resultado = coleccion.FirstOrDefault(x => condicion);   // Primer elemento que cumple
```

**Cuándo usarlo:**
- ✅ Cuando necesitas un elemento específico, no una colección
- ✅ Para búsquedas donde esperas 0 o 1 resultado
- ✅ Cuando quieres evitar excepciones (vs `First()`)

**Ejemplos:**
```csharp
// Obtener la primera mascota con un ID específico
var mascota = pets.FirstOrDefault(p => p.Id == 5);

// Obtener el primer número mayor que 100
var numero = numeros.FirstOrDefault(n => n > 100);

// Obtener la primera persona menor de 18
var menor = personas.FirstOrDefault(p => p.Edad < 18);

// Primer elemento de la lista
var primero = lista.FirstOrDefault();
```

**⚠️ Importante:**
- Devuelve `null` para tipos referencia si no encuentra
- Devuelve valor por defecto (`0`, `false`, etc.) para tipos valor
- Siempre verifica si el resultado es `null`:

```csharp
var mascota = pets.FirstOrDefault(p => p.Id == id);
if (mascota != null)
{
    Console.WriteLine(mascota.Name);
}
// O usa el operador null-conditional
Console.WriteLine(mascota?.Name);
```

---

### OrderBy() / OrderByDescending()

**¿Qué hace?**
Ordena elementos en orden ascendente (`OrderBy`) o descendente (`OrderByDescending`). Devuelve `IOrderedEnumerable<T>`.

**Sintaxis:**
```csharp
// Sintaxis de Métodos
var ascendente = coleccion.OrderBy(x => x);
var descendente = coleccion.OrderByDescending(x => x);

// Sintaxis de Consulta
var ascendente = from x in coleccion
                 orderby x
                 select x;
                 
var descendente = from x in coleccion
                  orderby x descending
                  select x;
```

**Cuándo usarlo:**
- ✅ Para mostrar datos ordenados
- ✅ Antes de obtener el primer/último elemento
- ✅ Para ordenar por propiedades específicas

**Ejemplos:**
```csharp
// Ordenar números de menor a mayor
var ordenados = numeros.OrderBy(n => n);

// Ordenar números de mayor a menor
var ordenados = numeros.OrderByDescending(n => n);

// Ordenar nombres alfabéticamente
var ordenados = nombres.OrderBy(n => n);

// Ordenar personas por edad
var ordenados = personas.OrderBy(p => p.Edad);

// Ordenar productos por precio (descendente)
var caros = productos.OrderByDescending(p => p.Precio);

// Ordenar por longitud de string
var ordenados = palabras.OrderBy(p => p.Length);

// Sintaxis de consulta
var ordenados = from p in productos
                orderby p.Precio descending
                select p;
```

**💡 Ordenación múltiple:**
```csharp
// Primero por edad, luego por nombre
var ordenados = personas
    .OrderBy(p => p.Edad)
    .ThenBy(p => p.Nombre);
```

---

### Max() y Min()

**¿Qué hace?**
Devuelve el valor **máximo** (`Max`) o **mínimo** (`Min`) de una colección.

**Sintaxis:**
```csharp
var maximo = coleccion.Max();                   // Máximo directo
var maximo = coleccion.Max(x => x.Propiedad);  // Máximo de una propiedad

var minimo = coleccion.Min();                   // Mínimo directo
var minimo = coleccion.Min(x => x.Propiedad);  // Mínimo de una propiedad
```

**Cuándo usarlo:**
- ✅ Para encontrar valores extremos
- ✅ Para estadísticas y reportes
- ✅ Para comparaciones y validaciones

**Ejemplos:**
```csharp
// Número más grande y más pequeño
var maximo = numeros.Max();      // 89
var minimo = numeros.Min();      // 2

// Edad máxima y mínima
var mayor = personas.Max(p => p.Edad);
var menor = personas.Min(p => p.Edad);

// Precio más caro y más barato
var caro = productos.Max(p => p.Precio);
var barato = productos.Min(p => p.Precio);

// Palabra más larga (alfabéticamente)
var ultima = palabras.Max();
var primera = palabras.Min();

// Temperatura máxima y mínima
var maxTemp = temperaturas.Max();
var minTemp = temperaturas.Min();
```

**💡 Con strings:**
`Max()` y `Min()` en strings comparan alfabéticamente, no por longitud:
```csharp
var nombres = new[] { "Ana", "Zebra", "Carlos" };
var max = nombres.Max();  // "Zebra" (último alfabéticamente)
var min = nombres.Min();  // "Ana" (primero alfabéticamente)
```

---

### Average()

**¿Qué hace?**
Calcula el **promedio** (media aritmética) de valores numéricos. Devuelve `double`.

**Sintaxis:**
```csharp
double promedio = coleccion.Average();                   // Promedio directo
double promedio = coleccion.Average(x => x.Propiedad);  // Promedio de propiedad
```

**Cuándo usarlo:**
- ✅ Para calcular medias y estadísticas
- ✅ Para comparar valores contra un promedio
- ✅ Para análisis de datos

**Ejemplos:**
```csharp
// Promedio de calificaciones
double promedio = calificaciones.Average();

// Promedio de edades
double edadPromedio = personas.Average(p => p.Edad);

// Promedio de precios
double precioMedio = productos.Average(p => p.Precio);

// Promedio de longitud de palabras
double longitudMedia = palabras.Average(p => p.Length);

// Promedio de notas mayores a 6
var aprobados = estudiantes.Where(e => e.Nota > 6);
double promedioAprobados = aprobados.Average(e => e.Nota);

// Comparar con el promedio
var promedio = numeros.Average();
var mayoresQuePromedio = numeros.Where(n => n > promedio);
```

**💡 Cálculos comunes:**
```csharp
// 50% del promedio
var promedio = ingresos.Average();
var umbral = promedio * 0.5;
var bajos = ingresos.Where(i => i < umbral);
```

---

### Sum()

**¿Qué hace?**
Suma todos los valores de una colección. Devuelve el tipo numérico correspondiente.

**Sintaxis:**
```csharp
var suma = coleccion.Sum();                   // Suma todos
var suma = coleccion.Sum(x => x.Propiedad);  // Suma una propiedad
```

**Cuándo usarlo:**
- ✅ Para calcular totales
- ✅ Para sumar valores filtrados
- ✅ Para acumulaciones y agregaciones

**Ejemplos:**
```csharp
// Suma de todos los números
int total = numeros.Sum();

// Suma de números pares
var pares = numeros.Where(n => n % 2 == 0);
int sumaPares = pares.Sum();

// Suma de precios de productos en stock
var enStock = productos.Where(p => p.InStock);
decimal totalStock = enStock.Sum(p => p.Precio);

// Suma de salarios de empleados > 30 años
var mayores = empleados.Where(e => e.Edad > 30);
double totalSalarios = mayores.Sum(e => e.Salario);

// Suma de longitudes de palabras con 'a'
var conA = palabras.Where(p => p.Contains('a'));
int totalLongitud = conA.Sum(p => p.Length);

// Suma de temperaturas sobre el promedio
var promedio = temperaturas.Average();
var altas = temperaturas.Where(t => t > promedio);
double sumaAltas = altas.Sum();
```

---

### Select()

**¿Qué hace?**
Proyecta/transforma cada elemento de una colección en una nueva forma. Devuelve `IEnumerable<T>`.

**Sintaxis:**
```csharp
var resultado = coleccion.Select(x => transformacion);
```

**Cuándo usarlo:**
- ✅ Para extraer una propiedad específica
- ✅ Para transformar elementos
- ✅ Para crear objetos anónimos o nuevos tipos

**Ejemplos:**
```csharp
// Obtener solo los nombres
var nombres = personas.Select(p => p.Nombre);

// Obtener el doble de cada número
var dobles = numeros.Select(n => n * 2);

// Obtener solo los precios
var precios = productos.Select(p => p.Precio);

// Crear objetos anónimos
var datos = personas.Select(p => new 
{ 
    p.Nombre, 
    p.Edad, 
    EsMayor = p.Edad >= 18 
});

// Transformar a mayúsculas
var mayusculas = palabras.Select(p => p.ToUpper());

// Combinar con Where
var nombresAdultos = personas
    .Where(p => p.Edad >= 18)
    .Select(p => p.Nombre);
```

**💡 Select vs Where:**
- `Where()` → **Filtra** elementos (reduce la cantidad)
- `Select()` → **Transforma** elementos (mantiene la cantidad)

```csharp
var numeros = new[] { 1, 2, 3, 4, 5 };

// Where: filtra, devuelve [2, 4]
var pares = numeros.Where(n => n % 2 == 0);

// Select: transforma, devuelve [2, 4, 6, 8, 10]
var dobles = numeros.Select(n => n * 2);
```

---

### ToList() / ToArray()

**¿Qué hace?**
Convierte un `IEnumerable<T>` a `List<T>` o `Array`.

**Sintaxis:**
```csharp
List<T> lista = consulta.ToList();
T[] array = consulta.ToArray();
```

**Cuándo usarlo:**
- ✅ Para materializar una consulta LINQ (ejecutarla inmediatamente)
- ✅ Para almacenar resultados y reutilizarlos
- ✅ Cuando necesitas métodos específicos de `List<T>` (Add, Remove, etc.)
- ✅ Para evitar múltiples ejecuciones de la misma consulta

**Ejemplos:**
```csharp
// Sin ToList() - no se ejecuta hasta iterar
var query = numeros.Where(n => n > 5);

// Con ToList() - se ejecuta inmediatamente
var lista = numeros.Where(n => n > 5).ToList();

// Con ToArray()
var array = numeros.Where(n => n > 5).ToArray();

// Encadenar con otras operaciones
var ordenados = personas
    .Where(p => p.Edad > 18)
    .OrderBy(p => p.Nombre)
    .ToList();

// Para reutilizar resultados
var pares = numeros.Where(n => n % 2 == 0).ToList();
int cantidad = pares.Count();
int suma = pares.Sum();
```

**💡 Diferencia clave:**
```csharp
// Sin materializar - se ejecuta CADA VEZ que iteras
var query = numeros.Where(n => n > 5);
foreach(var n in query) { } // Ejecuta la consulta
foreach(var n in query) { } // Ejecuta OTRA VEZ

// Materializado - se ejecuta UNA VEZ
var lista = numeros.Where(n => n > 5).ToList();
foreach(var n in lista) { } // Usa la lista en memoria
foreach(var n in lista) { } // Usa la lista en memoria (no ejecuta de nuevo)
```

---

## 💡 EXPRESIONES LAMBDA

**¿Qué son?**
Funciones anónimas que se usan en operadores LINQ.

**Sintaxis básica:**
```csharp
(parametro) => expresion
```

**Componentes:**
- **Parámetro**: Representa cada elemento de la colección
- **`=>`**: Operador lambda (se lee "va a" o "tal que")
- **Expresión**: Lo que se evalúa/retorna

**Ejemplos básicos:**
```csharp
x => x > 5              // x mayor que 5
n => n % 2 == 0         // n es par
p => p.Nombre           // Obtiene Nombre de p
s => s.Length > 10      // Longitud mayor que 10
```

**Con condiciones múltiples:**
```csharp
p => p.Edad >= 18 && p.Edad <= 65
s => s.Name == "Juan" && s.Active
pet => pet.Type == "Dog" && pet.Weight > 30
```

**Con métodos:**
```csharp
s => s.Contains("a")
w => w.StartsWith("pre")
p => "aeiou".Contains(p[0])
```

**Transformaciones:**
```csharp
n => n * 2              // Duplicar
p => p.ToUpper()        // A mayúsculas
x => new { x.Id, x.Name } // Objeto anónimo
```

---

## 📐 SINTAXIS LINQ

### Dos formas de escribir LINQ:

#### 1️⃣ Sintaxis de Métodos (más común)
```csharp
var resultado = coleccion
    .Where(x => x > 5)
    .OrderBy(x => x)
    .Select(x => x * 2)
    .ToList();
```

#### 2️⃣ Sintaxis de Consulta (tipo SQL)
```csharp
var resultado = (from x in coleccion
                 where x > 5
                 orderby x
                 select x * 2).ToList();
```

### Comparación:

| Operación | Sintaxis de Métodos | Sintaxis de Consulta |
|-----------|---------------------|----------------------|
| Filtrar | `.Where(x => x > 5)` | `where x > 5` |
| Ordenar ascendente | `.OrderBy(x => x)` | `orderby x` |
| Ordenar descendente | `.OrderByDescending(x => x)` | `orderby x descending` |
| Transformar | `.Select(x => x * 2)` | `select x * 2` |

### Operadores solo en sintaxis de métodos:
- `Count()`, `Sum()`, `Average()`, `Max()`, `Min()`
- `Any()`, `All()`, `Contains()`
- `FirstOrDefault()`, `First()`, `Last()`
- `ToList()`, `ToArray()`

**💡 Puedes mezclar ambas:**
```csharp
var resultado = (from p in personas
                 where p.Edad > 18
                 select p).Count();
```

---

## 🔑 RESUMEN DE OPERADORES LINQ

### Operadores de Agregación
Operadores que realizan cálculos sobre colecciones:

| Operador | Descripción | Retorna | Ejemplo |
|----------|-------------|---------|---------|
| **`Count()`** | Cuenta elementos | `int` | `numeros.Count(n => n > 5)` |
| **`Sum()`** | Suma valores | `int/double/decimal` | `precios.Sum()` |
| **`Average()`** | Calcula promedio | `double` | `notas.Average()` |
| **`Min()`** | Valor mínimo | Tipo elemento | `edades.Min()` |
| **`Max()`** | Valor máximo | Tipo elemento | `edades.Max()` |

### Operadores de Filtrado
Operadores que buscan o filtran elementos:

| Operador | Descripción | Retorna | Ejemplo |
|----------|-------------|---------|---------|
| **`Where()`** | Filtra elementos | `IEnumerable<T>` | `numeros.Where(n => n % 2 == 0)` |
| **`Any()`** | ¿Existe al menos uno? | `bool` | `palabras.Any(p => p.Length > 5)` |
| **`All()`** | ¿Todos cumplen? | `bool` | `numeros.All(n => n > 0)` |
| **`Contains()`** | ¿Contiene elemento? | `bool` | `lista.Contains(10)` |

### Operadores de Ordenación
Operadores que ordenan elementos:

| Operador | Descripción | Retorna | Ejemplo |
|----------|-------------|---------|---------|
| **`OrderBy()`** | Ordena ascendente | `IOrderedEnumerable<T>` | `nombres.OrderBy(n => n)` |
| **`OrderByDescending()`** | Ordena descendente | `IOrderedEnumerable<T>` | `numeros.OrderByDescending(n => n)` |

### Operadores de Selección
Operadores que obtienen elementos específicos:

| Operador | Descripción | Retorna | Ejemplo |
|----------|-------------|---------|---------|
| **`First()`** | Primer elemento (lanza excepción si no existe) | `T` | `lista.First()` |
| **`FirstOrDefault()`** | Primer elemento o valor por defecto | `T?` | `lista.FirstOrDefault(x => x > 5)` |
| **`Last()`** | Último elemento | `T` | `lista.Last()` |
| **`LastOrDefault()`** | Último elemento o valor por defecto | `T?` | `lista.LastOrDefault()` |
| **`Single()`** | Único elemento (error si hay más de uno) | `T` | `lista.Single(x => x.Id == 1)` |
| **`Select()`** | Proyecta/transforma | `IEnumerable<T>` | `personas.Select(p => p.Nombre)` |

### Operadores de Conversión
Operadores que convierten tipos de colecciones:

| Operador | Descripción | Retorna | Ejemplo |
|----------|-------------|---------|---------|
| **`ToList()`** | Convierte a lista | `List<T>` | `query.ToList()` |
| **`ToArray()`** | Convierte a array | `T[]` | `query.ToArray()` |
| **`ToDictionary()`** | Convierte a diccionario | `Dictionary<TKey, TValue>` | `lista.ToDictionary(x => x.Id)` |

---

## 📝 SINTAXIS LINQ

LINQ tiene **dos sintaxis principales** que puedes usar de forma intercambiable:

### 1️⃣ Sintaxis de Métodos (Method Syntax)
También llamada **sintaxis fluida** o **sintaxis de extensión**.

```csharp
// Ejemplo básico
var resultado = coleccion
    .Where(x => x > 5)
    .OrderBy(x => x)
    .Select(x => x * 2)
    .ToList();

// Ejemplo con objetos
var adultos = personas
    .Where(p => p.Edad >= 18)
    .OrderBy(p => p.Nombre)
    .Select(p => new { p.Nombre, p.Edad })
    .ToList();
```

**Características:**
- ✅ Más concisa y directa
- ✅ Permite encadenar métodos fácilmente
- ✅ Soporta todas las operaciones LINQ
- ✅ Preferida por muchos desarrolladores

### 2️⃣ Sintaxis de Consulta (Query Syntax)
También llamada **sintaxis comprensiva** o **sintaxis tipo SQL**.

```csharp
// Ejemplo básico
var resultado = (from x in coleccion
                 where x > 5
                 orderby x
                 select x * 2).ToList();

// Ejemplo con objetos
var adultos = (from p in personas
               where p.Edad >= 18
               orderby p.Nombre
               select new { p.Nombre, p.Edad }).ToList();
```

**Características:**
- ✅ Parecida a SQL (familiar para algunos)
- ✅ Más legible para consultas complejas
- ✅ Buena para operaciones con múltiples fuentes (joins)
- ⚠️ No soporta todas las operaciones LINQ directamente

### 📊 Comparación lado a lado:

#### Filtrado
```csharp
// Sintaxis de Métodos
var pares = numeros.Where(n => n % 2 == 0);

// Sintaxis de Consulta
var pares = from n in numeros
            where n % 2 == 0
            select n;
```

#### Ordenación
```csharp
// Sintaxis de Métodos
var ordenados = nombres.OrderBy(n => n);

// Sintaxis de Consulta
var ordenados = from n in nombres
                orderby n
                select n;
```

#### Ordenación descendente
```csharp
// Sintaxis de Métodos
var ordenados = numeros.OrderByDescending(n => n);

// Sintaxis de Consulta
var ordenados = from n in numeros
                orderby n descending
                select n;
```

#### Proyección (Select)
```csharp
// Sintaxis de Métodos
var nombres = personas.Select(p => p.Nombre);

// Sintaxis de Consulta
var nombres = from p in personas
              select p.Nombre;
```

#### Combinación de operaciones
```csharp
// Sintaxis de Métodos
var resultado = personas
    .Where(p => p.Edad > 18)
    .OrderBy(p => p.Nombre)
    .Select(p => p.Nombre);

// Sintaxis de Consulta
var resultado = from p in personas
                where p.Edad > 18
                orderby p.Nombre
                select p.Nombre;
```

### 🔄 Conversión entre sintaxis:

El compilador de C# convierte la **sintaxis de consulta** en **sintaxis de métodos** internamente.

```csharp
// Esto:
var query = from n in numeros
            where n > 5
            orderby n
            select n;

// Se convierte en esto:
var query = numeros
    .Where(n => n > 5)
    .OrderBy(n => n);
```

### 💡 ¿Cuál usar?

**Usa Sintaxis de Métodos cuando:**
- Necesites operaciones como `Count()`, `Sum()`, `Average()`, `Max()`, `Min()`
- Quieras encadenar muchas operaciones
- Prefieras código más compacto

**Usa Sintaxis de Consulta cuando:**
- Vengas de SQL y te resulte más natural
- Hagas consultas con múltiples fuentes (joins)
- La consulta sea muy compleja y quieras más legibilidad

**Puedes mezclar ambas:**
```csharp
var resultado = (from p in personas
                 where p.Edad > 18
                 orderby p.Nombre
                 select p).Count();  // Count() en sintaxis de métodos
```

### 🎯 Recomendación para el examen:
- **Aprende ambas sintaxis** porque pueden preguntarte cualquiera
- En tus proyectos se usan **ambas**, así que familiarízate con las dos
- La **sintaxis de métodos** es más común en proyectos reales

---

## 💡 EXPRESIONES LAMBDA

Las **expresiones lambda** son funciones anónimas que se usan constantemente en LINQ.

### Sintaxis básica:
```csharp
(parámetros) => expresión
```

### Componentes:
- **Parámetros**: Lo que entra (puede ser uno o varios)
- **`=>`**: Operador lambda (se lee "va a" o "produce")
- **Expresión**: Lo que se evalúa o retorna

### Ejemplos simples:

#### Lambda con un parámetro
```csharp
x => x > 5              // ¿x es mayor que 5?
n => n % 2 == 0         // ¿n es par?
p => p.Nombre           // Obtiene el nombre de p
s => s.Length           // Obtiene la longitud de s
```

#### Lambda con acceso a propiedades
```csharp
p => p.Edad >= 18                    // ¿Persona es mayor de edad?
e => e.Salario > 1000                // ¿Empleado gana más de 1000?
libro => libro.Paginas > 300         // ¿Libro tiene más de 300 páginas?
producto => producto.Stock == 0       // ¿Producto sin stock?
```

#### Lambda con múltiples condiciones
```csharp
p => p.Edad >= 18 && p.Edad <= 65    // Entre 18 y 65 años
s => s.Name == "Juan" && s.Age > 20  // Juan mayor de 20
pet => pet.Type == PetType.Dog && pet.Weight > 30
```

#### Lambda con métodos
```csharp
s => s.Contains("a")                 // ¿String contiene 'a'?
w => w.StartsWith("pre")             // ¿Palabra empieza con "pre"?
n => char.IsUpper(n[0])              // ¿Primer carácter es mayúscula?
palabra => "aeiou".Contains(char.ToLower(palabra[0]))
```

### Lambdas en contexto LINQ:

#### Con `Where()`
```csharp
// Filtrar números pares
var pares = numeros.Where(n => n % 2 == 0);

// Filtrar personas mayores de edad
var adultos = personas.Where(p => p.Edad >= 18);

// Filtrar productos en stock
var disponibles = productos.Where(p => p.Stock > 0);
```

#### Con `Any()`
```csharp
// ¿Hay algún número mayor que 100?
bool existe = numeros.Any(n => n > 100);

// ¿Hay algún perro que pese más de 36kg?
bool hayPerroPesado = mascotas.Any(m => m.Tipo == "Perro" && m.Peso > 36);
```

#### Con `All()`
```csharp
// ¿Todos son positivos?
bool todosPositivos = numeros.All(n => n > 0);

// ¿Todos los nombres contienen 'a'?
bool todosConA = nombres.All(n => n.Contains('a'));
```

#### Con `Count()`
```csharp
// Contar números pares
int cantidad = numeros.Count(n => n % 2 == 0);

// Contar personas menores de edad
int menores = personas.Count(p => p.Edad < 18);
```

#### Con `Select()`
```csharp
// Obtener solo los nombres
var nombres = personas.Select(p => p.Nombre);

// Obtener el doble de cada número
var dobles = numeros.Select(n => n * 2);

// Crear objetos anónimos
var datos = personas.Select(p => new { p.Nombre, p.Edad });
```

#### Con `OrderBy()`
```csharp
// Ordenar por edad
var ordenados = personas.OrderBy(p => p.Edad);

// Ordenar por longitud de string
var ordenados = palabras.OrderBy(p => p.Length);
```

#### Con operadores de agregación
```csharp
// Suma de salarios
var total = empleados.Sum(e => e.Salario);

// Promedio de edades
var promedio = personas.Average(p => p.Edad);

// Edad máxima
var mayor = personas.Max(p => p.Edad);

// Edad mínima
var menor = personas.Min(p => p.Edad);
```

### Lambdas con múltiples parámetros:

Algunos operadores LINQ aceptan lambdas con más de un parámetro:

```csharp
// Select con índice
var conIndice = numeros.Select((n, index) => new { Numero = n, Posicion = index });

// Where con índice
var primerosCinco = numeros.Where((n, index) => index < 5);
```

### Lambdas con bloques de código:

Para lógica más compleja, usa llaves `{}`:

```csharp
var resultado = numeros.Where(n => 
{
    var esPar = n % 2 == 0;
    var esMayorQueCinco = n > 5;
    return esPar && esMayorQueCinco;
});
```

### 🔄 Equivalencia con métodos tradicionales:

Las lambdas son versiones cortas de métodos. Estos son equivalentes:

```csharp
// Método tradicional
bool EsMayorDeEdad(Persona p)
{
    return p.Edad >= 18;
}
var adultos = personas.Where(EsMayorDeEdad);

// Lambda inline
var adultos = personas.Where(p => p.Edad >= 18);
```

### 💡 Ventajas de las lambdas:
- ✅ **Concisas**: Menos código que métodos tradicionales
- ✅ **Inline**: Se definen donde se usan
- ✅ **Legibles**: Fácil ver qué hace la operación
- ✅ **Flexibles**: Se adaptan a cualquier tipo

### 🎯 Para el examen, recuerda:

1. **Estructura básica**: `parametro => expresión`
2. **Se usan en casi todos los operadores LINQ**
3. **El parámetro representa cada elemento** de la colección
4. **Pueden acceder a propiedades**: `p => p.Nombre`
5. **Pueden tener condiciones complejas**: `p => p.Edad > 18 && p.Salario > 1000`
6. **Retornan el resultado de la expresión** automáticamente

---

## 🎓 CONSEJOS PARA EL EXAMEN

### 1. Conoce los operadores básicos:
- **Filtrado**: `Where()`, `Any()`, `All()`, `Contains()`
- **Ordenación**: `OrderBy()`, `OrderByDescending()`
- **Agregación**: `Count()`, `Sum()`, `Average()`, `Min()`, `Max()`
- **Selección**: `FirstOrDefault()`, `Select()`

### 2. Practica ambas sintaxis:
```csharp
// Sintaxis de Métodos
var resultado = coleccion.Where(x => x > 5).ToList();

// Sintaxis de Consulta
var resultado = (from x in coleccion
                 where x > 5
                 select x).ToList();
```

### 3. Recuerda las diferencias:
- **`Any()` vs `All()`**: Uno = al menos uno | Todos = todos
- **`Contains()` vs `Any()`**: Valores directos | Condiciones complejas
- **`First()` vs `FirstOrDefault()`**: Excepción | null

### 4. Practica encadenar operaciones:
```csharp
var resultado = personas
    .Where(p => p.Edad > 18)        // Filtrar
    .OrderBy(p => p.Nombre)         // Ordenar
    .Select(p => p.Nombre)          // Proyectar
    .ToList();                      // Convertir
```

### 5. Recuerda materializar cuando necesites:
```csharp
var query = numeros.Where(n => n > 5);  // No ejecutado
var lista = query.ToList();              // Ejecutado ahora
```

---

## 📚 OPERADORES LINQ NO CUBIERTOS
(Para referencia adicional)

- **`GroupBy()`**: Agrupa elementos por una clave
- **`Join()`**: Une dos colecciones
- **`Distinct()`**: Elimina duplicados
- **`Skip()` / `Take()`**: Paginación
- **`Concat()` / `Union()`**: Combina colecciones
- **`Zip()`**: Combina dos secuencias elemento por elemento

---

## ✅ CHECKLIST FINAL

- [ ] Sé qué hace cada operador básico
- [ ] Entiendo las expresiones lambda (`x => condicion`)
- [ ] Conozco la diferencia entre `Any()` y `All()`
- [ ] Sé cuándo usar `Contains()` vs `Any()`
- [ ] Puedo filtrar con `Where()`
- [ ] Sé ordenar con `OrderBy()` y `OrderByDescending()`
- [ ] Puedo usar operadores de agregación (`Count`, `Sum`, `Average`, `Max`, `Min`)
- [ ] Entiendo cómo transformar con `Select()`
- [ ] Sé cuándo usar `ToList()` o `ToArray()`
- [ ] Puedo encadenar múltiples operaciones
- [ ] Conozco ambas sintaxis (Métodos y Consulta)

---

**¡Mucha suerte en tu examen! 🍀**

*Documento creado: 10 de noviembre de 2025*


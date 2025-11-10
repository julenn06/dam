# 📚 GUÍA LINQ - RESUMEN PARA EXAMEN

## 📖 Índice
- [Operadores LINQ](#-operadores-linq)
- [Expresiones Lambda](#-expresiones-lambda)
- [Sintaxis LINQ](#-sintaxis-linq)
- [Ejemplos por Proyecto](#-ejemplos-por-proyecto)
- [Tabla Resumen](#-tabla-resumen)
- [Tips para el Examen](#-tips-para-el-examen)

---

## 🔧 OPERADORES LINQ

### Any()
**¿Qué hace?** Verifica si existe **al menos un elemento** que cumple una condición → `bool`

**Sintaxis:** `coleccion.Any(x => condicion)`

**Cuándo:** Validaciones rápidas, mejor que `Count() > 0`

**Ejemplos:**
```csharp
numeros.Any(n => n > 100)                                    // ¿Hay alguno mayor que 100?
pets.Any(p => p.Type == PetType.Dog && p.Weight >= 36)      // ¿Hay perros pesados?
palabras.Any(p => p.Contains("net"))                         // ¿Alguna contiene "net"?
```

---

### All()
**¿Qué hace?** Verifica si **TODOS** los elementos cumplen una condición → `bool`

**Sintaxis:** `coleccion.All(x => condicion)`

**Cuándo:** Validar que toda la colección cumple un requisito

**Ejemplos:**
```csharp
palabra.All(char.IsUpper)           // ¿Todas mayúsculas?
numeros.All(n => n % 2 == 0)        // ¿Todos pares?
numeros.All(n => n > 0)             // ¿Todos positivos?
```

**💡 Diferencia:** `Any()` = al menos uno | `All()` = todos sin excepción

---

### Where()
**¿Qué hace?** Filtra elementos según una condición → `IEnumerable<T>`

**Sintaxis:** `coleccion.Where(x => condicion)`

**Cuándo:** Para obtener múltiples elementos filtrados, encadenar operadores

**Ejemplos:**
```csharp
numeros.Where(n => n % 2 == 0)                    // Solo pares
personas.Where(p => p.Edad >= 18)                 // Mayores de edad
productos.Where(p => p.Stock == 0)                // Sin stock
estudiantes.Where(e => e.Nota > 6).ToList()       // Aprobados
```

---

### Count()
**¿Qué hace?** Cuenta elementos (con/sin condición) → `int`

**Sintaxis:** `coleccion.Count(x => condicion)` o `coleccion.Count()`

**Cuándo:** Estadísticas, reportes, cantidad de elementos

**Ejemplos:**
```csharp
numeros.Count(n => n % 2 == 0)                      // Contar pares
libros.Count(l => l.Paginas > 300)                  // Libros largos
personas.Count(p => p.Edad < 18)                    // Menores de edad
palabras.Count(p => "aeiou".Contains(p[0]))         // Empiezan con vocal
```

---

### Contains()
**¿Qué hace?** Busca un **valor exacto** en la colección → `bool`

**Sintaxis:** `coleccion.Contains(valor)`

**Cuándo:** Buscar valores simples (int, string, char), igualdad exacta

**Ejemplos:**
```csharp
numeros.Contains(10)          // ¿Existe el 10?
titulos.Contains("LINQ")      // ¿Existe "LINQ"?
letras.Contains('A')          // ¿Existe 'A'?
```

**💡 Diferencia:** `Contains(valor)` = valor directo | `Any(x => condicion)` = condición compleja

---

### FirstOrDefault()
**¿Qué hace?** Devuelve el primer elemento o `null` si no existe

**Sintaxis:** `coleccion.FirstOrDefault(x => condicion)`

**Cuándo:** Buscar un elemento específico, evitar excepciones

**Ejemplos:**
```csharp
pets.FirstOrDefault(p => p.Id == 5)           // Primera mascota con ID 5
numeros.FirstOrDefault(n => n > 100)          // Primer número > 100
personas.FirstOrDefault(p => p.Edad < 18)     // Primera persona menor de edad
```

⚠️ Siempre verificar null: `mascota?.Name` o `if (mascota != null)`

---

### OrderBy() / OrderByDescending()
**¿Qué hace?** Ordena ascendente/descendente → `IOrderedEnumerable<T>`

**Sintaxis:** `coleccion.OrderBy(x => x)` o `coleccion.OrderByDescending(x => x)`

**Cuándo:** Mostrar datos ordenados, antes de obtener primero/último

**Ejemplos:**
```csharp
numeros.OrderBy(n => n)                       // Menor a mayor
numeros.OrderByDescending(n => n)             // Mayor a menor
personas.OrderBy(p => p.Edad)                 // Por edad
productos.OrderByDescending(p => p.Precio)    // Por precio (caro a barato)
palabras.OrderBy(p => p.Length)               // Por longitud

// Ordenación múltiple
personas.OrderBy(p => p.Edad).ThenBy(p => p.Nombre)
```

---

### Max() / Min()
**¿Qué hace?** Devuelve el valor máximo/mínimo

**Sintaxis:** `coleccion.Max()` o `coleccion.Max(x => x.Propiedad)`

**Cuándo:** Valores extremos, estadísticas

**Ejemplos:**
```csharp
numeros.Max()                    // Número más grande
numeros.Min()                    // Número más pequeño
personas.Max(p => p.Edad)        // Edad máxima
productos.Min(p => p.Precio)     // Precio más barato
```

💡 En strings compara alfabéticamente, no por longitud

---

### Average()
**¿Qué hace?** Calcula el promedio → `double`

**Sintaxis:** `coleccion.Average()` o `coleccion.Average(x => x.Propiedad)`

**Cuándo:** Medias, estadísticas, comparaciones

**Ejemplos:**
```csharp
calificaciones.Average()                       // Promedio de notas
personas.Average(p => p.Edad)                  // Edad media
palabras.Average(p => p.Length)                // Longitud media

// Comparar con promedio
var promedio = numeros.Average();
var mayores = numeros.Where(n => n > promedio);
```

---

### Sum()
**¿Qué hace?** Suma todos los valores

**Sintaxis:** `coleccion.Sum()` o `coleccion.Sum(x => x.Propiedad)`

**Cuándo:** Totales, acumulaciones

**Ejemplos:**
```csharp
numeros.Sum()                                     // Suma total
numeros.Where(n => n % 2 == 0).Sum()              // Suma de pares
productos.Sum(p => p.Precio)                      // Total de precios
empleados.Where(e => e.Edad > 30).Sum(e => e.Salario)  // Salarios filtrados
```

---

### Select()
**¿Qué hace?** Transforma/proyecta elementos → `IEnumerable<T>`

**Sintaxis:** `coleccion.Select(x => transformacion)`

**Cuándo:** Extraer propiedades, transformar datos

**Ejemplos:**
```csharp
personas.Select(p => p.Nombre)           // Solo nombres
numeros.Select(n => n * 2)               // Duplicar valores
productos.Select(p => p.Precio)          // Solo precios
palabras.Select(p => p.ToUpper())        // A mayúsculas

// Objetos anónimos
personas.Select(p => new { p.Nombre, p.Edad })
```

**💡 Diferencia:** `Where()` filtra (reduce) | `Select()` transforma (mantiene cantidad)

---

### ToList() / ToArray()
**¿Qué hace?** Materializa la consulta (la ejecuta) → `List<T>` o `T[]`

**Sintaxis:** `consulta.ToList()` o `consulta.ToArray()`

**Cuándo:** Ejecutar inmediatamente, reutilizar resultados, evitar múltiples ejecuciones

**Ejemplos:**
```csharp
numeros.Where(n => n > 5).ToList()               // Ejecuta y guarda
personas.OrderBy(p => p.Nombre).ToArray()        // Ejecuta como array

// Reutilizar sin re-ejecutar
var pares = numeros.Where(n => n % 2 == 0).ToList();
int cantidad = pares.Count();
int suma = pares.Sum();
```

---

## 💡 EXPRESIONES LAMBDA

**Sintaxis:** `parametro => expresion`

**Ejemplos:**
```csharp
x => x > 5                          // Condición simple
n => n % 2 == 0                     // Es par
p => p.Nombre                       // Acceso a propiedad
p => p.Edad >= 18 && p.Activo       // Múltiples condiciones
s => s.Contains("a")                // Con método
n => n * 2                          // Transformación
```

---

## 📐 SINTAXIS LINQ

### Sintaxis de Métodos (más común)
```csharp
coleccion.Where(x => x > 5).OrderBy(x => x).ToList();
```

### Sintaxis de Consulta (tipo SQL)
```csharp
(from x in coleccion
 where x > 5
 orderby x
 select x).ToList();
```

**💡 Operadores solo en Métodos:** `Count()`, `Sum()`, `Average()`, `Max()`, `Min()`, `Any()`, `All()`, `Contains()`, `FirstOrDefault()`, `ToList()`, `ToArray()`

---

## 📚 EJEMPLOS POR PROYECTO

**ARIKETA01 - FirstOrDefault()** → `pets.FirstOrDefault(p => p.Id == 5)`

**ARIKETA02 - Any()** → `pets.Any(p => p.Type == PetType.Dog && p.Weight >= 36)`

**ARIKETA04 - Count()** → `numeros.Count(n => n % 2 == 0)` | `libros.Count(l => l.Paginas > 300)`

**ARIKETA05 - Contains()** → `numeros.Contains(10)` | `personas.Any(p => p.Nombre == "Luis")`

**ARIKETA06 - OrderBy()** → `numeros.OrderBy(n => n)` | `productos.OrderByDescending(p => p.Precio)`

**ARIKETA07 - Max()/Min()** → `numeros.Max()` | `personas.Max(p => p.Edad)` | `productos.Min(p => p.Precio)`

**ARIKETA08 - Average()** → `calificaciones.Average()` | `personas.Average(p => p.Edad)`

**ARIKETA09 - Sum()** → `numeros.Sum()` | `productos.Sum(p => p.Precio)` | `numeros.Where(n => n % 2 == 0).Sum()`

---

## 🎯 TABLA RESUMEN

| Operador | Retorna | Uso | Ejemplo |
|----------|---------|-----|---------|
| **Any()** | `bool` | ¿Existe al menos uno? | `numeros.Any(n => n > 100)` |
| **All()** | `bool` | ¿Todos cumplen? | `numeros.All(n => n > 0)` |
| **Where()** | `IEnumerable<T>` | Filtrar | `numeros.Where(n => n % 2 == 0)` |
| **Count()** | `int` | Contar | `numeros.Count(n => n > 5)` |
| **Contains()** | `bool` | Buscar valor exacto | `numeros.Contains(10)` |
| **FirstOrDefault()** | `T?` | Primer elemento o null | `lista.FirstOrDefault(x => x > 5)` |
| **OrderBy()** | `IOrderedEnumerable<T>` | Ordenar ↑ | `numeros.OrderBy(n => n)` |
| **OrderByDescending()** | `IOrderedEnumerable<T>` | Ordenar ↓ | `numeros.OrderByDescending(n => n)` |
| **Max()** | Tipo elemento | Valor máximo | `numeros.Max()` |
| **Min()** | Tipo elemento | Valor mínimo | `numeros.Min()` |
| **Average()** | `double` | Promedio | `numeros.Average()` |
| **Sum()** | Tipo numérico | Suma total | `numeros.Sum()` |
| **Select()** | `IEnumerable<T>` | Transformar | `personas.Select(p => p.Nombre)` |
| **ToList()** | `List<T>` | Materializar | `query.ToList()` |

---

## ⚡ TIPS

### Diferencias clave:
- **`Any()` vs `All()`** → Uno vs Todos
- **`Contains()` vs `Any()`** → Valores simples vs Condiciones
- **`Where()` vs `Select()`** → Filtrar vs Transformar

### Cuándo usar cada uno:
- **¿Existe?** → `Any()` o `Contains()`
- **¿Cuántos?** → `Count()`
- **¿Cuánto suma?** → `Sum()`
- **¿Promedio?** → `Average()`
- **¿Mayor/Menor?** → `Max()` / `Min()`
- **Filtrar** → `Where()`
- **Ordenar** → `OrderBy()` / `OrderByDescending()`
- **Transformar** → `Select()`
- **Ejecutar** → `ToList()` / `ToArray()`

### Encadenar operaciones:
```csharp
personas
    .Where(p => p.Edad > 18)      // Filtrar
    .OrderBy(p => p.Nombre)        // Ordenar
    .Select(p => p.Nombre)         // Transformar
    .ToList();                     // Ejecutar
```

### Recuerda materializar:
```csharp
var query = numeros.Where(n => n > 5);  // No ejecutado
var lista = query.ToList();              // Ejecutado
```
